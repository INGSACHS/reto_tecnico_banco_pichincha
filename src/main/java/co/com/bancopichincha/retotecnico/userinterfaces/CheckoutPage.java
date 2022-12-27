package co.com.bancopichincha.retotecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CheckoutPage {

    private CheckoutPage() {
    }

    public static final Target TXT_FIRST_NAME = Target.the("Input First Name")
            .locatedBy("//input[@id='first-name']");

    public static final Target TXT_LAST_NAME = Target.the("Input Last Name")
            .locatedBy("//input[@id='last-name']");

    public static final Target TXT_POSTAL_CODE = Target.the("Input Postal Code")
            .locatedBy("//input[@id='postal-code']");

    public static final Target BTN_CONTINUE = Target.the("Button Continue")
            .locatedBy("//input[@id='continue']");

    public static final Target BTN_FINISH = Target.the("Button Finish")
            .locatedBy("//button[@id='finish']");

    public static final Target LBL_COMPLETE_CHECKOUT = Target.the("Label Checkout Complete")
            .locatedBy("//h2[@class='complete-header']");

}
