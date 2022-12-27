# Automatización Reto Técnico - Banco Pichincha

Proyecto en el que se implementó el patrón de Screenplay, Serenity BDD, Cucumber, JUnit, Serenity Rest Assured, Java y 
Gradle para automatizar los dos enunciados solicitados por el cliente.

## 1. Requisitos
### 1.1. Instaladores
- [Java 8 ó superior](https://www.oracle.com/java/technologies/downloads/#java8)
- [Gradle 7.5.1 ó superior](https://gradle.org/install/)
- [Git](https://git-scm.com/downloads)
- [IntelliJ IDEA Community Edition](https://www.jetbrains.com/es-es/idea/download/#section=windows)

## 2. Estructura del Proyecto
```text
.
│# Paquete que almacena todos las clases y archivos involucrados en el manejo y procesamiento de los datos de prueba
├── src
│	├── main
│	│	└── java
│	│		└── co.com.bancopichincha.retotecnico
│	│			│
│	│			# Paquete que almacena las clases java para el manejo de las excepciones
│	│			├── exceptions
│	│			│
│	│			# Paquete que almacena las clases java que implementan de la interfaz "Interaction" y que se ejecutan desde las tareas
│	│			├── interactions
│	│			│
│	│			# Paquete que almacena las clases javas encargadas de manipular los datos de prueba
│	│			├── models
│	│			│
│	│			# Paquete que almacena las clases java que implementan de la interfaz "Question" que son las afirmaciones que puede realizar el actor sobre el estado de un elemento
│	│			├── questions
│	│			│
│	│			# Paquete que almacena las clases java que implementan de la interfaz "Task" y que son las tareas que puede realizar el actor para llevar a cabo lo escrito en el guión
│	│			├── tasks
│	│			│
│	│			# Paquete que almacena los clases java que contienen los objetos de las páginas web con las que interactura el actor en cada tarea
│	│			├── userinterfaces
│	│			│
│	│			# Paquete que almacena las clases java utiles para la automatización del proyecto
│	│			└── util
│	│				│
│	│				# Paquete que almacena las clases java encargadas del manejo de constantes
│	│				├── constantes
│	│				│
│	│				# Paquete que almacena los enumerables java encargados de obtener los datos definidos en el paquete "constantes"
│	│				├── resources
│	│				│
│	│				# Paquete que almacena las clases de java encargadas de trabajar con los templates definidos para la API
│	│				└── template
│	│
│	│
│	# Paquete que almacena todos las clases y archivos involucrados en la ejecución de las pruebas
│	├── test
│	│	├── java
│	│	│	└── co.com.bancopichincha.retotecnico
│	│	│		│
│	│	│		# Paquete que almacena las clases que ejecutan los escenarios de prueba
│	│	│		├── runners
│	│	│		│	│	
│	│	│		│	# Paquete que contiene los runners de los features asociados a los escenarios de API
│	│	│		│	├── api
│	│	│		│	│
│	│	│		│	# Paquete que contiene los runners de los features asociados a los escenarios de Web
│	│	│		│	└── web
│	│	│		│
│	│	│		# Paquete que almacena las clases java encargadas de enlazar los escenarios escritos en lenguaje "Gherkin" con las clases de automatización
│	│	│		└── stepdefinitions
│	│	│			│
│	│	│			# Paquete que almacena los métodos Java con la configuración inicial para ejecutar las pruebas
│	│	│			├── hooks
│	│	│			│
│	│	│			# Paquete que almacena los métodos Java para la ejecución de los escenarios de API
│	│	│			├── api
│	│	│			│
│	│	│			# Paquete que almacena los métodos Java para la ejecución de los escenarios de Web
│	│	│			└── web
│	│	│
│	│	└── resources
│	│		│
│	│		# Paquete que almacena los archivos de texto con los escenarios fallidos
│	│		├── features
│	│		│	│
│	│		│	# Paquete que agrupa los escenarios de prueba del flujo de API
│	│		│	├── api
│	│		│	│
│	│		│	# Paquete que agrupa los escenarios de prueba del flujo de Web
│	│		│	└── web
│	│		│
│	│		# Paquete que almacena las plantillas de las APIs (body request)
│	│		├── templates
│	│		│
│	│		# Archivo encargado de almacenar las diferentes url a trabajar agrupadas por ambiente
│	│		└── serenity.conf
│	│
│	# Archivo encargado de almacenar todas las dependencias del proyecto y las configuraciones del mismo
│	├── build.gradle
│	│
│	# Archivo encargado de almacenar toda la configuración del reporte, del driver del navegador y de los logs
│	├── serenity.properties
│	│
│	└── ···
└── ···
```

## 3. Configuración específica del entorno de pruebas
Podemos configurar propiedades y opciones específicas del entorno, para que los escenarios de pruebas se puedan ejecutar
en diferentes entornos. Para el proyecto se configuró en el archivo ***serenity.conf*** los ambientes dev, lab y prod,
dejando diligenciado solo el ambiente "qa" con las respectivas url.

```conf
environments {
    dev {
        base.url.swaglabs = ""
        base.url.petstore = ""
    }
    qa {
        base.url.swaglabs = "https://www.saucedemo.com/"
        base.url.petstore = "https://petstore.swagger.io/v2/"
    }
    prod {
        base.url.swaglabs = ""
        base.url.petstore = ""
    }
}
```

Utilice la propiedad "environment" del sistema para determinar en qué entorno se ejecutará los escenarios de prueba.
Por ejemplo, para ejecutar los escenarios de prueba en el entorno de desarrollo, se puede ejecutar el siguiente comando 
por consola:
```console
gradle clean test -Denvironment=dev aggregate
```

## 4. Ejecución de Pruebas

### *4.1. Cargar Proyecto Máquina Local*
Para trabajar sobre el proyecto:
1. Se debe clonar el repositorio en la máquina local, usando el siguiente comando:
```console
git clone https://github.com/INGSACHS/reto_tecnico_banco_pichincha.git
```

### *4.2 Ejecución de Escenarios desde IntelliJ*

1. Abrir IntelliJ IDEA y cargar el proyecto desde el archivo ***build.gradle***, para realizar el cargue exitoso de todas
   las dependencias
2. Desde el menú ***Gradle*** ubicado en la parte superior derecha del IDE, seleccionar la opción ***Execute Gradle Task***
y escribir los siguientes comandos y dar Enter:

- **Comando para la ejecución de los escenarios de prueba para Web**
```console
gradle test --tests "co.com.bancopichincha.retotecnico.runners.web.ProcesoDeCompra" -Denvironment=qa
```
- **Comando para la ejecución de los escenarios de prueba para API**
```console
gradle test --tests "co.com.bancopichincha.retotecnico.runners.api.RegistroAcutalizacionDatosMascota" -Denvironment=qa
```

- **Comando para la ejecución de todos los escenarios de prueba del proyecto**
```console
gradle test --tests "co.com.bancopichincha.retotecnico.runners.EjecutarTodosLosEscenarios" -Denvironment=qa
```

### *4.3 Ejecución de Escenarios desde la Consola*
1. Una vez clonado el repositorio en la máquina local, debemos acceder hasta la carpeta que contiene el proyecto y abrir
un nuevo ***Símbolo del Sistema (CMD)*** y escribir los siguientes comandos y dar Enter:

- **Comando para la ejecución de los escenarios de prueba para Web**
```console
gradle test --tests "co.com.bancopichincha.retotecnico.runners.web.ProcesoDeCompra" -Denvironment=qa
```
- **Comando para la ejecución de los escenarios de prueba para API**
```console
gradle test --tests "co.com.bancopichincha.retotecnico.runners.api.RegistroAcutalizacionDatosMascota" -Denvironment=qa
```

- **Comando para la ejecución de todos los escenarios de prueba del proyecto**
```console
gradle test --tests "co.com.bancopichincha.retotecnico.runners.EjecutarTodosLosEscenarios" -Denvironment=qa
```

### *4.4. Informe Ejecución Escenarios de Prueba*
Para visualizar el informe entregado sobre el estado final de cada uno de los escenarios de prueba ejecutados mediante
IntelliJ o CMD, es necesario ingresar a la siguiente ruta y seleccionar el archivo ***index.html*** con el navegador de
preferencia e interactuar con el mismo por las diferentes pestañas

- Ruta del reporte: **/target/site/serenity/index.html**