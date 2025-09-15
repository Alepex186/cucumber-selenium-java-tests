Feature: Pedir prestamos
  Como usuario autenticado
  Quiero poder solicitar un préstamo

  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas

  Scenario: Solicitar un préstamo con Down Payment mayor a los fondos disponibles
    Given El usuario se encuentra en el apartado Request Loan
    When El usuario ingresa un monto pequeño en Loan Amount
    And El usuario ingresa un pago inicial demasiado alto
    And El usuario selecciona una cuenta para descontar el Down Payment
    And El usuario solicita el préstamo
    Then El usuario debería visualizar el mensaje Fondos insuficientes para el pago inicial

  Scenario: Solicitar un préstamo mayor a la liquidez disponible
    Given El usuario se encuentra en el apartado Request Loan
    When El usuario ingresa un monto demasiado alto en Loan Amount
    And El usuario ingresa un pago inicial válido
    And El usuario selecciona una cuenta para descontar el Down Payment
    And El usuario solicita el préstamo
    Then El usuario debería visualizar el mensaje Fondos insuficientes para el préstamo

  Scenario: Solicitar un préstamo válido con Down Payment dentro de los fondos disponibles
    Given El usuario se encuentra en el apartado Request Loan
    When El usuario ingresa un monto pequeño en Loan Amount
    And El usuario ingresa un pago inicial válido
    And El usuario selecciona una cuenta para descontar el Down Payment
    And El usuario solicita el préstamo
    Then El usuario debería visualizar el mensaje Préstamo aprobado
