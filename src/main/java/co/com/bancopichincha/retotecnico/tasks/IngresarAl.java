package co.com.bancopichincha.retotecnico.tasks;

import co.com.bancopichincha.retotecnico.interactions.IniciarSesion;
import co.com.bancopichincha.retotecnico.interactions.NavegarA;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class IngresarAl implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.wasAbleTo(
                NavegarA.laPaginaDeSwagLabs(),
                IniciarSesion.enElAplicativo()
        );
    }

    public static IngresarAl catalogoDeProductos() {
        return instrumented(IngresarAl.class);
    }

}
