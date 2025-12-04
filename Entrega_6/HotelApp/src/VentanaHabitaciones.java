package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Muestra las 10 habitaciones y permite seleccionar una para ingreso.
 */
public class VentanaHabitaciones extends JFrame implements ActionListener {
    private Hotel hotel;
    private JSpinner spinnerHabitacion;
    private JButton botonAceptar;

    // etiquetas para mostrar disponibilidad
    private JLabel[] etiquetasDisponibilidad = new JLabel[10];

    public VentanaHabitaciones(Hotel hotel) {
        this.hotel = hotel;
        initUI();
        setTitle("Habitaciones");
        setSize(760, 260);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void initUI() {
        Container c = getContentPane();
        c.setLayout(null);

        // posiciones: dos filas de 5 columnas
        for (int i = 0; i < 10; i++) {
            int col = (i % 5);
            int row = (i / 5);
            JLabel lblHab = new JLabel("Habitación " + (i + 1));
            lblHab.setBounds(20 + col * 140, 30 + row * 90, 120, 23);
            JLabel lblDisp = new JLabel();
            lblDisp.setBounds(20 + col * 140, 50 + row * 90, 120, 23);

            Habitacion h = hotel.getHabitacionPorNumero(i + 1);
            lblDisp.setText(h.isDisponible() ? "Disponible" : "No disponible");

            c.add(lblHab);
            c.add(lblDisp);
            etiquetasDisponibilidad[i] = lblDisp;
        }

        JLabel lblSeleccion = new JLabel("Habitación a reservar:");
        lblSeleccion.setBounds(250, 180, 150, 23);
        spinnerHabitacion = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        spinnerHabitacion.setBounds(380, 180, 50, 23);
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(500, 180, 100, 23);
        botonAceptar.addActionListener(this);

        c.add(lblSeleccion);
        c.add(spinnerHabitacion);
        c.add(botonAceptar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int numero = (int) spinnerHabitacion.getValue();
        if (!hotel.buscarHabitacionOcupada(numero)) {
            // abrir ventana de ingreso
            this.setVisible(false);
            new VentanaIngreso(hotel, numero).setVisible(true);
            // cuando vuelva a mostrarse la ventana, deberíamos actualizar disponibilidad
        } else {
            JOptionPane.showMessageDialog(this, "La habitación está ocupada", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
