@Register
Feature: Registrarse en la pagina web
  Scenario: Registro exitoso con datos validos
    Given Ingreso a la pagina de registro
    When Cuando completo el formulario con datos valido generados
    And Y hago click en el boton para enviar el formulario
    Then deberia ver la pagina principal del usuario
