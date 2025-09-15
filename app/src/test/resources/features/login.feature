@Login
Feature: Verificar login de la pagina web

  Background:
    Given El usuario abre la página de login


  Scenario: Verificar credenciales correctas
    When El usuario ingresa el nombre de usuario correcto "john"
      And El usuario ingresa la contraseña correcta "demo"
      And El usuario hace clic en el botón Login
    Then Deberia logearse y aparecer el texto "Accounts Overview"

  Scenario: Verificamos usuario incorrecto y contrasenia correcta
    When El usuario ingresa un nombre de usuario incorrecto "testincorrectuser123"
      And El usuario ingresa la contraseña correcta "demo"
      And El usuario hace clic en el botón Login
    Then El usuario debería visualizar el mensaje "The username and password could not be verified."

  Scenario: Verificamos usuario correcto y contrasenia incorrecta
    When El usuario ingresa el nombre de usuario correcto "john"
    And El usuario ingresa una contraseña incorrecta "fesefesfesfesfes"
    And El usuario hace clic en el botón Login
    Then El usuario debería visualizar el mensaje "The username and password could not be verified."
