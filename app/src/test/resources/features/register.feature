@Register
Feature: Registro en la página web

  Scenario: Registro exitoso con datos validos
    Given El usuario ingresa a la página de registro
    When El usuario completa el formulario con datos válidos generados automáticamente
    And El usuario hace clic en el botón para enviar el formulario
    Then El usuario debería ser redirigido a la página principal
