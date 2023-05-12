package com.productoscredito.utils.Task;

import io.restassured.RestAssured;
import io.restassured.response.Response;


import java.io.IOException;


public class DeleteBorrarEmpleado {
    public static Response deleteEmpleado() throws IOException {
        Response response = RestAssured.given().relaxedHTTPSValidation().delete("delete/3");
        return  response;
    }





}
