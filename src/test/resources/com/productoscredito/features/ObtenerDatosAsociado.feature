Feature: Obtener datos del asociado de la API
  Como usuario quiero obtener los datos del asociado de la API

  Scenario: Obtener datos del asociado de la API correctamente
    Given que la API esta en linea para acceder
    When obtengo los datos del asociado de la API con el cedula del asociado "1128440876"
    Then deberia recibir una respuesta con los datos del asociado correspondientes cedula, primerApellido, segundoApellido, email

