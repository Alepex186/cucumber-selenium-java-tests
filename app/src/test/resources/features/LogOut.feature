Feature: Cerrar sesión de la cuenta

  Scenario: Cerrar sesión
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas
    When El usuario hace clic en el botón Log Out
    Then El usuario debería regresar a la página de login