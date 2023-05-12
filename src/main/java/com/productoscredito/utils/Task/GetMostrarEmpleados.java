package com.productoscredito.utils.Task;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;


public class GetMostrarEmpleados {

    private String actual;
    private String expected;

    public static void getmostrarEmpleados() throws IOException {
        Response response = (Response) RestAssured.given().relaxedHTTPSValidation().when().get("employees");
       String cuerpoRespuesta = response.getBody().asString();
        System.out.println("RESPUESTA+++++"+cuerpoRespuesta);

        JsonPath jsonResponse = response.jsonPath();
        String jsonStr = jsonResponse.prettify();
        try (FileWriter writer = new FileWriter("src/test/resources/com/productoscredito/testData/ObtenerMostrarEmpleadosJson/response.json") ) {
            writer.write(jsonStr);
        }

   }
    public static void respuesta(){

        Path expectedPath1 = Paths.get("src", "test", "resources", "com", "productoscredito", "testData", "ObtenerMostrarEmpleadosJson", "expectedresponse.json");
        JsonPath expectedJson2 = JsonPath.from(new File(expectedPath1.toUri()));
        String expected = expectedJson2.prettify();


        Path responsePath = Paths.get("src", "test", "resources", "com", "productoscredito", "testData", "ObtenerMostrarEmpleadosJson", "response.json");
        JsonPath responseJson = JsonPath.from(new File(responsePath.toUri()));
        String actual = responseJson.prettify();
        assertEquals(actual, expected);
    }



}
