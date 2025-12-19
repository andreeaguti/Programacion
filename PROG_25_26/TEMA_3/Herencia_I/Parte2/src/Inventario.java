public class Inventario {

    String nombre;
    private Mascotas[] misMascotas;
    private int mascotasActuales;

    public Inventario(String nombre, int capacidad) {
        this.nombre = nombre;
        this.misMascotas = new Mascotas[capacidad];
        this.mascotasActuales = 0;
    }

    public String getNombre() {
        return nombre;
    }

    //MÉTODOS
    public boolean insertarMascota(Mascotas mascota) {
        boolean estado = false; // creo una variable e inicia su valor en false, si no se cumple la condicion para añadir
        //el metodo devuelve false
        if (mascotasActuales < this.misMascotas.length) { //aqui compruebo si todavia queda sitio en el array
            this.misMascotas[mascotasActuales] = mascota; //aqui guardo la mascota en la posiciom que indica el contador
            this.mascotasActuales++; //incrementa el contaodr, asegura que la proxima mascota que inserte vaya a la siguiente posicion
            estado = true; //como se ha insertado la mascota con exito devuelve un true
        } //si la condicion if no se cumplio (el array estaba lleno), el codigo salta directamente al final
        return estado; //devuelve el resultado final
    }

    public boolean eliminarMascota(Mascotas mascota) {
        boolean estado = false; // creo una variable e inicia su valor en false, si no se cumple la condicion para añadir
        //el metodo devuelve false
        int index = -1; //se crea una variable para guardar la posicion donde esta la mascota, se inicializa en -1, por
        //en java empiezan en 0; un -1 significa "no encontrado todavia"
        if(mascotasActuales > 0) { //comprueba si hay alguna mascota guardada, si es 0 no tiene sentido entrar a buscar
            for(int i = 0; i < this.mascotasActuales; i++) { //recorro todas las posiciones del array
                if(this.misMascotas[i].nombre == mascota.nombre) { //en cada vuelta, busca el nombre de la mascota que quieres eliminar
                    index = i; //si los nombre coinciden, guarda la posicion actual "i" en nuestra variable index
                    break; //una vez encontrada la mascota que queremos eliminar hacemos que pare
                }
            }

            if(index != -1) { //solo entra aquí si en el paso anterior hemos encontrado la mascota
                this.misMascotas[index] = this.misMascotas[mascotasActuales - 1]; //mueve la última mascota a la posición que ha quedado libre
                this.misMascotas[mascotasActuales - 1] = null; //ahora la última posición ha quedado vacia, la ponemos como null
                this.mascotasActuales--; //resto al contador la mascota que hemos eliminado
                estado = true; //confirmamos que la operación se realizó correctamente
            }
        }
        return estado; //el metodo termina devolviendo true (si se borró) o false (si no se encontro o el array estaba vacio)
    }

    public boolean vaciarInventario() {
        boolean estado = false; //se inicializa en falso, solo cambia a verdadero si hay algo que vaciar
        if(this.mascotasActuales > 0) { //comprueba que hay mascotas para eliminar
            this.misMascotas = new  Mascotas[10]; //aquí borra el array viejo, y hace uno nuevo
            this.mascotasActuales = 0; //como el nuevo array esta vacio, ponemos el contador a cero
            estado = true; //esto nos dice que se ha vaciado el inventario con exito
        }
        return estado; //devuelve el resultado de la operación
    }

    public String mostrarInfoMascota(int posicion) { //
        String mascota = "No hay mascotas que correspondan"; //Crea un mensaje de error por defecto. Si la posición no es valida
        //el metodo devolvera este mensaje en lugar de romper el programa
        if(posicion >= 0 && posicion < this.mascotasActuales) { //comprueba que no sea un numero negativo
            mascota = this.misMascotas[posicion].toString();
            //accede al objeto en esa celda del array
            //entra en el objeto MASCOTA
            //ejecuta el código que escribi dentro de public String toString()
        }
        return mascota; //devuelve el mensaje del principio si no se encontró nada
    }

    public String mostrarInfoTodasMascotas(){
        String texto = "";
        if(this.mascotasActuales > 0) { //verifica que haya mascotas, si el contador es 0, salta directamente al else
            for(Mascotas m : this.misMascotas){ //para cada objeto de tipo Mascotas (m) dentro del arrar this.misMascotas...
                if(m != null) { //esto evita que el programa lea un hueco vacio
                    texto += m.toString();
                }
            }
        }else{
            texto = "No hay mascotas en el inventario"; // si mascotasActuales era 0, manda este mensaje der error
        }
        return texto; //envia de vuelta el String con todos los datos
    }

    public String mostrarInfoBasicaMascotas(){ //metodo que devuelve un String con la informacion resumida de todos los animales
        String texto = ""; //variable donde se va a ir sumando la informacion de cada animal
        if(this.mascotasActuales > 0) { //si no hay mascotas en el contador, salta al final
            for(Mascotas mascota : this.misMascotas){ //recorremos el array
                if(mascota != null) { //evita errores si hay huecos vacios en el array
                    if(mascota instanceof Perro){
                        //instanceof: Esta es la parte mágica. Pregunta: "¿Este objeto genérico de tipo Mascota es, en
                        // realidad, un Perro?". Sirve para identificar la clase hija específica.
                        Perro perro = (Perro) mascota;
                        //Como ya sabemos que es un perro, "forzamos" a Java a tratar la variable genérica como un objeto
                        // de la clase Perro. Esto es necesario para poder usar métodos que solo existen en la clase Perro.
                        texto += perro.muestra();
                        //Llama al metodo .muestra() del perro y añade el resultado al texto acumulado.
                    }
                    else if(mascota instanceof Gato){
                        Gato gato = (Gato) mascota;
                        texto += gato.muestra();
                    }
                    else if(mascota instanceof Loro){
                        Loro loro = (Loro) mascota;
                        texto += loro.muestra();
                    }
                    else if(mascota instanceof Canario){
                        Canario canario = (Canario) mascota;
                        texto += canario.muestra();
                    }
                }
            }
        }else{ //si no hay ninguna mascota en el array manda este mensaje
            texto = "No hay mascotas en el inventario";
        }
        return texto; //devuelve el parrafo generado
    }

}
