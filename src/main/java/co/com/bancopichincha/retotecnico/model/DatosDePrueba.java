package co.com.bancopichincha.retotecnico.model;

import java.util.HashMap;
import java.util.Map;

public class DatosDePrueba {

    private static Map<String, Object> body = new HashMap<>();

    private DatosDePrueba(){

    }

    public static void cargarDatosDePrueba(Map<String, Object> datos){
        body = datos;
    }

    public static Map<String, Object> obtenerDatosDePrueba(){
        return body;
    }
}
