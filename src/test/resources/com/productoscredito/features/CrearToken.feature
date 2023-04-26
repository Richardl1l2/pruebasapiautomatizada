Feature: Crear token para acceso

  @creartoken
  Scenario: Crear token para dar autorizacion en las diferentes peticiones API
    Given Ingresa las credenciales del usuario
    When Se ingresa la informacion para generar el token
    Then Se verifica que se recibio el token