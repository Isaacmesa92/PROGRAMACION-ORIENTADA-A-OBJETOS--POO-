package Entrega_1;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        // Declaración de variables
        double RADIO, AREA, LONGITUD;

        // Entrada de datos
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el radio del círculo: ");
        RADIO = sc.nextDouble();

        // Proceso
        AREA = Math.PI * Math.pow(RADIO, 2);
        LONGITUD = 2 * Math.PI * RADIO;

        // Salida de resultados
        System.out.println("Radio ingresado: " + RADIO);
        System.out.println("Área del círculo: " + AREA);
        System.out.println("Longitud de la circunferencia: " + LONGITUD);

        sc.close();
    }
}

