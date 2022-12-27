package co.com.bancopichincha.retotecnico.runners.web;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/web/proceso_de_compra.feature",
        glue = "co.com.bancopichincha.retotecnico.stepdefinitions"
)
public class ProcesoDeCompra {
}
