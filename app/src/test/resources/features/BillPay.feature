Feature: Enviar pagos a cuentas externas


  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas


  Scenario: Enviar dinero de una cuenta interna a una externa
    Given El usuario esta en el apartado de Accounts Overview y visualiza la lista actual de cuentas
    And El usuario se encuentra en el apartado Bill Pay
    When El usuario completa el formulario e ingresa la cantidad de "2" dólares
    And El usuario hace clic en el botón SEND PAYMENT
    Then El usuario debería visualizar el mensaje Bill Payment Complete
      And El usuario regresa a la página de Accounts Overview
      And El usuario debería visualizar que el saldo disminuyó en "-2" dólares