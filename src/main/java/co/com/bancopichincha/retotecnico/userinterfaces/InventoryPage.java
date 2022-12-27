package co.com.bancopichincha.retotecnico.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class InventoryPage {

    private InventoryPage() {
    }

    public static final Target BTN_ADD_TO_CART = Target.the("ADD TO CART BUTTON")
            .locatedBy("//button[@id='{0}']");

    public static final Target LNK_SHOPPING_CART = Target.the("SHOPPING CART LINK")
            .locatedBy("//a[@class='shopping_cart_link']");

}
