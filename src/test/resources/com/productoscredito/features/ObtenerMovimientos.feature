Feature: Obtener movimientos de la API
  Como usuario quiero obtener los movimientos de la API
  @obtener_movimientos
  Scenario: Obtener movimientos de la API correctamente
    Given que la API esta en linea para ingresar
    When obtengo los movimientos de la API
    Then movimientos de la API  k_transa, k_numdoc
