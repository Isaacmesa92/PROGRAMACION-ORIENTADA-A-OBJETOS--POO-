import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class GUI extends JFrame {

    JTextField idField, nombreField, emailField;
    JTextArea display;

    public GUI() {
        setTitle("CRUD con Archivos - Actividad 5");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(3, 2));
        form.add(new JLabel("ID:"));
        idField = new JTextField();
        form.add(idField);

        form.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        form.add(nombreField);

        form.add(new JLabel("Email:"));
        emailField = new JTextField();
        form.add(emailField);

        add(form, BorderLayout.NORTH);

        // Botones
        JPanel buttons = new JPanel();
        JButton createBtn = new JButton("Create");
        JButton readBtn = new JButton("Read");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        buttons.add(createBtn);
        buttons.add(readBtn);
        buttons.add(updateBtn);
        buttons.add(deleteBtn);

        add(buttons, BorderLayout.CENTER);

        // Área de texto
        display = new JTextArea();
        add(new JScrollPane(display), BorderLayout.SOUTH);

        // Eventos
        createBtn.addActionListener(e -> create());
        readBtn.addActionListener(e -> read());
        updateBtn.addActionListener(e -> update());
        deleteBtn.addActionListener(e -> delete());
    }

    private void create() {
        try {
            CRUDFile.create(idField.getText(), nombreField.getText(), emailField.getText());
            display.setText("Registro creado correctamente.");
        } catch (IOException ex) {
            display.setText("Error creando registro.");
        }
    }

    private void read() {
        try {
            display.setText(CRUDFile.read());
        } catch (IOException e) {
            display.setText("Error leyendo archivo.");
        }
    }

    private void update() {
        try {
            boolean ok = CRUDFile.update(idField.getText(), nombreField.getText(), emailField.getText());
            display.setText(ok ? "Registro actualizado." : "ID no encontrado.");
        } catch (IOException e) {
            display.setText("Error actualizando registro.");
        }
    }

    private void delete() {
        try {
            boolean ok = CRUDFile.delete(idField.getText());
            display.setText(ok ? "Registro eliminado." : "ID no encontrado.");
        } catch (IOException e) {
            display.setText("Error eliminando registro.");
        }
    }
}
