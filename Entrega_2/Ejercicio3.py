from enum import Enum
from dataclasses import dataclass, field

class TipoCombustible(Enum):
    GASOLINA = "GASOLINA"
    BIOETANOL = "BIOETANOL"
    DIESEL = "DIESEL"
    BIODIESEL = "BIODIESEL"
    GAS_NATURAL = "GAS_NATURAL"

class TipoAutomovil(Enum):
    CIUDAD = "CIUDAD"
    SUBCOMPACTO = "SUBCOMPACTO"
    COMPACTO = "COMPACTO"
    FAMILIAR = "FAMILIAR"
    EJECUTIVO = "EJECUTIVO"
    SUV = "SUV"

class Color(Enum):
    BLANCO = "BLANCO"
    NEGRO = "NEGRO"
    ROJO = "ROJO"
    NARANJA = "NARANJA"
    AMARILLO = "AMARILLO"
    VERDE = "VERDE"
    AZUL = "AZUL"
    VIOLETA = "VIOLETA"

@dataclass
class Automovil:
    # ----- Atributos “modelo de datos” -----
    marca: str
    modelo: int
    motor: float
    tipo_combustible: TipoCombustible
    tipo_automovil: TipoAutomovil
    numero_puertas: int
    cantidad_asientos: int
    velocidad_maxima: int               # km/h
    color: Color
    es_automatico: bool = False         # <--- NUEVO
    velocidad_actual: int = 0           # km/h

    # Gestión de multas
    _multas: list[float] = field(default_factory=list, repr=False)
    _base_multa: float = field(default=100.0, repr=False)  # puedes ajustar el valor base

    #  GETTERS 
    def getMarca(self): return self.marca
    def getModelo(self): return self.modelo
    def getMotor(self): return self.motor
    def getTipoCombustible(self): return self.tipo_combustible
    def getTipoAutomóvil(self): return self.tipo_automovil
    def getNúmeroPuertas(self): return self.numero_puertas
    def getCantidadAsientos(self): return self.cantidad_asientos
    def getVelocidadMáxima(self): return self.velocidad_maxima
    def getColor(self): return self.color
    def getVelocidadActual(self): return self.velocidad_actual
    def getEsAutomatico(self): return self.es_automatico           # <--- NUEVO

    #  SETTERS 
    def setMarca(self, marca): self.marca = marca
    def setModelo(self, modelo): self.modelo = int(modelo)
    def setMotor(self, motor): self.motor = float(motor)
    def setTipoCombustible(self, tipo): self.tipo_combustible = TipoCombustible(tipo) if isinstance(tipo, str) else tipo
    def setTipoAutomóvil(self, tipo): self.tipo_automovil = TipoAutomovil(tipo) if isinstance(tipo, str) else tipo
    def setNúmeroPuertas(self, n): self.numero_puertas = int(n)
    def setCantidadAsientos(self, n): self.cantidad_asientos = int(n)
    def setVelocidadMáxima(self, v): self.velocidad_maxima = int(v)
    def setColor(self, color): self.color = Color(color) if isinstance(color, str) else color
    def setVelocidadActual(self, v): self.velocidad_actual = max(0, int(v))
    def setEsAutomatico(self, es_auto: bool): self.es_automatico = bool(es_auto)   # <--- NUEVO

    #  COMPORTAMIENTO 
    def _registrar_multa(self) -> None:
        """
        Registra una multa creciente: 1ª multa = base, 2ª = 2*base, 3ª = 3*base, ...
        """
        monto = self._base_multa * (len(self._multas) + 1)
        self._multas.append(monto)
        print(f"Multa registrada por exceder la velocidad máxima: ${monto:,.2f}")

    def acelerar(self, incremento_velocidad: int) -> None:
        """Incrementa la velocidad; si supera la máxima, no acelera y registra una multa creciente."""
        incremento_velocidad = int(incremento_velocidad)
        nueva = self.velocidad_actual + incremento_velocidad
        if nueva <= self.velocidad_maxima:
            self.velocidad_actual = nueva
        else:
            print("No se puede incrementar por encima de la velocidad máxima del automóvil.")
            self._registrar_multa()

    def desacelerar(self, decremento_velocidad: int) -> None:
        """Disminuye la velocidad sin caer por debajo de 0 km/h."""
        decremento_velocidad = int(decremento_velocidad)
        nueva = self.velocidad_actual - decremento_velocidad
        if nueva >= 0:
            self.velocidad_actual = nueva
        else:
            print("No se puede decrementar a una velocidad negativa.")

    def frenar(self) -> None:
        self.velocidad_actual = 0

    def calcularTiempoLlegada(self, distancia_km: float) -> float:
        if self.velocidad_actual <= 0:
            print("No es posible calcular tiempo: la velocidad actual es 0 km/h.")
            return float("inf")
        return float(distancia_km) / self.velocidad_actual

    #  Multas 
    def tieneMultas(self) -> bool:
        return len(self._multas) > 0

    def totalMultas(self) -> float:
        return sum(self._multas)

    #  Utilidad 
    def imprimir(self) -> None:
        print(f"Marca = {self.marca}")
        print(f"Modelo = {self.modelo}")
        print(f"Motor (L) = {self.motor}")
        print(f"Tipo de combustible = {self.tipo_combustible.value}")
        print(f"Tipo de automóvil = {self.tipo_automovil.value}")
        print(f"Número de puertas = {self.numero_puertas}")
        print(f"Cantidad de asientos = {self.cantidad_asientos}")
        print(f"Velocidad máxima (km/h) = {self.velocidad_maxima}")
        print(f"Color = {self.color.value}")
        print(f"¿Automático? = {self.es_automatico}")
        print(f"Velocidad actual (km/h) = {self.velocidad_actual}")
        print(f"Multas registradas = {len(self._multas)} | Total = ${self.totalMultas():,.2f}")

# Demostracion
if __name__ == "__main__":
    auto = Automovil(
        marca="Ford", modelo=2018, motor=3.0,
        tipo_combustible=TipoCombustible.DIESEL,
        tipo_automovil=TipoAutomovil.EJECUTIVO,
        numero_puertas=5, cantidad_asientos=6,
        velocidad_maxima=120, color=Color.NEGRO,
        es_automatico=True
    )
    auto.imprimir()
    auto.setVelocidadActual(110)
    auto.acelerar(5)    # OK -> 115
    auto.acelerar(10)   # Excede -> multa 1 (100)
    auto.acelerar(20)   # Excede -> multa 2 (200)

    print("Tiene multas:", auto.tieneMultas())
    print("Total multas: $", auto.totalMultas())
