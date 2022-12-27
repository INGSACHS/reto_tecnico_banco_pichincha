package co.com.bancopichincha.retotecnico.interactions;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavegarA implements Interaction {

    private EnvironmentVariables ambiente;

    @Override
    @Step("{0} navega a la página de SAUCEDEMO")
    public <T extends Actor> void performAs(T actor) {
        String url = EnvironmentSpecificConfiguration.from(ambiente).getProperty("base.url.swaglabs");
        actor.wasAbleTo(
                Open.url(url)
        );
    }

    public static NavegarA laPaginaDeSwagLabs() {
        return instrumented(NavegarA.class);
    }

}