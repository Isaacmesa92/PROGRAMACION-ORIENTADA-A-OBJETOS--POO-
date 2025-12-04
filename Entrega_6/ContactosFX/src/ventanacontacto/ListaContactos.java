package ventanacontacto;

import java.util.Vector;

public class ListaContactos {
    Vector<Contacto> lista;

    public ListaContactos() {
        lista = new Vector<>();
    }

    public void agregarContacto(Contacto contacto) {
        lista.add(contacto);
    }
}
