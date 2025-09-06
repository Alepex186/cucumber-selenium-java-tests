Feature: Verificar transferencia de fondos entre cuentas
  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas


  Scenario: transferir fondos de una cuenta a otra
    Given El usuario esta en el apartado de Accounts Overview y visualiza el dinero de las cuentas a transferir
    When El usuario navega a Transfer Funds
      And Ingresa un monto a enviar de "2" dolares
      And Selecciona la cuenta de origen
      And Selecciona la cuenta de destino
      And El usuario envia el formulario
    Then Deberia visualizarse el texto Transfer Complete!
      And El usuario regresa a la pagina de Accounts Overview
      And El saldo de la cuenta de "origen" cambia en "-2" dolares
      And El saldo de la cuenta de "destino" cambia en "2" dolares
