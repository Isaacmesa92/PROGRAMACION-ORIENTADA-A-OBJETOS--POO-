package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Ventana que gestiona la salida del huésped y el cálculo del pago.
 */
public class VentanaSalida extends JFrame implements ActionListener {
    private Hotel hotel;
    private int numeroHabitacion;
    private Habitacion habitacionOcupada;
    private int posicionHabitacion = -1;

    private JLabel lblFechaIngreso;
    private JTextField campoFechaSalida;
    private JButton botonCalcular, botonRegistrar;
    private JLabel lblCantidadDias, lblTotal;

    public VentanaSalida(Hotel hotel, int numeroHabitacion) {
        this.hotel = hotel;
        this.numeroHabitacion = numeroHabitacion;
        habitacionOcupada = hotel.getHabitacionPorNumero(numeroHabitacion);
        initUI();
        setTitle("Salida huéspedes");
        setSize(360, 320);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initUI() {
        Container c = getContentPane();
        c.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5,5,5,5);

        JLabel lblHab = new JLabel("Habitación: " + numeroHabitacion);
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        c.add(lblHab, gbc);
        gbc.gridwidth = 1;

        String fechaIngreso = hotel.buscarFechaIngresoHabitacion(numeroHabitacion);
        lblFechaIngreso = new JLabel("Fecha de ingreso: " + (fechaIngreso.isEmpty() ? "-" : fechaIngreso));
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        c.add(lblFechaIngreso, gbc);
        gbc.gridwidth = 1;

        gbc.gridx = 0; gbc.gridy = 2;
        c.add(new JLabel("Fecha salida (yyyy-MM-dd):"), gbc);
        campoFechaSalida = new JTextField();
        gbc.gridx = 1; gbc.gridy = 2;
        c.add(campoFechaSalida, gbc);

        botonCalcular = new JButton("Calcular");
        botonRegistrar = new JButton("RegistrarSalida");
        botonRegistrar.setEnabled(false);

        botonCalcular.addActionListener(this);
        botonRegistrar.addActionListener(this);

        gbc.gridx = 0; gbc.gridy = 3;
        c.add(botonCalcular, gbc);
        gbc.gridx = 1; gbc.gridy = 3;
        c.add(botonRegistrar, gbc);

        lblCantidadDias = new JLabel("Cantidad de días: ");
        lblTotal = new JLabel("Total: $");

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        c.add(lblCantidadDias, gbc);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        c.add(lblTotal, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == botonCalcular) {
            try {
                String fechaS = campoFechaSalida.getText().trim();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaSalida = formato.parse(fechaS);

                Huesped h = habitacionOcupada.getHuesped();
                if (h == null || h.getFechaIngreso() == null) {
                    JOptionPane.showMessageDialog(this, "No hay huésped o fecha de ingreso", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Date fechaIngreso = h.getFechaIngreso();
                if (fechaIngreso.compareTo(fechaSalida) < 0) {
                    h.setFechaSalida(fechaSalida);
                    int dias = h.obtenerDiasAlojamiento();
                    double valor = dias * habitacionOcupada.getPrecioDia();
                    lblCantidadDias.setText("Cantidad de días: " + dias);
                    lblTotal.setText("Total: $" + String.format("%.2f", valor));
                    botonRegistrar.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this, "La fecha de salida es menor o igual a la fecha de ingreso", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (java.text.ParseException ex) {
                JOptionPane.showMessageDialog(this, "La fecha no está en el formato solicitado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (src == botonRegistrar) {
            // liberar habitacion
            habitacionOcupada.setHuesped(null);
            habitacionOcupada.setDisponible(true);
            JOptionPane.showMessageDialog(this, "Se ha registrado la salida del huésped", "OK", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        }
    }
}
