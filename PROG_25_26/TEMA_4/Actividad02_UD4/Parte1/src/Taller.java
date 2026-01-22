import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Taller {

    Scanner sc = new Scanner(System.in);

    //el primero es la clave y el segundo el valor
    private HashMap <String, Coche> mapaTaller;

    public Taller() {
        this.mapaTaller = new HashMap<>();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Taller{");
        sb.append("sc=").append(sc);
        sb.append(", mapaTaller=").append(mapaTaller);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass() ) return false;
        Taller taller = (Taller) obj;
        return Objects.equals(mapaTaller, taller.mapaTaller);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(mapaTaller);
    }

    //MÉTODOS✅

/* anadeElemento: Incluye la petición de datos (color, marca y matrícula), la creación del
objeto de tipo Coche, valida la matrícula, comprueba que no hay ningún contacto ya en
la colección con la misma matrícula y añade la pareja matricula-Coche al mapa.*/

    public void anadeElemento() {
        System.out.print("Ingresa el color del coche: ");
        String color = sc.nextLine();
        System.out.print("Ingresa la marca del coche: ");
        String marca = sc.nextLine();
        //Validación para la matrícula
        String matricula = MiUtils.comprobarPatronRepetidamente("^[0-9]{4}\\s?[BCDFGHJKLMNPRSTVWXYZ]{3}$", "Introduzca la matrícula del coche: ");

        if (mapaTaller.containsKey(matricula)) {
            System.out.println("Coche ya existente");
        } else {
            Coche coche = new Coche(color, matricula);
            mapaTaller.put(matricula, coche);
            System.out.println("Coche añadido");
        }
    }

/*eliminaElemento: pide matrícula del coche a borrar y lo elimina, informando de la no
existencia del mismo dado el caso.  */

    //Lo primero creo un bucle para buscar el que quiero eliminar
    public void eliminaElemento() {
        System.out.println("Matrícula a eliminar: ");
        String m = sc.nextLine();

        mapaTaller.containsKey(m);

        if (mapaTaller.containsKey(m)) {
            mapaTaller.remove(m);
            System.out.println("Coche eliminado");
        }else{
            System.out.println("Coche no encontrado");
        }
    }

    /*visualizaMatriculas: Recorre el mapa mostrando el conjunto de matrículas almacenadas.
(Basado en keySet()) */
    public void visualizaMatriculas () {
        for(String clave : mapaTaller.keySet()){
            System.out.println(clave + ": " + mapaTaller.get(clave));
        }
    }

    /*visualizaCoches: Recorre el mapa mostrando color, marca de cada coche almacenado.
(Basado en values())*/
    public void visualizaCoches () {
        for(Coche valor : mapaTaller.values()){
            System.out.println("Valor: " + valor);
        }
    }

    /*visualizaTaller: Recorre el mapa mostrando color, marca y matricula de cada coche
almacenado. (Basado en entrySet().toString) */
    public void visualizaTaller () {
        for(Map.Entry<String, Coche> entry : mapaTaller.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }










}
