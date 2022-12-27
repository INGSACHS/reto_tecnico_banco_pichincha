package co.com.bancopichincha.retotecnico.utils.template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

public class FreemarkerTemplate {

    private Configuration configuracion = null;

    private Configuration obtenerConfiguracionPlantilla() {
        if (configuracion == null) {
            configuracion = new Configuration(Configuration.VERSION_2_3_29);
            configuracion.setDefaultEncoding("UTF-8");
            configuracion.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            configuracion.setClassForTemplateLoading(FreemarkerTemplate.class, "/");
        }
        return configuracion;
    }

    public Template obtenerPlantilla(String rutaPlantilla) {
        try {
            return obtenerConfiguracionPlantilla().getTemplate(rutaPlantilla);
        } catch (Exception e) {
            throw new IllegalStateException("No se puedo encontrar la plantilla " + rutaPlantilla, e);
        }
    }

}
