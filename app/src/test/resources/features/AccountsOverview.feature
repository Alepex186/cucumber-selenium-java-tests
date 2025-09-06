
Feature: Verificar una nueva cuenta en Accounts Overview
  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas


  Scenario: Verificar que se agrego una nueva cuenta a Accounts Overview
    Given El usuario esta en el apartado de Accounts Overview y visualiza la lista actual de cuentas
    When El usuario navega a Open New Account y crea una nueva cuenta
      And El usuario regresa a la pagina de Accounts Overview
    Then deberia visualizarse una nueva cuenta en la lista, con el id visualizado al crear la cuenta


