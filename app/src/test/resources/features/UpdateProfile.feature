Feature: Actualizar perfil del usuario

  Background:
    Given El usuario ha iniciado sesión en el sistema con credenciales válidas


  Scenario: Actualizar perfil del usuario
    Given El usuario se encuentra en el apartado Update Contact Info
    When El usuario completa el formulario con sus nuevos datos
      And El usuario hace click en el boton UPDATE PROFILE
    Then El usuario debería visualizar el mensaje Profile Updated
      And Al regresar al apartado Update Contact Info, el usuario debería visualizar sus datos actualizados