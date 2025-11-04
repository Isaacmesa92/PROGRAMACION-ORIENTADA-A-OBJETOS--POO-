package Archivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase LeerArchivo
 * Lee el contenido de un archivo de texto y lo imprime en consola.
 */
public class LeerArchivo {
    public static void main(String[] args) {
        // Ruta absoluta del archivo (ajústala si cambia el nombre o la carpeta)
        String nombreArchivo = "C:\\Users\\Usuario\\OneDrive\\Desktop\\ISAAC\\UNIVERSIDAD\\CURSANDO\\PROGRAMACION ORIENTADA A OBJETOS (POO)\\Entrega_4\\Archivos\\prueba.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo: " + e.getMessage());
        }
    }
}
