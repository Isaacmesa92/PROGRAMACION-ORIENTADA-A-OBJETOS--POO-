package Ventana;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container cont;
    private JComboBox<String> comboProducto;
    private JRadioButton rbtPeq, rbtMed, rbtGra;
    private JCheckBox chkBluetooth, chkWifi, chkUSB;
    private JButton btnCalcular, btnLimpiar;
    private JLabel lblResultado;
    private ButtonGroup grupoTamanos;

    public VentanaPrincipal() {
        setTitle("Calculadora de precio de producto");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        cont = getContentPane();
        cont.setLayout(null);

        JLabel lblProducto = new JLabel("Producto:");
        lblProducto.setBounds(30, 20, 100, 25);
        cont.add(lblProducto);

        comboProducto = new JComboBox<>(new String[]{"Televisor", "Radio", "DVD"});
        comboProducto.setBounds(150, 20, 180, 25);
        cont.add(comboProducto);

        JLabel lblTamano = new JLabel("Tamaño:");
        lblTamano.setBounds(30, 60, 100, 25);
        cont.add(lblTamano);

        rbtPeq = new JRadioButton("Pequeño");
        rbtMed = new JRadioButton("Mediano");
        rbtGra = new JRadioButton("Grande");

        rbtPeq.setBounds(150, 60, 100, 25);
        rbtMed.setBounds(150, 85, 100, 25);
        rbtGra.setBounds(150, 110, 100, 25);

        grupoTamanos = new ButtonGroup();
        grupoTamanos.add(rbtPeq);
        grupoTamanos.add(rbtMed);
        grupoTamanos.add(rbtGra);
        rbtPeq.setSelected(true);

        cont.add(rbtPeq);
        cont.add(rbtMed);
        cont.add(rbtGra);

        JLabel lblExtras = new JLabel("Extras:");
        lblExtras.setBounds(30, 150, 100, 25);
        cont.add(lblExtras);

        chkBluetooth = new JCheckBox("Bluetooth");
        chkWifi = new JCheckBox("WiFi");
        chkUSB = new JCheckBox("USB");

        chkBluetooth.setBounds(150, 150, 100, 25);
        chkWifi.setBounds(150, 175, 100, 25);
        chkUSB.setBounds(150, 200, 100, 25);

        cont.add(chkBluetooth);
        cont.add(chkWifi);
        cont.add(chkUSB);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(60, 240, 110, 30);
        btnCalcular.addActionListener(this);
        cont.add(btnCalcular);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(200, 240, 110, 30);
        btnLimpiar.addActionListener(this);
        cont.add(btnLimpiar);

        lblResultado = new JLabel("Precio total: $0.00");
        lblResultado.setBounds(30, 280, 300, 25);
        cont.add(lblResultado);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            String producto = (String) comboProducto.getSelectedItem();
            String tamano = rbtPeq.isSelected() ? "Pequeño" :
                            rbtMed.isSelected() ? "Mediano" : "Grande";

            boolean bluetooth = chkBluetooth.isSelected();
            boolean wifi = chkWifi.isSelected();
            boolean usb = chkUSB.isSelected();

            Logica l = new Logica();
            double total = l.calcularPrecio(producto, tamano, bluetooth, wifi, usb);

            lblResultado.setText(String.format("Precio total: $%.2f", total));
        }

        if (e.getSource() == btnLimpiar) {
            comboProducto.setSelectedIndex(0);
            rbtPeq.setSelected(true);
            chkBluetooth.setSelected(false);
            chkWifi.setSelected(false);
            chkUSB.setSelected(false);
            lblResultado.setText("Precio total: $0.00");
        }
    }
}
