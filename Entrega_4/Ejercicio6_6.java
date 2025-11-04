
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase CalculosNumericos
 * Demuestra el manejo de múltiples bloques catch.
 */
public class CalculosNumericos {

    // Método para calcular logaritmo neperiano
    static void calcularLogaritmoNeperiano(double valor) {
        try {
            if (valor < 0) {
                throw new ArithmeticException("El valor debe ser un número positivo");
            }
            double resultado = Math.log(valor);
            System.out.println("Resultado logaritmo = " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: El valor debe ser positivo para calcular el logaritmo.");
        } catch (InputMismatchException e) {
            System.out.println("Error: El valor debe ser numérico para calcular el logaritmo.");
        } finally {
            System.out.println("Fin del cálculo de logaritmo.\n");
        }
    }

    // Método para calcular raíz cuadrada
    static void calcularRaizCuadrada(double valor) {
        try {
            if (valor < 0) {
                throw new ArithmeticException("El valor debe ser un número positivo");
            }
            double resultado = Math.sqrt(valor);
            System.out.println("Resultado raíz cuadrada = " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: El valor debe ser positivo para calcular la raíz cuadrada.");
        } catch (InputMismatchException e) {
            System.out.println("Error: El valor debe ser numérico para calcular la raíz cuadrada.");
        } finally {
            System.out.println("Fin del cálculo de raíz cuadrada.\n");
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.print("Valor numérico = ");
            double valor = teclado.nextDouble();
            calcularLogaritmoNeperiano(valor);
            calcularRaizCuadrada(valor);
        } catch (InputMismatchException e) {
            System.out.println("Error: Debe ingresar un número válido.");
        }
    }
}
