package com.productoscredito.utils.Task;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostCrearToken extends Constantes {

    public static String getToken(){
       RequestSpecification requestSpecification = RestAssured.given().relaxedHTTPSValidation().contentType("application/x-www-form-urlencoded").formParams("grant_type", "password", "username", getUsuario(), "password", getContrasena(), "scope", getScope())
               .header("Authorization", "Basic aU9mTjNCM0RwdW56dGRWbWh4Q3hIblZpQVpvYTpla1A1SjFvUlpmQ0E1YjhEVHpCMGRRWU5SSWdh")
               .cookie("route=1681133953.148.596.777682")
               .auth().preemptive().basic("iOfN3B3DpunztdVmhxCxHnViAZoa", "ekP5J1oRZfCA5b8DTzB0dQYNRIga");
       Response response = requestSpecification.post();
       String cuerpoRespuesta = response.getBody().asString();
       String token = JsonPath.with(cuerpoRespuesta).get("access_token");

       return token;

   }


}
