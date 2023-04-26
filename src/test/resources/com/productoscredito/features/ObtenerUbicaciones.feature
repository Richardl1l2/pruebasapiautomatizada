Feature: Obtener ubicaciones

Como usuario de la aplicación
Quiero obtener una lista de ubicaciones disponibles
Para poder seleccionar una ubicación para mi solicitud
  @obtener_ubicaciones
  Scenario: Obtener ubicaciones válidas
    Given se conecta la API
    When se solicita la consulta del departamento
    Then la aplicación devuelve una lista de ciudades nombreDepartamento: "AMAZONAS"

