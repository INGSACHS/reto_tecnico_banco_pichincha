package co.com.bancopichincha.retotecnico.utils.resources;

import static co.com.bancopichincha.retotecnico.utils.constantes.Capacidades.*;

public enum ObtenerCapacidad {

    CAPACIDAD_AGREGAR_MASCOTA(AGREGAR_MASCOTA),
    CAPACIDAD_CONSULTAR_MASCOTA_IDENTIFICADOR(CONSULTAR_MASCOTA_IDENTIFICADOR),
    CAPACIDAD_ACTUALIZAR_DATOS(ACTUALIZAR_INFORMACION),
    CAPACIDAD_CONSULTAR_MASCOTA_ESTADO(CONSULTAR_MASCOTA_ESTADOO);

    private final String capacidad;

    ObtenerCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String obtenerCapacidad() {
        return capacidad;
    }

}
