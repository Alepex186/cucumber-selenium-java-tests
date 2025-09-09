Feature: Actualizar perfil del usuario

  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas


  Scenario: Actualizar perfil del usuario
    Given El usuario esta en el apartado de Update Contact Info
    When El usuario actualiza el formulario con sus nuevos datos
      And El usuario hace click en el boton UPDATE PROFILE
    Then Deberia aparecer el mensaje Profile Updated
      And Al regresar a el apartado de Update Contact Info, deberia ver sus datos actualizados