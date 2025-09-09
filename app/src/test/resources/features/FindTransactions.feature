Feature: Buscar transacciones


  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas


  Scenario: Buscar transacciones por fecha unica
    Given El usuario esta en el apartado de Find Transactions
      When El usuario ingresa la fecha a buscar en Find by Date
        And El Usuario hace click en FINDS TRANSACTIONS del apartado Find by Date
      Then Deberia aparecer una tabla con las transacciones de esa fecha

  Scenario: Buscar transacciones por rango de fechas
    Given El usuario esta en el apartado de Find Transactions
    When El usuario ingresa las fechas a buscar en Find by Date Range
    And El Usuario hace click en FINDS TRANSACTIONS del apartado Find by Date Range
    Then Deberia aparecer una tabla con las transacciones de esa fecha


  Scenario: Buscar transacciones por monto
    Given El usuario esta en el apartado de Find Transactions
    When El usuario ingresa el monto a buscar en Find by Amount
    And El Usuario hace click en FINDS TRANSACTIONS del apartado Find by Amount
    Then Deberia aparecer una tabla con las transacciones de esa fecha