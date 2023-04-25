package com.productoscredito.stepDefinitions;

import com.productoscredito.utils.Task.PostCrearToken;
import com.productoscredito.utils.Task.PostObtenerDatosAsociado;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;

public class ObtenerDatosAsociadoStep {
    @Given("que la API esta en linea para acceder")
    public String que_la_api_esta_en_linea_para_acceder() {
        String token = PostCrearToken.getToken();
        return token;
    }
    @When("obtengo los datos del asociado de la API con el cedula del asociado {string}")
    public void obtengo_los_datos_del_asociado_de_la_api_con_el_cedula_del_asociado(String string) throws IOException {
        String token = que_la_api_esta_en_linea_para_acceder();
        PostObtenerDatosAsociado.datosasociado(token);
    }
    @Then("deberia recibir una respuesta con los datos del asociado correspondientes cedula, primerApellido, segundoApellido, email")
    public void deberia_recibir_una_respuesta_con_los_datos_del_asociado_correspondientes_cedula_primer_apellido_segundo_apellido_email() {
      PostObtenerDatosAsociado.respuesta();
    }



}
