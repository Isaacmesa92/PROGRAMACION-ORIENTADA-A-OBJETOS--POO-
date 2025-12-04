package Nomina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class VentanaPrincipal extends JFrame implements ActionListener {

    private ListaEmpleados empleados;

    private JMenuBar barraMenu;
    private JMenu menu;
    private JMenuItem itemAgregar, itemNomina, itemGuardar;

    public VentanaPrincipal() {
        empleados = new ListaEmpleados();
        inicio();
        setTitle("Nomina");
        setSize(320,380);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void inicio() {

        barraMenu = new JMenuBar();
        menu = new JMenu("Menu");

        itemAgregar = new JMenuItem("Agregar empleado");
        itemNomina = new JMenuItem("Calcular nomina");
        itemGuardar = new JMenuItem("Guardar archivo");

        menu.add(itemAgregar);
        menu.add(itemNomina);
        menu.add(new JSeparator());
        menu.add(itemGuardar);

        barraMenu.add(menu);
        setJMenuBar(barraMenu);

        itemAgregar.addActionListener(this);
        itemNomina.addActionListener(this);
        itemGuardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == itemAgregar) {
            new VentanaAgregarEmpleado(empleados).setVisible(true);
        }

        if (e.getSource() == itemNomina) {
            new VentanaNomina(empleados).setVisible(true);
        }

        if (e.getSource() == itemGuardar) {

            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {

                File carpeta = chooser.getSelectedFile();
                File archivo = new File(carpeta, "Nomina.txt");

                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write(empleados.convertirTexto());
                    bw.close();

                    JOptionPane.showMessageDialog(this,
                            "Archivo guardado en:\n" + archivo.getAbsolutePath());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this,
                            "Error al guardar archivo");
                }
            }
        }
    }
}
