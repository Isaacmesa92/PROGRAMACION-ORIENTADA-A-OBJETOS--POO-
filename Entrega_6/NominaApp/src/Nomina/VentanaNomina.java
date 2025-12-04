package Nomina;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VentanaNomina extends JFrame {

    private ListaEmpleados lista;

    public VentanaNomina(ListaEmpleados lista) {
        this.lista = lista;
        inicio();
        setTitle("Nómina");
        setSize(380,260);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void inicio() {

        setLayout(null);

        JLabel titulo = new JLabel("Lista de empleados:");
        titulo.setBounds(20,10,200,25);
        add(titulo);

        String[][] datos = lista.obtenerMatriz();
        String[] columnas = {"Nombre","Apellidos","Sueldo"};

        JTable tabla = new JTable(new DefaultTableModel(datos,columnas));
        tabla.setBounds(20,45,330,120);
        add(tabla);

        JLabel total = new JLabel("Total nómina: $" +
                String.format("%.2f", lista.totalNomina));
        total.setBounds(20,180,300,25);
        add(total);
    }
}
