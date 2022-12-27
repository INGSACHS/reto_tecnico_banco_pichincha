package co.com.bancopichincha.retotecnico.utils;

public class ObtenerIdentificadorProducto {

    private ObtenerIdentificadorProducto() {
    }

    public static String ObtenerIdentificadorProductoIndividual(String nombreProducto) {
        String prefijo = "add-to-cart-";
        return prefijo + nombreProducto.toLowerCase().replace(" ", "-");
    }

}
