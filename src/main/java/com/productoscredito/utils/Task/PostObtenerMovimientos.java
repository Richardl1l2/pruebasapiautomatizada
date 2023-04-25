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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class PostObtenerMovimientos extends  Constantes {

    public static List<String> datosTransaccionactual = new ArrayList<String>();
    public static List<String> datosTransaccion2 = new ArrayList<String>();
    public static RequestSpecification postMovimientos(String token) throws IOException {
        JSONObject requestParams = new JSONObject();
        requestParams.put("token", token);
        requestParams.put("cedula", getCedula());
        requestParams.put("basicEncodeClient", getBasicEncodeClient());
        RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation().baseUri(LinkAPI1).contentType("application/json").body(requestParams.toJSONString());
        Response response = requestSpecification.post("obtenerMovimientos");
 
        String k_transaActual = response.jsonPath().get("resultado[0].k_transa");
        String k_numdocActual = response.jsonPath().get("resultado[0].k_numdoc");
        datosTransaccionactual.add(k_transaActual);
        datosTransaccionactual.add(k_numdocActual);
        datosTransaccion2.add(k_transa);
        datosTransaccion2.add(k_numdoc);

        JsonPath jsonResponse = response.jsonPath();
        String jsonStr = jsonResponse.prettify();
       try (FileWriter writer = new FileWriter("src/test/resources/com/productoscredito/testData/ObtenerMovimientosJson/response.json") ) {
            writer.write(jsonStr);
        }
                return requestSpecification;
    }


}

