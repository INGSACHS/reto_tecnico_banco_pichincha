package co.com.bancopichincha.retotecnico.runners.api;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/api/registro_actualizacion_datos_mascota.feature",
        glue = "co.com.bancopichincha.retotecnico.stepdefinitions"
)
public class RegistroAcutalizacionDatosMascota {
}
