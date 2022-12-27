package co.com.bancopichincha.retotecnico.stepdefinitions.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.actors.OnStage.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class Hook {

    private EnvironmentVariables ambiente;

    @Before
    public void crearEscenario() {
        setTheStage(new OnlineCast());
        theActorCalled("Usuario");
        String urlApi = EnvironmentSpecificConfiguration.from(ambiente).getProperty("base.url.petstore");
        theActorInTheSpotlight().whoCan(CallAnApi.at(urlApi));
    }

    @After
    public void cerrarNavegador() {
        getDriver().quit();
    }

}
