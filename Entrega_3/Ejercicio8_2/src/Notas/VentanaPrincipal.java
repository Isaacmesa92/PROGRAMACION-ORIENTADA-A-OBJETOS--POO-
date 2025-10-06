package Notas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame implements ActionListener {
    private Container contenedor;
    private JLabel nota1, nota2, nota3, nota4, nota5, lblPromedio, lblDesv, lblMayor, lblMenor;
    private JTextField campo1, campo2, campo3, campo4, campo5;
    private JButton btnCalcular, btnLimpiar;

    public VentanaPrincipal() {
        iniciar();
        setTitle("Notas");
        setSize(300, 410);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void iniciar() {
        contenedor = getContentPane();
        contenedor.setLayout(null);

        nota1 = new JLabel("Nota 1:");
        nota2 = new JLabel("Nota 2:");
        nota3 = new JLabel("Nota 3:");
        nota4 = new JLabel("Nota 4:");
        nota5 = new JLabel("Nota 5:");

        campo1 = new JTextField();
        campo2 = new JTextField();
        campo3 = new JTextField();
        campo4 = new JTextField();
        campo5 = new JTextField();

        // Posiciones (x, y, ancho, alto)
        nota1.setBounds(20, 20, 80, 23);     campo1.setBounds(110, 20, 150, 23);
        nota2.setBounds(20, 55, 80, 23);     campo2.setBounds(110, 55, 150, 23);
        nota3.setBounds(20, 90, 80, 23);     campo3.setBounds(110, 90, 150, 23);
        nota4.setBounds(20, 125, 80, 23);    campo4.setBounds(110, 125, 150, 23);
        nota5.setBounds(20, 160, 80, 23);    campo5.setBounds(110, 160, 150, 23);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(20, 200, 110, 27);
        btnCalcular.addActionListener(this);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(150, 200, 110, 27);
        btnLimpiar.addActionListener(this);

        lblPromedio = new JLabel("Promedio = ");
        lblDesv     = new JLabel("Desviación estándar = ");
        lblMayor    = new JLabel("Nota mayor = ");
        lblMenor    = new JLabel("Nota menor = ");

        lblPromedio.setBounds(20, 245, 240, 23);
        lblDesv.setBounds(20, 275, 240, 23);
        lblMayor.setBounds(20, 305, 240, 23);
        lblMenor.setBounds(20, 335, 240, 23);

        contenedor.add(nota1); contenedor.add(campo1);
        contenedor.add(nota2); contenedor.add(campo2);
        contenedor.add(nota3); contenedor.add(campo3);
        contenedor.add(nota4); contenedor.add(campo4);
        contenedor.add(nota5); contenedor.add(campo5);
        contenedor.add(btnCalcular); contenedor.add(btnLimpiar);
        contenedor.add(lblPromedio); contenedor.add(lblDesv);
        contenedor.add(lblMayor); contenedor.add(lblMenor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnCalcular) {
            try {
                // Validación: es obligatorio ingresar las cinco y deben ser numéricas
                String[] textos = {campo1.getText(), campo2.getText(), campo3.getText(),
                                   campo4.getText(), campo5.getText()};
                for (int i = 0; i < textos.length; i++) {
                    if (textos[i] == null || textos[i].trim().isEmpty()) {
                        throw new IllegalArgumentException("Falta la nota " + (i + 1));
                    }
                }

                Notas n = new Notas();
                n.listaNotas[0] = Double.parseDouble(textos[0]);
                n.listaNotas[1] = Double.parseDouble(textos[1]);
                n.listaNotas[2] = Double.parseDouble(textos[2]);
                n.listaNotas[3] = Double.parseDouble(textos[3]);
                n.listaNotas[4] = Double.parseDouble(textos[4]);

                lblPromedio.setText("Promedio = " + String.format("%.2f", n.calcularPromedio()));
                lblDesv.setText("Desviación estándar = " + String.format("%.2f", n.calcularDesviacion()));
                lblMayor.setText("Nota mayor = " + String.format("%.2f", n.calcularMayor()));
                lblMenor.setText("Nota menor = " + String.format("%.2f", n.calcularMenor()));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Todas las notas deben ser numéricas (usa punto decimal).",
                        "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Falta información",
                        JOptionPane.WARNING_MESSAGE);
            }
        }

        if (e.getSource() == btnLimpiar) {
            campo1.setText(""); campo2.setText(""); campo3.setText("");
            campo4.setText(""); campo5.setText("");
            lblPromedio.setText("Promedio = ");
            lblDesv.setText("Desviación estándar = ");
            lblMayor.setText("Nota mayor = ");
            lblMenor.setText("Nota menor = ");
        }
    }
}
