package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Ventana para ingresar datos del huésped y fecha de ingreso.
 * Layout: GridBagLayout (como pide el enunciado).
 */
public class VentanaIngreso extends JFrame implements ActionListener {
    private Hotel hotel;
    private int numeroHabitacion;
    private Habitacion habitacionReservada;

    private JTextField campoFechaIngreso, campoNombre, campoApellidos, campoDocumento;
    private JButton aceptar, cancelar;

    public VentanaIngreso(Hotel hotel, int numeroHabitacion) {
        this.hotel = hotel;
        this.numeroHabitacion = numeroHabitacion;
        habitacionReservada = hotel.getHabitacionPorNumero(numeroHabitacion);
        initUI();
        setTitle("Ingreso");
        setSize(360, 300);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initUI() {
        Container c = getContentPane();
        c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);

        JLabel lblHabitacion = new JLabel("Habitación: " + numeroHabitacion);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        c.add(lblHabitacion, gbc);

        gbc.gridwidth = 1;
        gbc.gridx = 0; gbc.gridy = 1;
        c.add(new JLabel("Fecha (yyyy-mm-dd):"), gbc);
        campoFechaIngreso = new JTextField();
        gbc.gridx = 1; gbc.gridy = 1;
        c.add(campoFechaIngreso, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        c.add(new JLabel("Nombre:"), gbc);
        campoNombre = new JTextField();
        gbc.gridx = 1; gbc.gridy = 2;
        c.add(campoNombre, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        c.add(new JLabel("Apellidos:"), gbc);
        campoApellidos = new JTextField();
        gbc.gridx = 1; gbc.gridy = 3;
        c.add(campoApellidos, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        c.add(new JLabel("Doc. Identidad:"), gbc);
        campoDocumento = new JTextField();
        gbc.gridx = 1; gbc.gridy = 4;
        c.add(campoDocumento, gbc);

        aceptar = new JButton("Aceptar");
        cancelar = new JButton("Cancelar");
        aceptar.addActionListener(this);
        cancelar.addActionListener(this);

        gbc.gridx = 0; gbc.gridy = 5;
        c.add(aceptar, gbc);
        gbc.gridx = 1; gbc.gridy = 5;
        c.add(cancelar, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == aceptar) {
            try {
                String fechaStr = campoFechaIngreso.getText().trim();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = formato.parse(fechaStr);

                String nombre = campoNombre.getText().trim();
                String apellidos = campoApellidos.getText().trim();
                int doc = Integer.parseInt(campoDocumento.getText().trim());

                if (nombre.isEmpty() || apellidos.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Los campos obligatorios deben ser completados", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Huesped h = new Huesped(nombre, apellidos, doc);
                h.setFechaIngreso(fecha);
                habitacionReservada.setHuesped(h);
                habitacionReservada.setDisponible(false);

                JOptionPane.showMessageDialog(this, "El huésped ha sido registrado", "OK", JOptionPane.INFORMATION_MESSAGE);
                this.setVisible(false);

            } catch (java.text.ParseException ex) {
                JOptionPane.showMessageDialog(this, "La fecha no está en el formato solicitado (yyyy-MM-dd)", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Documento debe ser numérico", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error en datos ingresados", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (src == cancelar) {
            this.setVisible(false);
        }
    }
}
