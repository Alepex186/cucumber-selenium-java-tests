@Login
Feature: Verificar login de la pagina web

  Background:
    Given Abro la pagina de login


  Scenario: Verificamos credenciales correctas
    When Ingreso el usuario correcto "test123"
      And Ingreso la contrasenia correcta "123456"
      And Hago click en el boton de login
    Then Deberia logearse y aparecer el texto "Accounts Overview"

  Scenario: Verificamos usuario incorrecto y contrasenia correcta
    When Ingreso el usuario incorrecto "testincorrectuser123"
      And Ingreso la contrasenia correcta "123456"
      And Hago click en el boton de login
    Then Deberia aparecer el mensaje "The username and password could not be verified."

  Scenario: Verificamos usuario correcto y contrasenia incorrecta
    When Ingreso el usuario correcto "test12353453"
    And Ingreso una contrasenia incorrecta "fesefesfesfesfes"
    And Hago click en el boton de login
    Then Deberia aparecer el mensaje "The username and password could not be verified."
