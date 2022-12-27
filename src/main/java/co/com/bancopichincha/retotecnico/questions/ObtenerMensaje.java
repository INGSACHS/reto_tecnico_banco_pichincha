package co.com.bancopichincha.retotecnico.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.bancopichincha.retotecnico.userinterfaces.CheckoutPage.LBL_COMPLETE_CHECKOUT;

public class ObtenerMensaje implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return LBL_COMPLETE_CHECKOUT.resolveFor(actor).getText();
    }

    public static ObtenerMensaje compraExitosa() {
        return new ObtenerMensaje();
    }

}

