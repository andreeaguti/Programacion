
public class Agenda {
    private Contacto[] contactos;
    private int contadorContactos = 0;

    public Agenda (int tamano) {
        this.contactos = new Contacto[tamano];
    }

    // void listarContactos(): Muestra por pantalla toda la agenda.
    public void listarContactos()
    {
      for (int i = 0; i < contactos.length; i++) {
          if(this.contactos[i] != null)
          System.out.println("Contacto en posicion " + i + ":" + this.contactos[i].getNombre()+ " - " +
                  this.contactos[i].getTelefono());
      }
    }

    //metodo: boolean añadirContacto(Contacto c): Añade un contacto a la agenda e indica si se ha
    //eliminado. No se pueden meter contactos que existan, es decir, no podemos duplicar
    //nombres (aunque tengan distinto teléfono).
    public Contacto buscarContactoPorNombre(String nombre) {
        for (int i =0; i < contactos.length; i++){
            Contacto c = this.contactos[i];
            if (c.getNombre().equals(nombre)){
                return c;
            }
        }
        return null; //si no existe
    }

    public boolean existeContacto(Contacto contacto) {
        return buscarContactoPorNombre(contacto.getNombre())!= null;
    }

    public void anadirContacto(Contacto contacto) {
        if (this.existeContacto(contacto.getNombre())) {
            System.out.println("El contacto ya existe,s prueba con otro nombre.");
            return false;
        }
        this.contactos [this.contadorContactos++] = contacto;
    }

    //metodo: boolean eliminarContacto(String nombre): elimina el contacto de la agenda.
    //Indica si se ha podido eliminar.
    public boolean eliminarContacto(String nombre) {
        //recorro el array buscando el nombre
        for (int i = 0; i < this.contadorContactos; i++) {
            Contacto t = this.contactos[i];
            if (t.getNombre().equals(nombre)) {
                for (int j = 0; j < this.contadorContactos -1; j++) {
                    this.contactos[j] = this.contactos[j+1];
                    this.contactos[j] = this.contactos[j+1];
                }
                this.contactos[this.contadorContactos -1] = null;
                this.contadorContactos--;
                System.out.println("El contacto se elimino correctamente.");
                return true;
            }
        }
        System.out.println("El contacto con nombre " + nombre + " no existe.");
        return false;
    }
    // int buscaContacto(String nombre): busca un contacto por su nombre y devuelve
    // su posición en la agenda
    public Contacto buscarContactoNombre (String nombre) {
        for (int i = 0; i < this.contadorContactos; i++){
            Contacto t = this.contactos[i];
            if (t.getNombre().equals(nombre)){
                return t;
            }
        }
        return null ;
    }

}

