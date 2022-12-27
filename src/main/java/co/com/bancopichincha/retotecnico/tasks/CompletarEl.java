package co.com.bancopichincha.retotecnico.tasks;

import co.com.bancopichincha.retotecnico.interactions.DiligenciarEl;
import co.com.bancopichincha.retotecnico.interactions.RegistrarLaSolicitud;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.Map;

import static co.com.bancopichincha.retotecnico.model.DatosDePrueba.obtenerDatosDePrueba;
import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerConstante.NOMBRE_PLANTILLA;
import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerConstante.TIPO_SOLICITUD;

public class CompletarEl implements Task {

    private final String nombrePlantilla;
    private final Map<String, Object> datosDePrueba;
    private final String tipoSolicitud;

    public CompletarEl(String nombrePlantilla, Map<String, Object> datosDePrueba, String tipoSolicitud) {
        this.nombrePlantilla = nombrePlantilla;
        this.datosDePrueba = datosDePrueba;
        this.tipoSolicitud = tipoSolicitud;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                DiligenciarEl.formularioDeRegistro(nombrePlantilla, datosDePrueba),
                RegistrarLaSolicitud.deInscripcion(tipoSolicitud)
        );
    }

    public static CompletarEl procesoDeRegistro() {
        return Instrumented.instanceOf(CompletarEl.class)
                .withProperties(NOMBRE_PLANTILLA.obtenerValor(), obtenerDatosDePrueba(),
                        TIPO_SOLICITUD.obtenerValores().get(0));
    }

    public static CompletarEl procesoDeActualizacion() {
        return Instrumented.instanceOf(CompletarEl.class)
                .withProperties(NOMBRE_PLANTILLA.obtenerValor(), obtenerDatosDePrueba(),
                        TIPO_SOLICITUD.obtenerValores().get(1));
    }

}
