package com.productoscredito.utils.Task;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetObtenerUbicaciones extends Constantes {

    public static Response obtenerUbicaciones() {
       Response response = (Response) RestAssured.given().relaxedHTTPSValidation().when().get("obtenerUbicaciones");
       return response;
    }

    public static String validarDepartamento() {
        Response response = obtenerUbicaciones();
        String nombreDepartamento = response.jsonPath().get("resultado.paises[0].departamentos[0].nombreDepartamento");

        return nombreDepartamento;
    }



}





