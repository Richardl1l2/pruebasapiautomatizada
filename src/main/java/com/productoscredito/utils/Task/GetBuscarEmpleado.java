package com.productoscredito.utils.Task;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import java.io.IOException;



public class GetBuscarEmpleado {

    public static void getBuscarPorId() throws IOException {
        Response response = (Response) RestAssured.given().relaxedHTTPSValidation().when().get("employee/1");
        String cuerpoRespuesta = response.getBody().asString();
        System.out.println("RESPUESTA+++++"+cuerpoRespuesta);

        }


   }




