package com.productoscredito.stepDefinitions;

import com.productoscredito.utils.Task.Constantes;
import com.productoscredito.utils.Task.GetObtenerUbicaciones;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.junit.Assert;

public class ObtenerUbicacionesStep {

    @Given("se conecta la API")
    public void se_conecta_la_api() {RestAssured.baseURI= Constantes.getLinkAPI();
    }
    @When("se solicita la consulta del departamento")
    public void se_solicita_la_consulta_del_departamento() {
                GetObtenerUbicaciones.obtenerUbicaciones();

    }
    @Then("la aplicación devuelve una lista de ciudades nombreDepartamento: {string}")
    public String la_aplicación_devuelve_una_lista_de_ciudades_nombre_departamento(String departamento) {
        String nombreDepartamento = GetObtenerUbicaciones.validarDepartamento();
        Assert.assertEquals(departamento, nombreDepartamento);
        return nombreDepartamento;
    }




}
