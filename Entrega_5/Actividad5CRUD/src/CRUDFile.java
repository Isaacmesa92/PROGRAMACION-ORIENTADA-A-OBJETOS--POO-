import java.io.*;
import java.util.*;

public class CRUDFile {

    private static final String FILE_NAME = "datos.txt";

    // CREATE
    public static void create(String id, String nombre, String email) throws IOException {
        FileWriter fw = new FileWriter(FILE_NAME, true);
        fw.write(id + ";" + nombre + ";" + email + "\n");
        fw.close();
    }

    // READ
    public static String read() throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return "Archivo vacío o no encontrado.";

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }

        br.close();
        return sb.toString();
    }

    // UPDATE
    public static boolean update(String id, String nuevoNombre, String nuevoEmail) throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return false;

        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts[0].equals(id)) {
                lines.add(id + ";" + nuevoNombre + ";" + nuevoEmail);
                found = true;
            } else {
                lines.add(line);
            }
        }
        br.close();

        FileWriter fw = new FileWriter(FILE_NAME);
        for (String l : lines) {
            fw.write(l + "\n");
        }
        fw.close();

        return found;
    }

    // DELETE
    public static boolean delete(String id) throws IOException {
        File file = new File(FILE_NAME);
        if (!file.exists()) return false;

        List<String> lines = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        boolean found = false;

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(";");
            if (parts[0].equals(id)) {
                found = true;
            } else {
                lines.add(line);
            }
        }
        br.close();

        FileWriter fw = new FileWriter(FILE_NAME);
        for (String l : lines) fw.write(l + "\n");
        fw.close();

        return found;
    }
}
