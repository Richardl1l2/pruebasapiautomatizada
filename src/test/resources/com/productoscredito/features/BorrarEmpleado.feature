Feature: Eliminar empleado por id

  @borrarempleado
  Scenario: Escoger un id de empleado y proceder a eliminarlo
    Given Se envia peticion para eliminar usuario
    When Se procede a borrar el usuario con el id a eliminar
    Then Se verifica el usuario eliminado de forma correcta