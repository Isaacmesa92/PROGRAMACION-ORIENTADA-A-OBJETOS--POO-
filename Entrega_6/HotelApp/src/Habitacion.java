package hotel;

/**
 * Modela una habitacion del hotel.
 */
public class Habitacion {
    private int numeroHabitacion;
    private boolean disponible;
    private double precioDia;
    private Huesped huesped;

    public Habitacion(int numeroHabitacion, boolean disponible, double precioDia) {
        this.numeroHabitacion = numeroHabitacion;
        this.disponible = disponible;
        this.precioDia = precioDia;
    }

    public int getNumeroHabitacion() { return numeroHabitacion; }
    public boolean isDisponible() { return disponible; }
    public double getPrecioDia() { return precioDia; }
    public Huesped getHuesped() { return huesped; }

    public void setHuesped(Huesped huesped) { this.huesped = huesped; }
    public void setDisponible(boolean disponible) { this.disponible = disponible; }
}
