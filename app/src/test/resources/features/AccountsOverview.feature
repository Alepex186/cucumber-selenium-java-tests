
Feature: Verificar una nueva cuenta en Accounts Overview
  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas


  Scenario: Verificar que se agrego una nueva cuenta a Accounts Overview
    Given El usuario esta en el apartado de Accounts Overview y visualiza la lista actual de cuentas
    When El usuario navega al apartado Open New Account y crea una nueva cuenta
      And El usuario regresa a la página de Accounts Overview
    Then El usuario debería visualizar la nueva cuenta en la lista, con el ID mostrado al momento de crearla


