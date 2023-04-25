package com.productoscredito.stepDefinitions;



import com.productoscredito.utils.Task.PostCrearToken;
import com.productoscredito.utils.Task.PostObtenerLineasCredito;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;


public class ObtenerLineasCreditoStep {

    @Given("que el usuario ha iniciado sesion en la aplicacion")
    public String que_el_usuario_ha_iniciado_sesion_en_la_aplicacion() {
        String token = PostCrearToken.getToken();
        return token;
    }
    @When("el usuario solicita la lista de creditos radicados")
    public RequestSpecification el_usuario_solicita_la_lista_de_creditos_radicados() throws IOException {
        String token = que_el_usuario_ha_iniciado_sesion_en_la_aplicacion();
        RequestSpecification requestSpecification = PostObtenerLineasCredito.postLineaCredito(token);
        return requestSpecification;
    }
    @Then("la aplicacion devuelve una lista de todos los creditos radicados")
    public void la_aplicacion_devuelve_una_lista_de_todos_los_creditos_radicados() throws IOException {
        PostObtenerLineasCredito.respuestaesperada(el_usuario_solicita_la_lista_de_creditos_radicados());

    }



}


