import java.util.ArrayList;
import java.util.Objects;

public class Agenda implements Comparable<Agenda> {

    ArrayList<String> contactos = new ArrayList<>();

    //Variable auxiliar
    private int contadorContactos = 0;

    public Agenda(ArrayList<String> contactos) {
        this.contactos = contactos;
    }


    public ArrayList<String> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<String> contactos) {
        this.contactos = contactos;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Agenda{");
        sb.append("contactos=").append(contactos);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return Objects.equals(contactos, agenda.contactos);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(contactos);
    }

    @Override
    public int compareTo(Agenda o) {
        return 0;
    }


    /*eliminaContacto: pide nombre del contacto a borrar. Recorre colección en busca del
contacto y lo elimina, informando de la no existencia del mismo dado el caso. */


}

