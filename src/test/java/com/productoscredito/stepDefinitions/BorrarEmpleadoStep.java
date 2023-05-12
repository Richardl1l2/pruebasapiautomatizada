package com.productoscredito.stepDefinitions;

import com.productoscredito.utils.Task.DeleteBorrarEmpleado;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;


public class BorrarEmpleadoStep{
    private Response response;

    @Given("Se envia peticion para eliminar usuario")
    public void se_envia_peticion_para_eliminar_usuario() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
    }
    @When("Se procede a borrar el usuario con el id a eliminar")
    public void se_procede_a_borrar_el_usuario_con_el_id_a_eliminar() throws IOException {
         response = DeleteBorrarEmpleado.deleteEmpleado();
    }
    @Then("Se verifica el usuario eliminado de forma correcta")
    public void se_verifica_el_usuario_eliminado_de_forma_correcta() throws IOException {
        String cuerpoRespuesta = response.getBody().asString();
        System.out.println("RESPUESTA+++++"+cuerpoRespuesta);
        Assert.assertEquals(200, response.getStatusCode());
    }


}
