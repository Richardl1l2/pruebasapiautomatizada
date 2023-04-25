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

public class PostObtenerDatosAsociado extends Constantes {

    public static int datosasociado (String token) throws IOException {
        JSONObject requestParams = new JSONObject();
        requestParams.put("token", token);
        requestParams.put("cedula", getCedula());
        requestParams.put("basicEncodeClient", getBasicEncodeClient());
        RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation().baseUri(LinkAPI).contentType("application/json").body(requestParams.toJSONString());
        Response response = requestSpecification.post("obtenerDatosAsosiado");
        int statusCode = response.getStatusCode();

        JsonPath jsonResponse = response.jsonPath();
        String jsonStr = jsonResponse.prettify();
        try (FileWriter writer = new FileWriter("src/test/resources/com/productoscredito/testData/ObtenerDatosAsociadoJson/response.json") ) {
            writer.write(jsonStr);
        }

        return statusCode;

    }
    public static void respuesta(){

        Path expectedPath1 = Paths.get("src", "test", "resources", "com", "productoscredito", "testData", "ObtenerDatosAsociadoJson", "expectedresponse.json");
        JsonPath expectedJson2 = JsonPath.from(new File(expectedPath1.toUri()));
        String expected = expectedJson2.prettify();


        Path responsePath = Paths.get("src", "test", "resources", "com", "productoscredito", "testData", "ObtenerDatosAsociadoJson", "response.json");
        JsonPath responseJson = JsonPath.from(new File(responsePath.toUri()));
        String actual = responseJson.prettify();

         assertEquals(actual, expected);

    }


}
