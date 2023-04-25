package com.productoscredito.stepDefinitions;

import com.productoscredito.utils.Task.PostCrearToken;
import com.productoscredito.utils.Task.PostObtenerCreditoRadicado;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class ObtenerCreditosRadicadosStep {

    @Given("que la API está en línea")
    public String que_la_api_está_en_línea() {
       String token = PostCrearToken.getToken();
        return token;
    }
    @When("obtengo las líneas de crédito de la API")
    public void obtengo_las_líneas_de_crédito_de_la_api() throws IOException {
        String token = que_la_api_está_en_línea();
        PostObtenerCreditoRadicado.creditoradicado(token);
    }
    @Then("debería recibir una respuesta con las líneas de crédito de la API correspondientes")
    public void debería_recibir_una_respuesta_con_las_líneas_de_crédito_de_la_api_correspondientes() {
        PostObtenerCreditoRadicado.respuestaesperada();
    }

}
