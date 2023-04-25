package com.productoscredito.stepDefinitions;


import com.productoscredito.utils.Task.PostCrearToken;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.json.simple.parser.ParseException;
import java.io.*;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;

public class CrearTokenStep {
    @Before
    public void setup() {
        setTheStage(new OnlineCast());
       RestAssured.baseURI = "https://servicioidentidad-pru.presente.com.co/oauth2/token";
    }

    @Given("Ingresa las credenciales del usuario")
    public void ingresa_las_credenciales_del_usuario() {

    }
    @When("Se ingresa la informacion para generar el token")
    public void se_ingresa_la_informacion_para_generar_el_token() throws IOException, ParseException {
    PostCrearToken.getToken();
    }
    @Then("Se verifica que se recibio el token")
    public void se_verifica_que_se_recibio_el_token(){

    }

}
