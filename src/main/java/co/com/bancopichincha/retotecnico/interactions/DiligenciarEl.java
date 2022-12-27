package co.com.bancopichincha.retotecnico.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;

import java.util.Map;

import static co.com.bancopichincha.retotecnico.utils.template.UnirDesde.rutaPlantilla;
import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerConstante.CLAVE_BODY;
import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerConstante.RUTA_PLANTILLA;

public class DiligenciarEl implements Interaction {

    private final String nombrePlantilla;
    private final Map<String, String> datosDePrueba;

    public DiligenciarEl(String nombrePlantilla, Map<String, String> datosDePrueba) {
        this.nombrePlantilla = nombrePlantilla;
        this.datosDePrueba = datosDePrueba;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String rutaPlantilla = String.format(RUTA_PLANTILLA.obtenerValor(), nombrePlantilla);
        String cuerpoMensaje = rutaPlantilla(rutaPlantilla).conLaInformacionDesde(datosDePrueba);
        actor.remember(CLAVE_BODY.obtenerValor(), cuerpoMensaje);
    }

    public static DiligenciarEl formularioDeRegistro(String nombrePlantilla, Map<String, Object> datos) {
        return Instrumented.instanceOf(DiligenciarEl.class)
                .withProperties(nombrePlantilla, datos);
    }

}
