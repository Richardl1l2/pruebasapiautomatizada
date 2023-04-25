package com.productoscredito.utils.Task;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Assert;
import java.util.List;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;


public class PostObtenerLineasCredito extends  Constantes {
    public static RequestSpecification postLineaCredito(String token) throws IOException {
        JSONObject requestParams = new JSONObject();
        requestParams.put("token", token);
        requestParams.put("cedula", getCedula());
        requestParams.put("basicEncodeClient", getBasicEncodeClient());
        RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation().baseUri(LinkAPI).contentType("application/json").body(requestParams.toJSONString());
        Response response = requestSpecification.post("obtenerLineasCredito");
        JsonPath jsonResponse = response.jsonPath();
        String jsonStr = jsonResponse.prettify();

        try (FileWriter writer = new FileWriter("src/test/resources/com/productoscredito/testData/ObtenerLineasCreditoJson/response.json") ) {
            writer.write(jsonStr);
        }

            return requestSpecification;
        }

        public static void respuestaesperada (RequestSpecification requestSpecification){
            Response response = requestSpecification.post("obtenerLineasCredito");

            List<Map<String, Object>> lineasCredito = response.jsonPath().getList("resultado");
            Map<String, Object> lineaCredito = null;
            for (Map<String, Object> lc : lineasCredito) {
                if (lc.get("idLineaCredito").equals("006") && lc.get("nombreLineaCredito").equals("Unificación de créditos")) {
                    lineaCredito = lc;
                    break;
                }
            }
            Assert.assertEquals("006", lineaCredito.get("idLineaCredito"));
            Assert.assertEquals("Unificación de créditos", lineaCredito.get("nombreLineaCredito"));
        }
    }
