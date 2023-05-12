package com.productoscredito.stepDefinitions;


import com.productoscredito.utils.Task.PostCrearEmpleado;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import java.io.IOException;

public class CrearEmpleadoStep {

    @Given("Se envia peticion para creacion empleado")
    public void se_envia_peticion_para_creacion_empleado() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
    }
    @When("Se crea el empleado")
    public void se_crea_el_empleado() throws IOException {
        PostCrearEmpleado.postEmpleado();
    }
    @Then("Se verifica el empelado creado")
    public void se_verifica_el_empelado_creado() {
        PostCrearEmpleado.respuesta();
    }


}
