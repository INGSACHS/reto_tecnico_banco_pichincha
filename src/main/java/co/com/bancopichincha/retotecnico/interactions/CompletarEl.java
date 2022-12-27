package co.com.bancopichincha.retotecnico.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import java.util.Map;

import static co.com.bancopichincha.retotecnico.userinterfaces.CheckoutPage.*;

public class CompletarEl implements Interaction {

    private final Map<String, String> datosPersonales;

    public CompletarEl(Map<String, String> datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(datosPersonales.get("primer_nombre")).into(TXT_FIRST_NAME),
                Enter.theValue(datosPersonales.get("primer_apellido")).into(TXT_LAST_NAME),
                Enter.theValue(datosPersonales.get("codigo_postal")).into(TXT_POSTAL_CODE),
                Click.on(BTN_CONTINUE),
                Scroll.to(BTN_FINISH),
                Click.on(BTN_FINISH)
        );
    }

    public static CompletarEl formularioDeCompra(Map<String, String> datosPersonales) {
        return Instrumented.instanceOf(CompletarEl.class)
                .withProperties(datosPersonales);
    }

}
