package co.com.bancopichincha.retotecnico.stepdefinitions.web;

import co.com.bancopichincha.retotecnico.questions.ObtenerMensaje;
import co.com.bancopichincha.retotecnico.tasks.IngresarAl;
import co.com.bancopichincha.retotecnico.tasks.RealizarEl;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class ProcesoDeCompraStepDefinitions {

    @Dado("que navego a la aplicación de SwagLabs e ingreso a realizar una compra en línea")
    public void navegarPaginaSwagLabs() {
        theActorInTheSpotlight().wasAbleTo(
                IngresarAl.catalogoDeProductos()
        );
    }

    @Cuando("añado al carrito de compra los productos {} y {} y completo el proceso diligenciando el formulario de " +
            "compra con mis datos personales:")
    public void realizarElProcesoDeCompra(String producto_uno, String producto_dos,
                                          Map<String, String> datosPersonales) {
        theActorInTheSpotlight().attemptsTo(
                RealizarEl.procesoDeCompra(producto_uno, producto_dos, datosPersonales)
        );
    }

    @Entonces("debo observar al finalizar la compra, el mensaje {} que indica que el proceso fue exitoso")
    public void validarEstadoProcesoDeCompra(String mensajeEsperado) {
        theActorInTheSpotlight().should(
                seeThat("El mensaje exitoso al finalizar el proceso de compra", ObtenerMensaje.compraExitosa(),
                        equalTo(mensajeEsperado))
        );
    }

}
