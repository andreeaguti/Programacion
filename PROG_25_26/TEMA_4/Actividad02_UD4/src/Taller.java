import java.util.HashMap;
import java.util.Collections;
import java.util.Objects;
import java.util.Map;

// HashMap<TipoClave, TipoValor> nombre array

public class Taller {
    // La clave es la matricula (String) y el valor es el objeto Coche
   private HashMap<String, Coche> coches;

   public Taller() {
       this.coches = new HashMap<>();
   }
//NO HAGO GETTER NI SETTER
//SI LA CLAVE ES UN STRING O INTEGER NO HAGO hashCode NI equals


    //eliminaElemento: pide matrícula del coche a borrar y lo elimina, informando de la no
    //existencia del mismo dado el caso.
    public void eliminaElemento (String matricula) {//"public" puedo llamar a este metodo desde otras clases
       //"void" significa que no devuelve ningun dato (no hay return)
       if (coches.containsKey(matricula)) {
       //coches.constainsKey()(matricula)
       //Lo que hace es mirar dentro del mapa y preguntar: "¿Existe alguna clave que sea exactamente igual a esta matrícula?"
           coches.remove(matricula.toUpperCase());
           //si lo anterior coincide entonces se borra ese coche
            System.out.println("Coche con matricula: " + matricula + " eliminado");
       }
    }

    







}
