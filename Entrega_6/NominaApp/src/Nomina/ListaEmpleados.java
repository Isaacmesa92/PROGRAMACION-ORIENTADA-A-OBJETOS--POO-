package Nomina;

import java.util.Vector;

public class ListaEmpleados {

    public Vector<Empleado> lista;
    public double totalNomina = 0;

    public ListaEmpleados() {
        lista = new Vector<>();
    }

    public void agregarEmpleado(Empleado e) {
        lista.add(e);
    }

    public double calcularTotalNomina() {
        totalNomina = 0;
        for (Empleado e : lista) {
            totalNomina += e.calcularNomina();
        }
        return totalNomina;
    }

    public String[][] obtenerMatriz() {
        totalNomina = 0;

        String[][] datos = new String[lista.size()][3];

        for (int i = 0; i < lista.size(); i++) {
            Empleado e = lista.get(i);

            datos[i][0] = e.getNombre();
            datos[i][1] = e.getApellidos();
            datos[i][2] = String.format("%.2f", e.calcularNomina());

            totalNomina += e.calcularNomina();
        }

        return datos;
    }

    public String convertirTexto() {
        String texto = "";

        for (Empleado e : lista) {
            texto += "Nombre = " + e.getNombre() + "\n" +
                    "Apellidos = " + e.getApellidos() + "\n" +
                    "Cargo = " + e.getCargo() + "\n" +
                    "Genero = " + e.getGenero() + "\n" +
                    "Salario = " + e.getSalarioDia() + "\n" +
                    "Dias trabajados = " + e.getDiasTrabajados() + "\n" +
                    "Otros ingresos = " + e.getOtrosIngresos() + "\n" +
                    "Pagos salud = " + e.getPagosSalud() + "\n" +
                    "Aporte pensiones = " + e.getAportePensiones() + "\n" +
                    "----------------------------\n";
        }

        texto += "TOTAL NOMINA = $" + String.format("%.2f", calcularTotalNomina());

        return texto;
    }
}
