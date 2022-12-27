package co.com.bancopichincha.retotecnico.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class InformacionMascota implements Question<Boolean> {

    private final String nombreMascota;
    private final String estadoMascota;

    public InformacionMascota(String nombreMascota, String estadoMascota) {
        this.nombreMascota = nombreMascota;
        this.estadoMascota = estadoMascota;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("El nombre de la mascota y su estado corresponden a los registrados",
                        response -> response.assertThat()
                                .body("name", equalTo(nombreMascota))
                                .body("status", equalTo(estadoMascota)))
        );
        return true;
    }

    public static InformacionMascota esLaCorrecta(String nombreMascota, String estadoMascota) {
        return new InformacionMascota(nombreMascota, estadoMascota);
    }

}
