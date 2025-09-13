Feature: Pedir prestamos
  Como usuario autenticado
  Quiero poder solicitar un préstamo

  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas

  Scenario: Solicitar un préstamo con Down Payment mayor a los fondos disponibles
    Given el usuario se encuentra en el apartado Request Loan
    When el usuario ingresa un monto pequeño en Loan Amount
    And el usuario ingresa un pago inicial demasiado alto
    And el usuario selecciona una cuenta para descontar el Down Payment
    And el usuario solicita el préstamo
    Then deberia aparecer el mensaje de fondos insuficientes para el pago inicial

  Scenario: Solicitar un préstamo mayor a la liquidez disponible
    Given el usuario se encuentra en el apartado Request Loan
    When el usuario ingresa un monto demasiado alto en Loan Amount
    And el usuario ingresa un pago inicial válido
    And el usuario selecciona una cuenta para descontar el Down Payment
    And el usuario solicita el préstamo
    Then deberia aparecer el mensaje de fondos insuficientes para el préstamo

  Scenario: Solicitar un préstamo válido con Down Payment dentro de los fondos disponibles
    Given el usuario se encuentra en el apartado Request Loan
    When el usuario ingresa un monto pequeño en Loan Amount
    And el usuario ingresa un pago inicial válido
    And el usuario selecciona una cuenta para descontar el Down Payment
    And el usuario solicita el préstamo
    Then deberia aparecer el mensaje de préstamo aprobado
