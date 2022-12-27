#language: es

Característica: Flujo Compra Swag Labs

  Escenario: Compra Exitosa Morral y Luces Bicicleta
    Dado que navego a la aplicación de SwagLabs e ingreso a realizar una compra en línea
    Cuando añado al carrito de compra los productos Sauce Labs Backpack y Sauce Labs Bike Light y completo el proceso diligenciando el formulario de compra con mis datos personales:
      | primer_nombre   | Pedro   |
      | primer_apellido | Infante |
      | codigo_postal   | 110110  |
    Entonces debo observar al finalizar la compra, el mensaje THANK YOU FOR YOUR ORDER que indica que el proceso fue exitoso