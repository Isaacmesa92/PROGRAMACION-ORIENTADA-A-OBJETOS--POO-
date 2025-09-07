package Entrega_1;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        // Declaración de variables
        int NUM;
        int CUADRADO, CUBO;

        // Entrada de datos
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        NUM = sc.nextInt();

        // Proceso
        CUADRADO = (int) Math.pow(NUM, 2);
        CUBO = (int) Math.pow(NUM, 3);

        // Salida de resultados
        System.out.println("Número ingresado: " + NUM);
        System.out.println("Cuadrado: " + CUADRADO);
        System.out.println("Cubo: " + CUBO);

        sc.close();
    }
}
