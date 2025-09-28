class Persona:
    # Constructor de la clase
    #   __init__ es el método especial que se ejecuta al crear el objeto
    def __init__(self, nombre: str, apellido: str, documento: str, anio_nacimiento: int):
        # 'self' es una referencia al objeto que se está creando (equivalente a 'this' en Java).
        # Al asignar a self.<atributo>, estamos creando y guardando esos datos dentro del objeto.
        self.nombre = nombre
        self.apellido = apellido
        self.documento = documento
        self.anio_nacimiento = anio_nacimiento

    # Método de instancia que imprime los valores de los atributos.
    def imprimir_datos(self) -> None:
        # El operador punto (.) se usa igual que en Java para acceder
        # a atributos y métodos del objeto: objeto.atributo / objeto.metodo()
        print(f"Nombre: {self.nombre}")
        print(f"Apellido: {self.apellido}")
        print(f"Documento: {self.documento}")
        print(f"Año de nacimiento: {self.anio_nacimiento}")



if __name__ == "__main__":
    # Instanciación de objetos:
    #   Llamamos al constructor Persona(...) con los valores necesarios.
    #   En Java sería: Persona p = nueva Persona(...);
    persona1 = Persona("Ana", "Pérez", "CC 12345678", 1995)
    persona2 = Persona("Luis", "García", "CC 87654321", 1990)

    
    print("Persona 1:")
    # Llamamos al método que imprime los atributos
    persona1.imprimir_datos()

    print("\n Persona 2:")
    persona2.imprimir_datos()