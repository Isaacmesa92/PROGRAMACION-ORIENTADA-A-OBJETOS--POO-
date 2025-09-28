class Persona:
    """
    Modelo de Persona con:
    - nombre, apellidos
    - número de documento de identidad
    - año de nacimiento
    - país de nacimiento (NUEVO)
    - género ('H' o 'M') (NUEVO)
    """
    def __init__(
        self,
        nombre: str,
        apellidos: str,
        numero_documento_identidad: str,
        anio_nacimiento: int,
        pais_nacimiento: str,
        genero: str,  # 'H' (hombre) o 'M' (mujer)
    ):
        # 'self' en Python equivale a 'this' en Java
        self.nombre = nombre
        self.apellidos = apellidos
        self.numero_documento_identidad = numero_documento_identidad
        self.anio_nacimiento = int(anio_nacimiento)
        self.pais_nacimiento = pais_nacimiento

        genero = (genero or "").strip().upper()
        if genero not in ("H", "M"):
            raise ValueError("El género debe ser 'H' o 'M'.")
        self.genero = genero

    def imprimir(self) -> None:
        print(f"Nombre = {self.nombre}")
        print(f"Apellidos = {self.apellidos}")
        print(f"Número de documento de identidad = {self.numero_documento_identidad}")
        print(f"Año de nacimiento = {self.anio_nacimiento}")
        print(f"País de nacimiento = {self.pais_nacimiento}")
        print(f"Género = {self.genero}")
        print()  # línea en blanco

# Demostracion
if __name__ == "__main__":
    p1 = Persona(
        "Pedro", "Pérez", "1053121010", 1998,
        pais_nacimiento="Colombia",
        genero="H"
    )
    p2 = Persona(
        "Luisa", "León", "1053223344", 2001,
        pais_nacimiento="Perú",
        genero="M"
    )
    p1.imprimir()
    p2.imprimir()
