Feature: Buscar transacciones


  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas
    And El usuario se encuentra en el apartado Find Transactions
    And El usuario ha seleccionado una cuenta



  Scenario: Buscar transacciones por fecha única
      When El usuario ingresa la fecha a buscar en Find by Date
        And El usuario hace clic en el botón FIND TRANSACTIONS del apartado Find by Date
      Then El usuario debería visualizar una tabla en Find Transactions con esa fecha

  Scenario: Buscar transacciones por rango de fechas
    When El usuario ingresa las fechas a buscar en Find by Date Range
    And El usuario hace clic en el botón FIND TRANSACTIONS del apartado Find by Date Range
    Then El usuario debería visualizar una tabla en Find Transactions con esa fecha


  Scenario: Buscar transacciones por monto
    When El usuario ingresa el monto a buscar en Find by Amount
    And El Usuario hace click en FINDS TRANSACTIONS del apartado Find by Amount
    Then El usuario debería visualizar una tabla en Find Transactions con esa fecha