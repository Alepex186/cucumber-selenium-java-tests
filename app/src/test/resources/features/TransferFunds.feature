Feature: Verificar transferencia de fondos entre cuentas
  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas


  Scenario: transferir fondos de una cuenta a otra
    Given El usuario esta en el apartado de Accounts Overview y visualiza el dinero de las cuentas a transferir
    When El usuario navega al apartado Transfer Funds
      And El usuario ingresa un monto de "2" dólares
      And El usuario selecciona la cuenta de origen
      And El usuario selecciona la cuenta de destino
      And El usuario envía el formulario
    Then El usuario debería visualizar el texto Transfer Complete!
      And El usuario regresa a la página de Accounts Overview
      And El saldo de la cuenta de "origen" cambia en "-2" dolares
      And El saldo de la cuenta de "destino" cambia en "2" dolares
