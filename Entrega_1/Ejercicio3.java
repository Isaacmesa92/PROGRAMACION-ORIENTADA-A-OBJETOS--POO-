package Entrega_1;

public class Ejercicio3 {
    public static void main(String[] args) {
        // Declaración de variables
        int HORAS = 48;
        int VALOR_HORA = 5000;
        double SALARIO_BRUTO, RETENCION, SALARIO_NETO;

        // Proceso
        SALARIO_BRUTO = HORAS * VALOR_HORA;
        RETENCION = SALARIO_BRUTO * 0.125;  // 12.5%
        SALARIO_NETO = SALARIO_BRUTO - RETENCION;

        // Salida de resultados
        System.out.println("Salario Bruto: $" + SALARIO_BRUTO);
        System.out.println("Retención en la fuente (12.5%): $" + RETENCION);
        System.out.println("Salario Neto: $" + SALARIO_NETO);
    }
}
