package ventanacontacto;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class VentanaContacto extends Application {

    // Etiquetas
    Label nombres = new Label("Nombres:");
    Label apellidos = new Label("Apellidos:");
    Label fechaNacimiento = new Label("Fecha nacimiento:");
    Label direccion = new Label("Direccion:");
    Label correo = new Label("Correo:");
    Label telefono = new Label("Telefono:");

    // Campos de texto
    TextField campoNombres = new TextField();
    TextField campoApellidos = new TextField();
    DatePicker campoFechaNacimiento = new DatePicker(); // calendario
    TextField campoDireccion = new TextField();
    TextField campoCorreo = new TextField();
    TextField campoTelefono = new TextField();

    // Lista para mostrar contactos
    ListView<String> lista = new ListView<>();

    // Botón
    Button agregar = new Button("Agregar");

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);

        // Ubicar componentes
        grid.add(nombres, 0, 0);
        grid.add(campoNombres, 1, 0);

        grid.add(apellidos, 0, 1);
        grid.add(campoApellidos, 1, 1);

        grid.add(fechaNacimiento, 0, 2);
        grid.add(campoFechaNacimiento, 1, 2);

        grid.add(direccion, 0, 3);
        grid.add(campoDireccion, 1, 3);

        grid.add(telefono, 0, 4);
        grid.add(campoTelefono, 1, 4);

        grid.add(correo, 0, 5);
        grid.add(campoCorreo, 1, 5);

        // Lista de contactos
        grid.add(lista, 2, 0, 1, 7);

        // Botón
        VBox boxBoton = new VBox(agregar);
        agregar.setMaxWidth(Double.MAX_VALUE);
        grid.add(boxBoton, 0, 6, 1, 2);

        // Evento del botón
        agregar.setOnAction(e -> mostrarDatos());

        // CSS básico
        grid.setStyle(
                "-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: green;"
        );

        Scene scene = new Scene(grid, 600, 300);

        stage.setScene(scene);
        stage.setTitle("Detalles del contacto");
        stage.sizeToScene();
        stage.show();
    }

    private void mostrarDatos() {
        String a = campoNombres.getText();
        String b = campoApellidos.getText();
        LocalDate c = campoFechaNacimiento.getValue();
        String d = campoDireccion.getText();
        String e = campoTelefono.getText();
        String f = campoCorreo.getText();

        if (a.isEmpty() || b.isEmpty() || d.isEmpty() || e.isEmpty() || f.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Mensaje");
            alerta.setHeaderText("Error en ingreso de datos");
            alerta.setContentText("No se permiten campos vacíos");
            alerta.showAndWait();
        } else {
            Contacto contacto = new Contacto(a, b, c, d, e, f);

            // Lista interna (aunque no se usa luego, así lo pide el libro)
            ListaContactos listaContactos = new ListaContactos();
            listaContactos.agregarContacto(contacto);

            // Mostrar en lista gráfica
            String datos = a + " - " + b + " - " + c + " - " + d + " - " + e + " - " + f;
            lista.getItems().add(datos);

            // Limpiar campos
            campoNombres.setText("");
            campoApellidos.setText("");
            campoFechaNacimiento.setValue(null);
            campoDireccion.setText("");
            campoTelefono.setText("");
            campoCorreo.setText("");
        }
    }
}
