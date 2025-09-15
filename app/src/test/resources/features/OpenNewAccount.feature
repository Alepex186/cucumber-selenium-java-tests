Feature: Crear una nueva cuenta bancaria

  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas

  Scenario: Crear una nueva cuenta
    When El usuario hace clic en el botón Open New Account
    And El usuario selecciona un tipo de cuenta
    And El usuario selecciona la cuenta para descontar el deposito
    And El usuario hace clic en el botón para enviar el formulario de Open New Account
    Then El usuario debería visualizar el mensaje Congratulations, your account is now open