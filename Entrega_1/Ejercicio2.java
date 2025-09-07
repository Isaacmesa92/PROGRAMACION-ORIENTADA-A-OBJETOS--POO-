package Entrega_1;

public class Ejercicio2 {
    public static void main(String[] args) {
        // Declaración de variables
        double SUMA;
        int X, Y;

        // Inicio del algoritmo
        SUMA = 0;
        X = 20;
        SUMA = SUMA + X;
        Y = 40;
        X = X + (int)Math.pow(Y, 2);  // Y^2
        SUMA = SUMA + (double) X / Y;

        // Salida de resultados
        System.out.println("El valor de la suma es: " + SUMA);
    }
}
