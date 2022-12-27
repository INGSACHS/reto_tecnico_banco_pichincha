package co.com.bancopichincha.retotecnico.model;

import java.util.HashMap;
import java.util.Map;

import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerConstante.FOTO_MASCOTA;
import static co.com.bancopichincha.retotecnico.utils.resources.ObtenerConstante.IDENTIFICADOR_MASCOTA;

public class ConstruirDatosDePrueba {

    private ConstruirDatosDePrueba() {
    }

    private static Map<String, String> construirDatosAdicionalesRegistroMascota(Map<String, String> datosMascota,
                                                                                String tipoSolicitud) {
        Map<String, String> informacionMascota = new HashMap<>();
        informacionMascota.put("idMascota", String.valueOf(IDENTIFICADOR_MASCOTA.obtenerValor()));
        informacionMascota.put("idCategoria",
                tipoSolicitud.equals("creación") ? String.valueOf(obtenerIdCategoria(datosMascota.get("raza"))) : "1");
        informacionMascota.put("nombreCategoria",
                tipoSolicitud.equals("creación") ? datosMascota.get("raza") : "ROTTWEILER");
        informacionMascota.put("nombreMascota", datosMascota.get("nombre"));
        informacionMascota.put("urlFotoMascota",
                tipoSolicitud.equals("creación") ? datosMascota.get("foto") : FOTO_MASCOTA.obtenerValor());
        informacionMascota.put("estadoMascota",
                tipoSolicitud.equals("creación") ? "available" : datosMascota.get("estado"));
        return informacionMascota;
    }

    public static Map<String, String> obtenerDatosRegistroMascota(Map<String, String> informacionMascota,
                                                                  String tipoSolicitud) {
        return construirDatosAdicionalesRegistroMascota(informacionMascota, tipoSolicitud);
    }

    private static int obtenerIdCategoria(String raza) {
        return switch (raza) {
            case "ROTTWEILER" -> 1;
            case "DÓBERMAN" -> 2;
            case "GOLDEN RETRIEVER" -> 3;
            case "BULL TERRIER" -> 4;
            default -> 99;
        };
    }

}
