package hotel;

/**
 * Punto de entrada.
 */
public class Principal {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        VentanaPrincipal ventana = new VentanaPrincipal(hotel);
        ventana.setVisible(true);
    }
}
