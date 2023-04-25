Feature: Obtener líneas de crédito de la API
  Como usuario quiero obtener las líneas de crédito de la API

  Scenario: Obtener líneas de crédito de la API correctamente
    Given que la API está en línea
    When obtengo las líneas de crédito de la API
    Then debería recibir una respuesta con las líneas de crédito de la API correspondientes

