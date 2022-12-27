package co.com.bancopichincha.retotecnico.utils.resources;

import java.util.List;

import static co.com.bancopichincha.retotecnico.utils.constantes.Constantes.*;

public enum ObtenerConstante {

    IDENTIFICADOR_MASCOTA(ID_MASCOTA),
    ESTADO_MASCOTA(ESTADO_VENDIDA),
    CLAVE_BODY(BODY),
    RUTA_PLANTILLA(UBICACION_PLANTILLA),
    NOMBRE_PLANTILLA(PLANTILLA_INSCRIPCION),
    LLAVE_HEADER(LLAVE),
    CLAVE_HEADER(VALOR),
    EXCEPCION_CONSUMO_SERVICIO(CONSUMO_SERVICIO),
    FOTO_MASCOTA(FOTO),
    TIPO_SOLICITUD(SOLICITUDES),
    TIPO_CONSULTA(CONSULTAS);

    private String valor;
    private List<String> valores;

    ObtenerConstante(String valor) {
        this.valor = valor;
    }

    ObtenerConstante(List<String> valores) {
        this.valores = valores;
    }

    public String obtenerValor() {
        return valor;
    }

    public List<String> obtenerValores() {
        return valores;
    }

}
