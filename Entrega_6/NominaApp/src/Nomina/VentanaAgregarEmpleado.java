package Nomina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaAgregarEmpleado extends JFrame implements ActionListener {

    private ListaEmpleados lista;

    private JTextField campoNombre, campoApellidos, campoSalario,
            campoIngresos, campoSalud, campoPension;

    private JComboBox<String> campoCargo;
    private JRadioButton masculino, femenino;
    private JSpinner campoDias;
    private ButtonGroup grupoGenero;

    private JButton agregar, limpiar;

    public VentanaAgregarEmpleado(ListaEmpleados lista) {
        this.lista = lista;
        inicio();
        setTitle("Agregar empleado");
        setSize(300,400);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public void inicio() {

        setLayout(null);

        JLabel nombre = new JLabel("Nombre:");
        nombre.setBounds(20,20,120,25);
        campoNombre = new JTextField();
        campoNombre.setBounds(140,20,120,25);

        JLabel apellidos = new JLabel("Apellidos:");
        apellidos.setBounds(20,55,120,25);
        campoApellidos = new JTextField();
        campoApellidos.setBounds(140,55,120,25);

        JLabel cargo = new JLabel("Cargo:");
        cargo.setBounds(20,90,120,25);
        campoCargo = new JComboBox<>();
        campoCargo.addItem("Directivo");
        campoCargo.addItem("Estrategico");
        campoCargo.addItem("Operativo");
        campoCargo.setBounds(140,90,120,25);

        JLabel genero = new JLabel("Genero:");
        genero.setBounds(20,125,120,25);
        masculino = new JRadioButton("Masculino", true);
        femenino = new JRadioButton("Femenino");
        masculino.setBounds(140,125,100,25);
        femenino.setBounds(140,150,100,25);

        grupoGenero = new ButtonGroup();
        grupoGenero.add(masculino);
        grupoGenero.add(femenino);

        JLabel salario = new JLabel("Salario por día:");
        salario.setBounds(20,185,120,25);
        campoSalario = new JTextField();
        campoSalario.setBounds(140,185,120,25);

        JLabel dias = new JLabel("Días trabajados:");
        dias.setBounds(20,220,120,25);
        campoDias = new JSpinner(new SpinnerNumberModel(30,1,31,1));
        campoDias.setBounds(140,220,60,25);

        JLabel ingresos = new JLabel("Otros ingresos:");
        ingresos.setBounds(20,255,120,25);
        campoIngresos = new JTextField();
        campoIngresos.setBounds(140,255,120,25);

        JLabel salud = new JLabel("Pagos salud:");
        salud.setBounds(20,290,120,25);
        campoSalud = new JTextField();
        campoSalud.setBounds(140,290,120,25);

        JLabel pension = new JLabel("Pensiones:");
        pension.setBounds(20,325,120,25);
        campoPension = new JTextField();
        campoPension.setBounds(140,325,120,25);

        agregar = new JButton("Agregar");
        agregar.setBounds(20,355,100,30);
        agregar.addActionListener(this);

        limpiar = new JButton("Limpiar");
        limpiar.setBounds(160,355,100,30);
        limpiar.addActionListener(this);

        add(nombre); add(campoNombre);
        add(apellidos); add(campoApellidos);
        add(cargo); add(campoCargo);
        add(genero); add(masculino); add(femenino);
        add(salario); add(campoSalario);
        add(dias); add(campoDias);
        add(ingresos); add(campoIngresos);
        add(salud); add(campoSalud);
        add(pension); add(campoPension);
        add(agregar); add(limpiar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == agregar) {

            try {
                String nombre = campoNombre.getText();
                String apellidos = campoApellidos.getText();

                TipoCargo cargo = switch ((String) campoCargo.getSelectedItem()) {
                    case "Directivo" -> TipoCargo.DIRECTIVO;
                    case "Estrategico" -> TipoCargo.ESTRATEGICO;
                    default -> TipoCargo.OPERATIVO;
                };

                TipoGenero genero = masculino.isSelected() ?
                        TipoGenero.MASCULINO : TipoGenero.FEMENINO;

                double salario = Double.parseDouble(campoSalario.getText());
                int dias = (int) campoDias.getValue();
                double ingresos = Double.parseDouble(campoIngresos.getText());
                double salud = Double.parseDouble(campoSalud.getText());
                double pension = Double.parseDouble(campoPension.getText());

                Empleado emp = new Empleado(
                        nombre, apellidos, cargo, genero,
                        salario, dias, ingresos, salud, pension
                );

                lista.agregarEmpleado(emp);

                JOptionPane.showMessageDialog(this, "Empleado agregado correctamente");
                limpiarCampos();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: revise los datos",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == limpiar) {
            limpiarCampos();
        }
    }

    public void limpiarCampos() {
        campoNombre.setText("");
        campoApellidos.setText("");
        campoSalario.setText("");
        campoIngresos.setText("");
        campoSalud.setText("");
        campoPension.setText("");
    }
}
