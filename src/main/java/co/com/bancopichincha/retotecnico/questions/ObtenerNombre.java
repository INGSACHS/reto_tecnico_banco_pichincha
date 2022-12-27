package co.com.bancopichincha.retotecnico.questions;

import io.restassured.path.json.JsonPath;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerConstante.IDENTIFICADOR_MASCOTA;

public class ObtenerNombre implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        JsonPath mascotas = SerenityRest.lastResponse().jsonPath();
        return ((ArrayList<LinkedHashMap<String, Object>>) mascotas.get()).stream()
                .filter(m -> m.get("id").equals(Integer.valueOf(IDENTIFICADOR_MASCOTA.obtenerValor())))
                .findFirst().get().get("name").toString();
    }

    public static ObtenerNombre deMascota() {
        return new ObtenerNombre();
    }

}
