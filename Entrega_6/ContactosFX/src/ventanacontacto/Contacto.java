package ventanacontacto;

import java.time.LocalDate;

public class Contacto {
    String nombres;
    String apellidos;
    LocalDate fechaNacimiento;
    String direccion;
    String telefono;
    String correo;

    public Contacto(String nombres, String apellidos, LocalDate fechaNacimiento,
                    String direccion, String telefono, String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
}
