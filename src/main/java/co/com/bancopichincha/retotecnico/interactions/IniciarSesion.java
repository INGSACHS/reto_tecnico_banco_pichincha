package co.com.bancopichincha.retotecnico.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static co.com.bancopichincha.retotecnico.userinterfaces.HomePage.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IniciarSesion implements Interaction {

    private Properties propiedades;

    public IniciarSesion() throws IOException {
        propiedades = new Properties();
        propiedades.load(new FileReader("serenity.properties"));
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String usuario = propiedades.getProperty("usuario_swaglabs");
        String password = propiedades.getProperty("password_swaglabs");
        actor.wasAbleTo(
                Enter.theValue(usuario).into(TXT_USERNAME),
                Enter.theValue(password).into(TXT_PASSWORD),
                Click.on(BTN_LOGIN_BUTTON)
        );
    }

    public static IniciarSesion enElAplicativo() {
        return instrumented(IniciarSesion.class);
    }

}
