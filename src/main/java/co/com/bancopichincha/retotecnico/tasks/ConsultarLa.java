package co.com.bancopichincha.retotecnico.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerCapacidad.CAPACIDAD_CONSULTAR_MASCOTA_ESTADO;
import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerCapacidad.CAPACIDAD_CONSULTAR_MASCOTA_IDENTIFICADOR;
import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerConstante.*;

public class ConsultarLa implements Task {

    private final String tipoConsulta;

    public ConsultarLa(String tipoConsulta) {
        this.tipoConsulta = tipoConsulta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Check.whether(tipoConsulta.equals("Identificador"))
                        .andIfSo(
                                Get.resource(CAPACIDAD_CONSULTAR_MASCOTA_IDENTIFICADOR.obtenerCapacidad())
                                        .with(request -> request
                                                .header(LLAVE_HEADER.obtenerValor(), CLAVE_HEADER.obtenerValor())
                                                .pathParam("id", Integer.valueOf(IDENTIFICADOR_MASCOTA.obtenerValor()))
                                                .contentType(ContentType.JSON)
                                                .log().all()
                                        )
                        ).otherwise(
                                Get.resource(CAPACIDAD_CONSULTAR_MASCOTA_ESTADO.obtenerCapacidad())
                                        .with(request -> request
                                                .header(LLAVE_HEADER.obtenerValor(), CLAVE_HEADER.obtenerValor())
                                                .queryParam("status", ESTADO_MASCOTA.obtenerValor())
                                                .contentType(ContentType.JSON)
                                                .log().all()
                                        )
                        )
        );
    }

    public static ConsultarLa informacionDeLaMascotaPorIdentificador() {
        return Instrumented.instanceOf(ConsultarLa.class)
                .withProperties(TIPO_CONSULTA.obtenerValores().get(0));
    }

    public static ConsultarLa informacionDeLaMascotaPorEstado() {
        return Instrumented.instanceOf(ConsultarLa.class)
                .withProperties(TIPO_CONSULTA.obtenerValores().get(1));
    }

}
