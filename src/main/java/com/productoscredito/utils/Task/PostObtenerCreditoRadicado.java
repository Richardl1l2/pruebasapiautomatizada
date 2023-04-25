package com.productoscredito.utils.Task;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class PostObtenerCreditoRadicado extends Constantes {

    public static int creditoradicado (String token) throws IOException {
        JSONObject requestParams = new JSONObject();
        requestParams.put("token", token);
        requestParams.put("cedula", getCedula());
        requestParams.put("basicEncodeClient", getBasicEncodeClient());
        RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation().baseUri(LinkAPI).contentType("application/json").body(requestParams.toJSONString());
        Response response = requestSpecification.post("obtenerCreditosRadicados");
        int statusCode = response.getStatusCode();


        JsonPath jsonResponse = response.jsonPath();
        String jsonStr = jsonResponse.prettify();
        try (FileWriter writer = new FileWriter("src/test/resources/com/productoscredito/testData/ObtenerCreditoRadicadoJson/response.json") ) {
            writer.write(jsonStr);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return statusCode;

    }

    public static void respuestaesperada() {

        Path expectedPath = Paths.get("src", "test", "resources", "com", "productoscredito", "testData", "ObtenerCreditoRadicadoJson", "expectedresponse.json");
        Path responsePath = Paths.get("src", "test", "resources", "com", "productoscredito", "testData", "ObtenerCreditoRadicadoJson", "response.json");

        JsonPath expectedJson = JsonPath.from(new File(expectedPath.toUri()));
        String expected = expectedJson.prettify();

        JsonPath responseJson = JsonPath.from(new File(responsePath.toUri()));
        String actual = responseJson.prettify();

        assertEquals(actual, expected);
    }




}
