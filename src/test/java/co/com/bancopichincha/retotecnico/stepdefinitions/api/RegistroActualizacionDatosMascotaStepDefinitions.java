package co.com.bancopichincha.retotecnico.stepdefinitions.api;

import co.com.bancopichincha.retotecnico.questions.CodigoRespuesta;
import co.com.bancopichincha.retotecnico.questions.InformacionMascota;
import co.com.bancopichincha.retotecnico.questions.ObtenerNombre;
import co.com.bancopichincha.retotecnico.tasks.CompletarEl;
import co.com.bancopichincha.retotecnico.tasks.ConsultarLa;
import co.com.bancopichincha.retotecnico.tasks.RegistrarLa;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class RegistroActualizacionDatosMascotaStepDefinitions {

    @Dado("que deseo registrar a mi mascota con la siguiente información:")
    public void cargarInformacionMascota(Map<String, String> informacionMascota) {
        theActorInTheSpotlight().wasAbleTo(
                RegistrarLa.informacionDeLaMascota(informacionMascota)
        );
    }

    @Dado("que deseo actualizar los datos de mi mascota modificando los siguientes datos:")
    public void cargarActualizacionDatosMascota(Map<String, String> informacionMascota) {
        theActorInTheSpotlight().wasAbleTo(
                RegistrarLa.nuevaInformacionDeLaMascota(informacionMascota)
        );
    }

    @Cuando("realizo el proceso de inscripción en la plataforma")
    public void registrarInformacionMascota() {
        theActorInTheSpotlight().attemptsTo(
                CompletarEl.procesoDeRegistro()
        );
    }

    @Cuando("realizo la búsqueda del registro de la mascota por el número de identificación")
    public void consultarInformacionMascotaPorIdentificador() {
        theActorInTheSpotlight().attemptsTo(
                ConsultarLa.informacionDeLaMascotaPorIdentificador()
        );
    }

    @Cuando("realizo el proceso de actualización en la plataforma")
    public void actualizarInformacionMascota() {
        theActorInTheSpotlight().attemptsTo(
                CompletarEl.procesoDeActualizacion()
        );
    }

    @Cuando("realizo la búsqueda del registro de la mascota por el estado de la misma")
    public void consultarInformacionMascotaPorEstado() {
        theActorInTheSpotlight().attemptsTo(
                ConsultarLa.informacionDeLaMascotaPorEstado()
        );
    }

    @Entonces("debo evidenciar que la solicitud radicada se registro con éxito en el sistema")
    public void validarEstadoRegistroMascota() {
        theActorInTheSpotlight().should(
                seeThat("El código de respuesta del servicio es", CodigoRespuesta.esCorrecto()));
    }

    @Entonces("debo observar que la información visualizada corresponda al nombre de mi mascota: {} y que el estado " +
            "es: {}")
    public void validarNombreMascotaEnRegistro(String nombreMascota, String estadoMascota) {
        theActorInTheSpotlight().should(
                seeThat("La información registrada de la mascota es correcta",
                        InformacionMascota.esLaCorrecta(nombreMascota, estadoMascota))
        );
    }

    @Entonces("debo observar que la nueva información registrada corresponda a la de mi mascota: {}")
    public void validarActualizacionInformacionMascota(String nombreMascota) {
        theActorInTheSpotlight().should(
                seeThat("La información actualizada corresponde a la del nombre de su mascota que",
                        ObtenerNombre.deMascota(), equalTo(nombreMascota))
        );
    }

}
