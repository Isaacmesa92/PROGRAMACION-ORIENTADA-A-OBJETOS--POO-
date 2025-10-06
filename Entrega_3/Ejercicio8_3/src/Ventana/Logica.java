package Ventana;

public class Logica {
    public double calcularPrecio(String producto, String tamano, boolean bluetooth, boolean wifi, boolean usb) {
        double precio = 0;

        // Precio base según producto
        switch (producto) {
            case "Televisor": precio = 800; break;
            case "Radio": precio = 200; break;
            case "DVD": precio = 400; break;
        }

        // Ajuste por tamaño/potencia
        switch (tamano) {
            case "Pequeño": precio *= 1.0; break;
            case "Mediano": precio *= 1.2; break;
            case "Grande":  precio *= 1.4; break;
        }

        // Extras
        if (bluetooth) precio += 50;
        if (wifi) precio += 80;
        if (usb) precio += 30;

        return precio;
    }
}
