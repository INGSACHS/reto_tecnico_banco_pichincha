#language: es

Característica: Proceso de Registro y Actualización de Información -  Nueva Mascota

  Escenario: Registrar Información Mascota
    Dado que deseo registrar a mi mascota con la siguiente información:
      | raza   | ROTTWEILER                                                                                          |
      | nombre | Rocky                                                                                               |
      | foto   | https://i0.wp.com/blog.mascotaysalud.com/wp-content/uploads/2019/05/CARA-ROTTWEILER.jpg?w=865&ssl=1 |
    Cuando realizo el proceso de inscripción en la plataforma
    Entonces debo evidenciar que la solicitud radicada se registro con éxito en el sistema

  Escenario: Consultar Información Mascota por Identificador
    Cuando realizo la búsqueda del registro de la mascota por el número de identificación
    Entonces debo observar que la información visualizada corresponda al nombre de mi mascota: Rocky y que el estado es: available

  Escenario: Actualización Datos Básicos Mascota
    Dado que deseo actualizar los datos de mi mascota modificando los siguientes datos:
      | nombre | Bolt |
      | estado | sold |
    Cuando realizo el proceso de actualización en la plataforma
    Entonces debo evidenciar que la solicitud radicada se registro con éxito en el sistema

  Escenario: Consultar Información Mascota por Estado
    Cuando realizo la búsqueda del registro de la mascota por el estado de la misma
    Entonces debo observar que la información visualizada corresponda al nombre de mi mascota: Bolt y que el estado es: sold