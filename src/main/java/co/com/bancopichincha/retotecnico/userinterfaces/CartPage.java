package co.com.bancopichincha.retotecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {

    private CartPage() {
    }

    public static final Target BTN_CHECKOUT = Target.the("CHECKOUT BUTTON")
            .locatedBy("//button[@id='checkout']");

}
