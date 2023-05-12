package com.productoscredito.utils.Task;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;


public class PostCrearEmpleado {

    public static void postEmpleado() throws IOException {
       JSONObject requestParams = new JSONObject();
        requestParams.put("name", "pedro");
        requestParams.put("salary", "142614");
        requestParams.put("age", "23");
       RequestSpecification requestSpecification = RestAssured.given().contentType("application/json")
               .header("Cookie", "XSRF-TOKEN=eyJpdiI6IjdkbkRUcU44akFsZHNqYzFVUXBJemc9PSIsInZhbHVlIjoiMXZyNEMxK0J6ZFdEcjRQYWcwTGQzSkMvRVRWNW9LTWF0NFpIZjlnTVRmd0tUbWFQQXNLZUEyVDF2Vm5xN0ZsOCIsIm1hYyI6ImZkODUxZTUwNDhhY2RjZWY2YWQwZjBjYTRlNTE5MWQyNDAwZTFjODY1NzMxY2E5ZGRlOGE0MzhiZTZjNTNiZDgifQ%3D%3D; laravel_session=eyJpdiI6Iit1M1FxUVRKb0xTVVhDUGlaaUxHRnc9PSIsInZhbHVlIjoiNEdBQ05OWFJhN05kVUlVMm4ycHdjSURpWmdaOXpnSFNSK0xDM290dVRrTFNPSHJYOGNHRXBOVWRGSjd5bzQwbyIsIm1hYyI6IjcwN2Q4ZDA2NTQ1MzY1YzNlYzYyYzZhMjhiNTNjZmVlZTNmNmQ4M2RhMTdlNzRlNDkxNzkxNzU0MDg2NWI4ZWQifQ%3D%3D");
       Response response = requestSpecification.post("create");
       String cuerpoRespuesta = response.getBody().asString();
        System.out.println("RESPUESTA+++++"+cuerpoRespuesta);
        JsonPath jsonResponse = response.jsonPath();
        String jsonStr = jsonResponse.prettify();
        try (FileWriter writer = new FileWriter("src/test/resources/com/productoscredito/testData/ObtenerCrearEmpleadoJson/response.json") ) {
            writer.write(jsonStr);
        }
   }

    public static void respuesta(){

        Path expectedPath1 = Paths.get("src", "test", "resources", "com", "productoscredito", "testData", "ObtenerCrearEmpleadoJson/", "expectedresponse.json");
        JsonPath expectedJson2 = JsonPath.from(new File(expectedPath1.toUri()));
        String expected = expectedJson2.prettify();


        Path responsePath = Paths.get("src", "test", "resources", "com", "productoscredito", "testData", "ObtenerCrearEmpleadoJson/", "response.json");
        JsonPath responseJson = JsonPath.from(new File(responsePath.toUri()));
        String actual = responseJson.prettify();
        assertEquals(actual, expected);
    }




}
