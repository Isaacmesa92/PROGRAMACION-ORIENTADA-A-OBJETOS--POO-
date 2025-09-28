from dataclasses import dataclass, field
from enum import Enum


class TipoCuenta(Enum):
    AHORROS = "AHORROS"
    CORRIENTE = "CORRIENTE"


@dataclass
class CuentaBancaria:
    """
    Clase que modela una cuenta bancaria con:
    - nombres y apellidos del titular
    - número de cuenta
    - tipo de cuenta (ahorros/corriente)
    - saldo (inicia en 0)
    - interés mensual en porcentaje (p. ej., 1.5 = 1.5%)
    """
    nombres_titular: str
    apellidos_titular: str
    numero_cuenta: int
    tipo_cuenta: TipoCuenta
    saldo: float = field(default=0.0)
    interes_mensual_pct: float = field(default=0.0)  # porcentaje mensual

    # Métodos utilitarios (sin retorno)
    def imprimir(self) -> None:
        print(f"Nombres del titular = {self.nombres_titular}")
        print(f"Apellidos del titular = {self.apellidos_titular}")
        print(f"Número de cuenta = {self.numero_cuenta}")
        print(f"Tipo de cuenta = {self.tipo_cuenta.value}")
        print(f"Saldo = ${self.saldo:,.2f}")
        print(f"Interés mensual = {self.interes_mensual_pct:.4f}%")

    def consultar_saldo(self) -> None:
        print(f"El saldo actual es = ${self.saldo:,.2f}")

    # Operaciones con parámetros (con retorno)
    def consignar(self, valor: float) -> bool:
        # Consigna 'valor' si es > 0. Actualiza saldo y retorna True en éxito.
    
        if valor > 0:
            self.saldo += valor
            print(f"Se ha consignado ${valor:,.2f}. Nuevo saldo: ${self.saldo:,.2f}")
            return True
        print("El valor a consignar debe ser mayor que cero.")
        return False

    def retirar(self, valor: float) -> bool:
        #Retira 'valor' si es > 0 y no supera el saldo. Retorna True en éxito.
        if valor > 0 and valor <= self.saldo:
            self.saldo -= valor
            print(f"Se ha retirado ${valor:,.2f}. Nuevo saldo: ${self.saldo:,.2f}")
            return True
        print("El valor a retirar debe ser mayor que 0 y menor o igual que el saldo actual.")
        return False

    # Interés mensual
    def interes_mensual(self) -> float:
        
        return self.saldo * (self.interes_mensual_pct / 100.0)

    def aplicar_interes(self) -> float:
       
        interes = self.interes_mensual()
        self.saldo += interes
        print(f"Interés aplicado: ${interes:,.2f}. Saldo actualizado: ${self.saldo:,.2f}")
        return self.saldo


# Demostracion
if __name__ == "__main__":
    cuenta = CuentaBancaria(
        nombres_titular="Pedro",
        apellidos_titular="Pérez",
        numero_cuenta=123456789,
        tipo_cuenta=TipoCuenta.AHORROS,
        interes_mensual_pct=1.2,   # 1.2% mensual
    )
    cuenta.imprimir()
    cuenta.consignar(200_000)
    cuenta.consignar(300_000)
    cuenta.retirar(400_000)
    cuenta.consultar_saldo()

    # Aplicar interés dos meses
    cuenta.aplicar_interes()
    cuenta.aplicar_interes()
    cuenta.consultar_saldo()
