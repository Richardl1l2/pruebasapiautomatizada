package com.productoscredito.stepDefinitions;

import com.productoscredito.utils.Task.PutModificarEmpleado;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;

import static com.productoscredito.utils.Task.PutModificarEmpleado.putmodificarEmpleados;


public class ModificarEmpleadoStep {

    private Response response;

    @Given("Se envia peticion para realizar modificacion")
    public void se_envia_peticion_para_realizar_modificacion() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
    }
    @When("Se modifica el id de usuario selecionado")
    public void se_modifica_el_id_de_usuario_selecionado() throws IOException {
        response = putmodificarEmpleados();

    }
    @Then("Se verifica que la modificacion se haga efectiva")
    public void se_verifica_que_la_modificacion_se_haga_efectiva() throws IOException {
        String responseBody = response.getBody().asString();
        int statusCode = response.getStatusCode();
        System.out.println("RESPONSE BODY: " + responseBody);
        Assert.assertEquals(statusCode, 200);
        Assert.assertTrue(responseBody.contains("update successful"));
    }
}
