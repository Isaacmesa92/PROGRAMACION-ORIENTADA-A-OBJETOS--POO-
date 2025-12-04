package hotel;

import java.util.Date;

/**
 * Modela un huésped.
 */
public class Huesped {
    private String nombres;
    private String apellidos;
    private int documentoIdentidad;
    private Date fechaIngreso;
    private Date fechaSalida;

    public Huesped(String nombres, String apellidos, int documentoIdentidad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.documentoIdentidad = documentoIdentidad;
    }

    public void setFechaIngreso(Date fecha) { this.fechaIngreso = fecha; }
    public void setFechaSalida(Date fecha) { this.fechaSalida = fecha; }

    public Date getFechaIngreso() { return fechaIngreso; }
    public Date getFechaSalida() { return fechaSalida; }

    /**
     * Calcula los días de alojamiento entre ingreso y salida.
     */
    public int obtenerDiasAlojamiento() {
        if (fechaIngreso == null || fechaSalida == null) return 0;
        long diffMs = fechaSalida.getTime() - fechaIngreso.getTime();
        return (int) (diffMs / (1000L * 60 * 60 * 24));
    }

    // getters básicos (si los necesitas)
    public String getNombres() { return nombres; }
    public String getApellidos() { return apellidos; }
    public int getDocumentoIdentidad() { return documentoIdentidad; }
}
