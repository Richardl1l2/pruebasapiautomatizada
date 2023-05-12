package com.productoscredito.stepDefinitions;


import com.productoscredito.utils.Task.GetMostrarEmpleados;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import java.io.IOException;

public class MostrarEmpleadosStep {

    @Given("Se accede en la direccion de la api")
    public void se_accede_en_la_direccion_de_la_api() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
    }
    @When("Se envia peticion para traer archivo json con todos los empleados")
    public void se_envia_peticion_para_traer_archivo_json_con_todos_los_empleados() throws IOException {
        GetMostrarEmpleados.getmostrarEmpleados();
    }
    @Then("Se compara el json actual con el json de la api")
    public void se_compara_el_json_actual_con_el_json_de_la_api() {
     GetMostrarEmpleados.respuesta();
    }





}
