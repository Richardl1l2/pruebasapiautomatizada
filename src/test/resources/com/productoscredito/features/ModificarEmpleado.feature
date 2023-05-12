Feature: Modificar empleado con el id

  @modificarempleado
  Scenario: Escoger un id de empleado y modificar un campo
    Given Se envia peticion para realizar modificacion
    When Se modifica el id de usuario selecionado
    Then Se verifica que la modificacion se haga efectiva