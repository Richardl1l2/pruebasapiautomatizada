package com.productoscredito.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = "com.productoscredito.stepDefinitions",
        features = "src/test/resources/com/productoscredito/features/ObtenerDatosAsociado.feature"
)
public class ObtenerDatosAsociadoStepRunner {
}
