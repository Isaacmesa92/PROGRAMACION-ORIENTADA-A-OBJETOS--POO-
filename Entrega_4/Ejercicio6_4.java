public class PruebaExcepciones {
    public static void main(String[] args) {
        // Primer bloque try
        try {
            System.out.println("Ingresando al primer try");
            double cociente = 10000 / 0; // Lanza ArithmeticException
            System.out.println("Después de la división"); // nunca se ejecuta
        } catch (ArithmeticException e) { // captura la excepción aritmética
            System.out.println("División por cero");
        } finally {
            System.out.println("Ingresando al primer finally");
        }

        // Segundo bloque try
        try {
            System.out.println("Ingresando al segundo try");
            Object objeto = null;
            objeto.toString(); // Lanza NullPointerException
            System.out.println("Imprimiendo objeto"); // nunca se ejecuta
        } catch (ArithmeticException e) { // no coincide con NullPointerException
            System.out.println("División por cero");
        } catch (Exception e) { // captura la excepción (NullPointerException es una Exception)
            System.out.println("Ocurrió una excepción");
        } finally {
            System.out.println("Ingresando al segundo finally");
        }
    }
}
