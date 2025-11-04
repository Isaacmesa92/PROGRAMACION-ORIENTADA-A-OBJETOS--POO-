package Equipo;

import java.util.Scanner;

/**
 * Clase EquipoMaratonProgramacion
 * Modela un equipo de programadores y valida los datos con excepciones.
 */
public class EquipoMaratonProgramacion {

    String nombreEquipo;
    String universidad;
    String lenguajeProgramacion;
    Programador[] programadores;
    int tamanoEquipo;

    // Constructor
    public EquipoMaratonProgramacion(String nombreEquipo, String universidad, String lenguajeProgramacion) {
        this.nombreEquipo = nombreEquipo;
        this.universidad = universidad;
        this.lenguajeProgramacion = lenguajeProgramacion;
        this.tamanoEquipo = 0;
        this.programadores = new Programador[3]; // máximo tres integrantes
    }

    // Determina si el equipo está completo
    boolean estaLleno() {
        return tamanoEquipo == programadores.length;
    }

    // Añadir un programador
    void anadir(Programador programador) throws Exception {
        if (estaLleno()) {
            throw new Exception("El equipo está completo. No se pudo agregar programador.");
        }
        programadores[tamanoEquipo] = programador;
        tamanoEquipo++;
    }

    // Validar campo de texto
    static void validarCampo(String campo) throws Exception {
        for (int j = 0; j < campo.length(); j++) {
            char c = campo.charAt(j);
            if (Character.isDigit(c)) {
                throw new Exception("El nombre o apellido no puede contener dígitos.");
            }
        }
        if (campo.length() >= 20) {
            throw new Exception("El texto no debe superar los 20 caracteres.");
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        try {
            System.out.print("Nombre del equipo = ");
            String nombre = teclado.nextLine();

            System.out.print("Universidad = ");
            String universidad = teclado.nextLine();

            System.out.print("Lenguaje de programación = ");
            String lenguaje = teclado.nextLine();

            EquipoMaratonProgramacion equipo = new EquipoMaratonProgramacion(nombre, universidad, lenguaje);

            System.out.println("\n--- Ingreso de integrantes del equipo ---");
            for (int i = 0; i < 3; i++) {
                System.out.print("Nombre del integrante " + (i + 1) + " = ");
                String nombreProg = teclado.nextLine();
                validarCampo(nombreProg);

                System.out.print("Apellidos del integrante " + (i + 1) + " = ");
                String apellidosProg = teclado.nextLine();
                validarCampo(apellidosProg);

                Programador p = new Programador(nombreProg, apellidosProg);
                equipo.anadir(p);
            }

            System.out.println("\nEquipo registrado correctamente.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
