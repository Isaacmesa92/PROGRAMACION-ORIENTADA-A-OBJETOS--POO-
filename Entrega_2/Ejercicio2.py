from enum import Enum
from dataclasses import dataclass

UA_KM = 149_597_870  # 1 UA en kilómetros

class TipoPlaneta(Enum):
    GASEOSO = "GASEOSO"
    TERRESTRE = "TERRESTRE"
    ENANO = "ENANO"

@dataclass
class Planeta:
    nombre: str = None
    cantidad_satelites: int = 0
    masa_kg: float = 0.0
    volumen_km3: float = 0.0
    diametro_km: int = 0
    distancia_sol_km: int = 0
    tipo: TipoPlaneta = None
    es_observable: bool = False
    #  Nuevos atributos
    periodo_orbital_anios: float = 0.0     # en años
    periodo_rotacion_dias: float = 0.0     # en días

    def imprimir(self) -> None:
        print(f"Nombre del planeta = {self.nombre}")
        print(f"Cantidad de satélites = {self.cantidad_satelites}")
        print(f"Masa del planeta (kg) = {self.masa_kg}")
        print(f"Volumen del planeta (km^3) = {self.volumen_km3}")
        print(f"Diámetro del planeta (km) = {self.diametro_km}")
        print(f"Distancia al Sol (km) = {self.distancia_sol_km}")
        print(f"Tipo de planeta = {self.tipo.name if self.tipo else None}")
        print(f"Es observable = {self.es_observable}")
        # ➕ Impresión de los nuevos atributos
        print(f"Período orbital (años) = {self.periodo_orbital_anios}")
        print(f"Período de rotación (días) = {self.periodo_rotacion_dias}")

    def calcular_densidad(self) -> float:
        if self.volumen_km3 == 0:
            return float("inf")
        return self.masa_kg / self.volumen_km3

    def es_planeta_exterior(self) -> bool:
        limite_exterior_km = 3.4 * UA_KM
        return self.distancia_sol_km > limite_exterior_km


if __name__ == "__main__":
    # Tierra
    p1 = Planeta(
        nombre="Tierra",
        cantidad_satelites=1,
        masa_kg=5.9736e24,
        volumen_km3=1.08321e12,
        diametro_km=12_742,
        distancia_sol_km=150_000_000,
        tipo=TipoPlaneta.TERRESTRE,
        es_observable=True,
        periodo_orbital_anios=1.0,       
        periodo_rotacion_dias=0.99727,   
    )

    # Júpiter
    p2 = Planeta(
        nombre="Júpiter",
        cantidad_satelites=79,
        masa_kg=1.899e27,
        volumen_km3=1.4313e15,
        diametro_km=139_820,
        distancia_sol_km=750_000_000,
        tipo=TipoPlaneta.GASEOSO,
        es_observable=True,
        periodo_orbital_anios=11.86,     
        periodo_rotacion_dias=0.4135,    
    )

    print("Planeta 1:")
    p1.imprimir()
    print("Densidad del planeta =", p1.calcular_densidad())
    print("Es planeta exterior =", p1.es_planeta_exterior())

    print("\n Planeta 2:")
    p2.imprimir()
    print("Densidad del planeta =", p2.calcular_densidad())
    print("Es planeta exterior =", p2.es_planeta_exterior())
