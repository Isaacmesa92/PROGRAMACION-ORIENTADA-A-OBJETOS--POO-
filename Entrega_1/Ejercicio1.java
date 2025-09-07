package Entrega_1;
import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        // Definición de variables
        int EDJUAN, EDALBER, EDANA, EDMAMA;

        // Entrada de datos
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la edad de Juan: ");
        EDJUAN = sc.nextInt();

        // Proceso
        EDALBER = (2 * EDJUAN) / 3;
        EDANA   = (4 * EDJUAN) / 3;
        EDMAMA  = EDJUAN + EDALBER + EDANA;

        // Salida de resultados
        System.out.println("Las edades son:");
        System.out.println("Alberto = " + EDALBER + " años");
        System.out.println("Juan = " + EDJUAN + " años");
        System.out.println("Ana = " + EDANA + " años");
        System.out.println("Mamá = " + EDMAMA + " años");

        sc.close();
    }
}
