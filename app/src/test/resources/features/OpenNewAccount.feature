Feature: Crear una nueva cuenta bancaria
  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas

  Scenario: Crear una nueva cuenta
    When Hago click en el boton "Open New Account"
    And Selecciono el valor "1" del menu de tipo de cuenta
    And Selecciono el valor "0" del menu del ID de la cuenta
    And Hago click en el boton para enviar el formulario de "Open New Account"
    Then deberia aparecer el mensaje "Congratulations, your account is now open."