Feature: Buscar empleados por id en la api y realizar pruebas para validar campo

  @buscarempleado
  Scenario: Buscar empleados por id
    Given Se accede en la direccion de la api empledos id
    When Se envia peticion para traer ejecutar la consulta del empleado
    Then Se compara que la informacion del empelado consultada sea correcta