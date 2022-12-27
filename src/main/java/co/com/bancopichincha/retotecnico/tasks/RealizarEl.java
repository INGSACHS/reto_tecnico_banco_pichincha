package co.com.bancopichincha.retotecnico.tasks;

import co.com.bancopichincha.retotecnico.interactions.AgregarLosProductos;
import co.com.bancopichincha.retotecnico.interactions.CompletarEl;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.Map;

public class RealizarEl implements Task {

    private final String productoUno;
    private final String productoDos;
    private final Map<String, String> datosPersonales;

    public RealizarEl(String productoUno, String productoDos, Map<String, String> datosPersonales) {
        this.productoUno = productoUno;
        this.productoDos = productoDos;
        this.datosPersonales = datosPersonales;
    }

    @Override
    @Step("{0} finaliza el proceso de compra de los productos")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                AgregarLosProductos.alCarritoDeCompra(productoUno, productoDos),
                CompletarEl.formularioDeCompra(datosPersonales)
        );
    }

    public static RealizarEl procesoDeCompra(String productoUno, String productoDos,
                                             Map<String, String> datosPersonales) {
        return Instrumented.instanceOf(RealizarEl.class)
                .withProperties(productoUno, productoDos, datosPersonales);
    }

}
