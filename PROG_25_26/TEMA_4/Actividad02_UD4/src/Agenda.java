import java.util.TreeSet;
import java.util.Objects;
import java.util.Scanner;

public class Agenda  {
    Scanner sc = new Scanner(System.in);
    //TreeSet<String> contactos = new TreeSet<>();

    private TreeSet<Contacto> contactos;

    //Variable auxiliar
    //private int contadorContactos = 0;


    public Agenda() {
        this.contactos = new TreeSet<>();
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

    /*eliminaContacto: pide nombre del contacto a borrar. Recorre colección en busca del
contacto y lo elimina, informando de la no existencia del mismo dado el caso. */

    //Creo un bucle for each para buscar el que quiero eliminar
        public void eliminarContacto() {
            System.out.println("Nombre a eliminar: ");
            String n = sc.nextLine();

            Contacto cAux = null;

            for (Contacto contacto : contactos) {
                if (contacto.getNombre().equals(n)) {
                    cAux = contacto;
                    break;
                }
            }
            boolean resultado = false;
            System.out.println("Contacto no encontrado ");

            if (cAux != null) {
                contactos.remove(cAux);
                System.out.println(n + " eliminado");
            }
        }
    //este sirve para eliminar conjuntos, linkedlist y arraylist

    public void buscarContacto() {
        System.out.println("Nombre a buscar: ");
        String buscar = sc.nextLine();

        Contacto cBuscar = null;

        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(buscar)) {
                cBuscar = contacto;
                break;
            }
        }
        if (cBuscar != null) {
            System.out.println("Contacto encontrado: ");
            System.out.println(cBuscar.toString());
        } else {
            System.out.println("Contacto no encontrado");
        }
    }

    public void visualizaAgenda() {
            if (contactos.size() <= 0) {
                System.out.println("Lista de contactos vacía");
            }else {
                for  (Contacto contacto : contactos) {
                    System.out.println(contacto.toString());
                }
            }
    }

    public void anadeContacto() {
        //Validación para nombre
        MiUtils.comprobarPatronRepetidamente("^[A-Z][a-zA-Z]*$", "Introduzca el nombre: ");
        //Validación para número de teléfono
        MiUtils.comprobarPatronRepetidamente("^[679][0-9]{8}$", "Introduzca el numero de teléfono: ");
        //Validación para el correo
        MiUtils.comprobarPatronRepetidamente("[a-z0-9._-]+@[a-z]+\\.[a-z]{2,4}", "Introduzca el correo: ");

        Contacto nuevo = new Contacto();


        if (contactos.add(nuevo)) {
            System.out.println("Contacto añadido");
        } else {
            System.out.println("Contacto ya existente");
        }
    }

    public void numeroContactos() {
            int total = contactos.size();
            System.out.println("La agenda de contactos actualmente tiene: " + total + "contactos");
    }

}

