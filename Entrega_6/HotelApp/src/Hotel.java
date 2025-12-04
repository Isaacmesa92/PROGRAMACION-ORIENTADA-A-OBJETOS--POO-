package hotel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Hotel que contiene 10 habitaciones.
 */
public class Hotel {
    public List<Habitacion> listaHabitaciones;

    public Hotel() {
        listaHabitaciones = new ArrayList<>();
        // primeras 5 a 120000, siguientes 5 a 160000
        for (int i = 1; i <= 5; i++) {
            listaHabitaciones.add(new Habitacion(i, true, 120000.0));
        }
        for (int i = 6; i <= 10; i++) {
            listaHabitaciones.add(new Habitacion(i, true, 160000.0));
        }
    }

    /**
     * Retorna la fecha de ingreso (formateada) de la habitacion numero
     */
    public String buscarFechaIngresoHabitacion(int numero) {
        for (Habitacion h : listaHabitaciones) {
            if (h.getNumeroHabitacion() == numero && h.getHuesped() != null && h.getHuesped().getFechaIngreso() != null) {
                Date fecha = h.getHuesped().getFechaIngreso();
                DateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                return formato.format(fecha);
            }
        }
        return "";
    }

    /**
     * Indica si la habitacion está ocupada (no disponible)
     */
    public boolean buscarHabitacionOcupada(int numero) {
        for (Habitacion h : listaHabitaciones) {
            if (h.getNumeroHabitacion() == numero) {
                return !h.isDisponible();
            }
        }
        return false;
    }

    /**
     * Devuelve la Habitacion por numero o null
     */
    public Habitacion getHabitacionPorNumero(int numero) {
        for (Habitacion h : listaHabitaciones) {
            if (h.getNumeroHabitacion() == numero) return h;
        }
        return null;
    }
}
