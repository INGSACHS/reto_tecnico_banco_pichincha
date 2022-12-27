package co.com.bancopichincha.retotecnico.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.bancopichincha.retotecnico.userinterfaces.CartPage.BTN_CHECKOUT;
import static co.com.bancopichincha.retotecnico.userinterfaces.InventoryPage.BTN_ADD_TO_CART;
import static co.com.bancopichincha.retotecnico.userinterfaces.InventoryPage.LNK_SHOPPING_CART;
import static co.com.bancopichincha.retotecnico.utils.ObtenerIdentificadorProducto.ObtenerIdentificadorProductoIndividual;

public class AgregarLosProductos implements Interaction {

    private final String productoUno;
    private final String productoDos;

    public AgregarLosProductos(String productoUno, String productoDos) {
        this.productoUno = productoUno;
        this.productoDos = productoDos;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_ADD_TO_CART.of(productoUno)),
                Click.on(BTN_ADD_TO_CART.of(productoDos)),
                Click.on(LNK_SHOPPING_CART),
                Click.on(BTN_CHECKOUT)
        );
    }

    public static AgregarLosProductos alCarritoDeCompra(String producto_uno, String producto_dos) {
        return Instrumented.instanceOf(AgregarLosProductos.class)
                .withProperties(ObtenerIdentificadorProductoIndividual(producto_uno),
                        ObtenerIdentificadorProductoIndividual(producto_dos));
    }

}
