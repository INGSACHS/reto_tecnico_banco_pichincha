package co.com.bancopichincha.retotecnico.interactions;

import co.com.bancopichincha.retotecnico.exceptions.ConsumirServicio;
import io.restassured.http.ContentType;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;
import net.thucydides.core.annotations.Step;
import org.apache.http.HttpStatus;

import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerCapacidad.CAPACIDAD_ACTUALIZAR_DATOS;
import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerCapacidad.CAPACIDAD_AGREGAR_MASCOTA;
import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerConstante.*;

public class RegistrarLaSolicitud implements Interaction {

    private final String tipoSolicitud;

    public RegistrarLaSolicitud(String tipoSolicitud) {
        this.tipoSolicitud = tipoSolicitud;
    }

    @Override
    @Step("{0} ejecuta el proceso de #tipoSolicitud del registro")
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Check.whether(tipoSolicitud.equals("creación"))
                        .andIfSo(
                                Post.to(CAPACIDAD_AGREGAR_MASCOTA.obtenerCapacidad())
                                        .with(request -> request
                                                .header(LLAVE_HEADER.obtenerValor(), CLAVE_HEADER.obtenerValor())
                                                .contentType(ContentType.JSON)
                                                .body(actor.recall(CLAVE_BODY.obtenerValor()).toString())
                                                .log().all()
                                        )
                        ).otherwise(
                                Put.to(CAPACIDAD_ACTUALIZAR_DATOS.obtenerCapacidad())
                                        .with(request -> request
                                                .header(LLAVE_HEADER.obtenerValor(), CLAVE_HEADER.obtenerValor())
                                                .contentType(ContentType.JSON)
                                                .body(actor.recall(CLAVE_BODY.obtenerValor()).toString())
                                                .log().all()
                                        )
                        )
        );

        if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK) {
            throw new ConsumirServicio(String.format(EXCEPCION_CONSUMO_SERVICIO.obtenerValor(),
                    CAPACIDAD_AGREGAR_MASCOTA.obtenerCapacidad()));
        }

    }

    public static RegistrarLaSolicitud deInscripcion(String tipoSolicitud) {
        return Instrumented.instanceOf(RegistrarLaSolicitud.class)
                .withProperties(tipoSolicitud);
    }

}
