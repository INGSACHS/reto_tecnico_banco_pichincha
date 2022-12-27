package co.com.bancopichincha.retotecnico.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static co.com.bancopichincha.retotecnico.model.ConstruirDatosDePrueba.obtenerDatosRegistroMascota;
import static co.com.bancopichincha.retotecnico.model.DatosDePrueba.cargarDatosDePrueba;
import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerConstante.TIPO_SOLICITUD;

public class RegistrarLa implements Task {

    private final Map<String, String> datosMascota;
    private final String tipoSolicitud;

    public RegistrarLa(Map<String, String> datosMascota, String tipoSolicitud) {
        this.datosMascota = datosMascota;
        this.tipoSolicitud = tipoSolicitud;
    }

    @Override
    @Step("{0} registra los datos básicos de la mascota")
    public <T extends Actor> void performAs(T actor) {
        Map<String, String> datosNuevaMascota = obtenerDatosRegistroMascota(datosMascota, tipoSolicitud);
        Set<Map.Entry<String, String>> datosAuxiliares = datosNuevaMascota.entrySet();
        cargarDatosDePrueba(datosAuxiliares.stream().collect(Collectors.toMap(Map.Entry::getKey,
                Map.Entry::getValue)));
    }

    public static RegistrarLa informacionDeLaMascota(Map<String, String> informacionMascota) {
        return Instrumented.instanceOf(RegistrarLa.class)
                .withProperties(informacionMascota, TIPO_SOLICITUD.obtenerValores().get(0));
    }

    public static RegistrarLa nuevaInformacionDeLaMascota(Map<String, String> informacionMascota) {
        return Instrumented.instanceOf(RegistrarLa.class)
                .withProperties(informacionMascota, TIPO_SOLICITUD.obtenerValores().get(1));
    }

}
