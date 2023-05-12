Feature: Mostrar empleados generados de la api

  @mostrarempleados
  Scenario: Mostrar empleados de la api
    Given Se accede en la direccion de la api
    When Se envia peticion para traer archivo json con todos los empleados
    Then Se compara el json actual con el json de la api