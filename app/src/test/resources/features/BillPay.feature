Feature: Enviar pagos a cuentas externas


  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas


  Scenario: Enviar dinero de una cuenta interna a una externa
    Given El usuario esta en el apartado de Accounts Overview y visualiza la lista actual de cuentas
    And El usuario esta en el apartado de Bill Pay
    When El usuario rellena el formulario e ingresa la cantidad de "2" dolares
    And Hace click en el boton SEND PAYMENT
    Then Deberia aparecer el mensaje Bill Payment Complete
      And El usuario regresa a la pagina de Accounts Overview
      And El saldo deberia disminuir en "-2" dolares