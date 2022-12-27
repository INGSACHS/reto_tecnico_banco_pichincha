package co.com.bancopichincha.retotecnico.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.apache.http.HttpStatus;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CodigoRespuesta implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("200", response -> response.statusCode(HttpStatus.SC_OK))
        );
        return true;
    }

    public static CodigoRespuesta esCorrecto() {
        return new CodigoRespuesta();
    }

}
