package hotel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ventana principal con el menú.
 */
public class VentanaPrincipal extends JFrame implements ActionListener {
    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem itemConsultar, itemSalida;
    private Hotel hotel;

    public VentanaPrincipal(Hotel hotel) {
        this.hotel = hotel;
        initUI();
        setTitle("Hotel");
        setSize(320, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void initUI() {
        barraMenu = new JMenuBar();
        menu = new JMenu("Menú");
        itemConsultar = new JMenuItem("Consultar habitaciones");
        itemSalida = new JMenuItem("Salida de huéspedes");

        menu.add(itemConsultar);
        menu.add(itemSalida);
        barraMenu.add(menu);
        setJMenuBar(barraMenu);

        itemConsultar.addActionListener(this);
        itemSalida.addActionListener(this);

        // simple panel instructivo
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        JLabel label = new JLabel("<html><center>Seleccione una opción en el menú.<br>" +
                "Consultar habitaciones → reservar</center></html>", SwingConstants.CENTER);
        c.add(label, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == itemConsultar) {
            new VentanaHabitaciones(hotel).setVisible(true);
        } else if (src == itemSalida) {
            try {
                String input = JOptionPane.showInputDialog(this,
                        "Ingrese número de habitación (1-10):", "Salida de huéspedes", JOptionPane.QUESTION_MESSAGE);
                if (input == null) return; // cancelado
                int numero = Integer.parseInt(input.trim());
                if (numero < 1 || numero > 10) {
                    JOptionPane.showMessageDialog(this, "Número debe estar entre 1 y 10", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (hotel.buscarHabitacionOcupada(numero)) {
                    new VentanaSalida(hotel, numero).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "La habitación ingresada no ha sido ocupada", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Campo nulo o error en formato de número", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
