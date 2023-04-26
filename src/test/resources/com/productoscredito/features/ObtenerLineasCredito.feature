Feature: Obtener creditos radicados

Como usuario de la aplicacion
Quiero obtener una lista de creditos radicados
Para poder ver los creditos que estan en proceso
  @obtener_linas_credito
  Scenario: Obtener creditos radicados validos
    Given que el usuario ha iniciado sesion en la aplicacion
    When el usuario solicita la lista de creditos radicados
    Then la aplicacion devuelve una lista de todos los creditos radicados
