from math import pi, sqrt, isclose

#  Círculo 
class Circulo:
    def __init__(self, radio: float):
        self.radio = float(radio)

    def calcular_area(self) -> float:
        return pi * (self.radio ** 2)

    def calcular_perimetro(self) -> float:
        return 2 * pi * self.radio


#  Rectángulo 
class Rectangulo:
    def __init__(self, base: float, altura: float):
        self.base = float(base)
        self.altura = float(altura)

    def calcular_area(self) -> float:
        return self.base * self.altura

    def calcular_perimetro(self) -> float:
        return 2 * self.base + 2 * self.altura


#  Cuadrado 
class Cuadrado:
    def __init__(self, lado: float):
        self.lado = float(lado)

    def calcular_area(self) -> float:
        return self.lado * self.lado

    def calcular_perimetro(self) -> float:
        return 4 * self.lado


#  Triángulo Rectángulo 
class TrianguloRectangulo:
    def __init__(self, base: float, altura: float):
        self.base = float(base)
        self.altura = float(altura)

    def calcular_area(self) -> float:
        return (self.base * self.altura) / 2

    def calcular_hipotenusa(self) -> float:
        return sqrt(self.base**2 + self.altura**2)

    def calcular_perimetro(self) -> float:
        return self.base + self.altura + self.calcular_hipotenusa()

    def determinar_tipo(self) -> str:
        """
        Clasificación por igualdad de lados (con tolerancia).
        Nota: un triángulo rectángulo no puede ser equilátero (salvo caso degenerado).
        """
        a = self.base
        b = self.altura
        c = self.calcular_hipotenusa()
        tol = 1e-9
        iguales = [
            isclose(a, b, rel_tol=0, abs_tol=tol),
            isclose(a, c, rel_tol=0, abs_tol=tol),
            isclose(b, c, rel_tol=0, abs_tol=tol),
        ]
        n_iguales = sum(iguales)
        if n_iguales == 3:
            return "Equilátero"
        elif n_iguales == 1:
            return "Isósceles"
        else:
            return "Escaleno"

    def determinarTipoTriangulo(self) -> None:
        print(f"Es un triángulo {self.determinar_tipo().lower()}")


#  Rombo 
class Rombo:
    """
    Definido por: lado, diagonal mayor (D) y diagonal menor (d).
    - Área = (D * d) / 2
    - Perímetro = 4 * lado
    """
    def __init__(self, lado: float, diagonal_mayor: float, diagonal_menor: float):
        self.lado = float(lado)
        self.diagonal_mayor = float(diagonal_mayor)
        self.diagonal_menor = float(diagonal_menor)

    def calcular_area(self) -> float:
        return (self.diagonal_mayor * self.diagonal_menor) / 2

    def calcular_perimetro(self) -> float:
        return 4 * self.lado


#  Trapecio (general) 
class Trapecio:
    
    # Definido por: base mayor (B), base menor (b), lados no paralelos (l_izq, l_der) y altura (h).
    # Área = ((B + b) * h) / 2
    # Perímetro = B + b + l_izq + l_der
    
    def __init__(self, base_mayor: float, base_menor: float,
                 lado_izquierdo: float, lado_derecho: float, altura: float):
        self.base_mayor = float(base_mayor)
        self.base_menor = float(base_menor)
        self.lado_izquierdo = float(lado_izquierdo)
        self.lado_derecho = float(lado_derecho)
        self.altura = float(altura)

    def calcular_area(self) -> float:
        return (self.base_mayor + self.base_menor) * self.altura / 2

    def calcular_perimetro(self) -> float:
        return self.base_mayor + self.base_menor + self.lado_izquierdo + self.lado_derecho


#  Demostracion
if __name__ == "__main__":
    # Círculo, Rectángulo, Cuadrado, Triángulo Rectángulo
    figura1 = Circulo(3)
    figura2 = Rectangulo(1, 2)
    figura3 = Cuadrado(3)
    figura4 = TrianguloRectangulo(3, 5)

    print("El área del círculo es =", figura1.calcular_area())
    print("El perímetro del círculo es =", figura1.calcular_perimetro())
    print()

    print("El área del rectángulo es =", figura2.calcular_area())
    print("El perímetro del rectángulo es =", figura2.calcular_perimetro())
    print()

    print("El área del cuadrado es =", figura3.calcular_area())
    print("El perímetro del cuadrado es =", figura3.calcular_perimetro())
    print()

    print("El área del triángulo es =", figura4.calcular_area())
    print("El perímetro del triángulo es =", figura4.calcular_perimetro())
    figura4.determinarTipoTriangulo()
    print()

    # Rombo y Trapecio
    rombo = Rombo(lado=5, diagonal_mayor=10, diagonal_menor=8)
    print("Rombo: área =", rombo.calcular_area(), "| perímetro =", rombo.calcular_perimetro())

    trapecio = Trapecio(base_mayor=12, base_menor=8, lado_izquierdo=5, lado_derecho=6, altura=4)
    print("Trapecio: área =", trapecio.calcular_area(), "| perímetro =", trapecio.calcular_perimetro())
