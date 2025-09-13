Feature: Log Out de la cuenta

  Scenario: Log Out de la cuenta
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas
    When el usuario hace click en el boton Log Out
    Then deberia regresar a la pagina de login