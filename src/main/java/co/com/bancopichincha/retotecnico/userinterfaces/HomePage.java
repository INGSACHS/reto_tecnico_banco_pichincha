package co.com.bancopichincha.retotecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    private HomePage() {
    }

    public static final Target TXT_USERNAME = Target.the("Input Username")
            .locatedBy("//input[@id='user-name']");

    public static final Target TXT_PASSWORD = Target.the("Input Password")
            .locatedBy("//input[@id='password']");

    public static final Target BTN_LOGIN_BUTTON = Target.the("Logín Button")
            .locatedBy("//input[@id='login-button']");


}
