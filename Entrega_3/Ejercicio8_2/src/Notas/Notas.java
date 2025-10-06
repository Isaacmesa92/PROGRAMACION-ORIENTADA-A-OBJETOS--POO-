package Notas;

public class Notas {
    double[] listaNotas;

    public Notas() {
        listaNotas = new double[5];
    }

    public double calcularPromedio() {
        double suma = 0.0;
        for (int i = 0; i < listaNotas.length; i++) { // ¡ojo: desde 0!
            suma += listaNotas[i];
        }
        return suma / listaNotas.length;
    }

    public double calcularDesviacion() {
        double prom = calcularPromedio();
        double suma = 0.0;
        for (int i = 0; i < listaNotas.length; i++) {
            double diff = listaNotas[i] - prom;
            suma += diff * diff;
        }
        return Math.sqrt(suma / listaNotas.length);
    }

    public double calcularMenor() {
        double menor = listaNotas[0];
        for (int i = 1; i < listaNotas.length; i++) {
            if (listaNotas[i] < menor) menor = listaNotas[i];
        }
        return menor;
    }

    public double calcularMayor() {
        double mayor = listaNotas[0];
        for (int i = 1; i < listaNotas.length; i++) {
            if (listaNotas[i] > mayor) mayor = listaNotas[i];
        }
        return mayor;
    }
}
