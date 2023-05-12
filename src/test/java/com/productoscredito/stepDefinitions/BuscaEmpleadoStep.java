package com.productoscredito.stepDefinitions;


import com.productoscredito.utils.Task.GetBuscarEmpleado;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import java.io.IOException;


public class BuscaEmpleadoStep {

    @Given("Se accede en la direccion de la api empledos id")
    public void se_accede_en_la_direccion_de_la_api_empledos_id() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
    }
    @When("Se envia peticion para traer ejecutar la consulta del empleado")
    public void se_envia_peticion_para_traer_ejecutar_la_consulta_del_empleado() throws IOException {
        GetBuscarEmpleado.getBuscarPorId();
    }
    @Then("Se compara que la informacion del empelado consultada sea correcta")
    public void se_compara_que_la_informacion_del_empelado_consultada_sea_correcta() throws IOException {
            //pendiente
    }

}
