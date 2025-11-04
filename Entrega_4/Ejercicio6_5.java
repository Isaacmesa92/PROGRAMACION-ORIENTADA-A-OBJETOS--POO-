import java.util.Scanner;

/**
 * Clase Vendedor: demuestra el lanzamiento de excepciones con throw.
 */
public class Vendedor {
    String nombre;
    String apellidos;
    int edad;

    // Constructor
    public Vendedor(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    // Imprimir los datos del vendedor
    void imprimir() {
        System.out.println("Nombre del vendedor = " + nombre);
        System.out.println("Apellidos del vendedor = " + apellidos);
        System.out.println("Edad del vendedor = " + edad);
    }

    // Verificar edad, lanzando excepciones si no cumple los requisitos
    void verificarEdad(int edad) {
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("La edad no puede ser negativa ni mayor a 120.");
        }
        if (edad < 18) {
            throw new IllegalArgumentException("El vendedor debe ser mayor de 18 años.");
        }
        this.edad = edad;
    }

    // Método principal
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        try {
            System.out.print("Nombre del vendedor = ");
            String n = teclado.nextLine();
            System.out.print("Apellidos del vendedor = ");
            String a = teclado.nextLine();

            Vendedor vendedor = new Vendedor(n, a);

            System.out.print("Edad del vendedor = ");
            int e = teclado.nextInt();

            vendedor.verificarEdad(e);   // Puede lanzar excepción
            vendedor.imprimir();          // Solo si no hubo excepción
        } catch (IllegalArgumentException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
