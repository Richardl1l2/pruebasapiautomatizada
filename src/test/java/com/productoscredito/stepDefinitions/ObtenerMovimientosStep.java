package com.productoscredito.stepDefinitions;

import com.productoscredito.utils.Task.PostCrearToken;
import com.productoscredito.utils.Task.PostObtenerMovimientos;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.io.IOException;
import java.util.List;
import static com.productoscredito.utils.Task.PostObtenerMovimientos.*;



public class ObtenerMovimientosStep{

    @Given("que la API esta en linea para ingresar")
    public String que_la_api_esta_en_linea_para_ingresar() {
        String token = PostCrearToken.getToken();
        return token;
    }
    @When("obtengo los movimientos de la API")
    public String obtengo_los_movimientos_de_la_api() throws IOException {
        String token = que_la_api_esta_en_linea_para_ingresar();
            postMovimientos(token);
        return token;
    }
    @Then("movimientos de la API  k_transa, k_numdoc")
    public void movimientos_de_la_api_k_transa_v_k_numdoc() throws IOException {
        List<String> datosTransaccion1 = PostObtenerMovimientos.datosTransaccionactual;
        List<String> datosTransaccion2 = PostObtenerMovimientos.datosTransaccion2;
            Assert.assertEquals(datosTransaccion2,datosTransaccion1);

    }

}
