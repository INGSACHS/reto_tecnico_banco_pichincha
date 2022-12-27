package co.com.bancopichincha.retotecnico.utils.template;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public class UnirDesde {

    private final String rutaPlantilla;
    private static final FreemarkerTemplate freemarkerTemplate = new FreemarkerTemplate();

    public UnirDesde(String rutaPlantilla) {
        this.rutaPlantilla = rutaPlantilla;
    }

    public static UnirDesde rutaPlantilla(String rutaPlantilla) {
        return new UnirDesde(rutaPlantilla);
    }

    public String conLaInformacionDesde(Map<String, String> datosDePrueba) {
        Template plantilla = freemarkerTemplate.obtenerPlantilla(rutaPlantilla);
        Writer escribirTemplate = new StringWriter();

        try {
            plantilla.process(datosDePrueba, escribirTemplate);
        } catch (TemplateException | IOException e) {
            throw new IllegalStateException("Fallo la escritura de los datos de prueba en la plantilla", e);
        }

        return escribirTemplate.toString();
    }

}
