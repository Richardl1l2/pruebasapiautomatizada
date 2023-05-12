Feature: Crear empleado en api

  @crearempleado
  Scenario: Crear empleado para verificar respuesta api
    Given Se envia peticion para creacion empleado
    When Se crea el empleado
    Then Se verifica el empelado creado