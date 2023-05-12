package com.productoscredito.utils.Task;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;


public class PutModificarEmpleado {

    public static Response putmodificarEmpleados() throws IOException {
        Response response = RestAssured.given().relaxedHTTPSValidation().when().get("update/4");
        String cuerpoRespuesta = response.getBody().asString();
        System.out.println("RESPUESTA+++++"+cuerpoRespuesta);

        return response;
        }
   }




