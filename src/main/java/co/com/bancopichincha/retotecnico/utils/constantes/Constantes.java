package co.com.bancopichincha.retotecnico.utils.constantes;

import java.util.List;

public class Constantes {

    private Constantes() {
    }

    public static final String ID_MASCOTA = "1";
    public static final String ESTADO_VENDIDA = "sold";
    public static final String BODY = "body";
    public static final String UBICACION_PLANTILLA = "templates/%s";
    public static final String PLANTILLA_INSCRIPCION = "InformacionMascota.json";
    public static final String LLAVE = "api_key";
    public static final String VALOR = "special-key";
    public static final String CONSUMO_SERVICIO = "Se produjo un error al consumir el método %s";
    public static final String FOTO = "https://i0.wp.com/blog.mascotaysalud.com/wp-content/uploads/2019/05/" +
            "CARA-ROTTWEILER.jpg?w=865&ssl=1";
    public static final List<String> SOLICITUDES = List.of("Creación", "Actualización");
    public static final List<String> CONSULTAS = List.of("Identificador", "Estado");

}
