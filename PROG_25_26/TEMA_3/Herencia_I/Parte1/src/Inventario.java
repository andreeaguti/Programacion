public class Inventario {
    String nombre;
    private Astros[] listaAstros;
    private int astrosActuales;

    public Inventario(String nombre, int capacidad) {
        this.nombre=nombre;
        this.listaAstros = new Astros[capacidad];
        this.astrosActuales = 0;
    }
    public String getNombre() {
        return nombre;

    }

    //metodos

    public boolean insertarAstro (Astros astro){
    boolean estado=false;
    if (astrosActuales < listaAstros.length){
        this.listaAstros[astrosActuales] = astro;
        this.astrosActuales++;
        estado=true;
    }
    return estado;
    }

    public String mostrarInfoAstro(int posicion){
        String astro = "No hay astro que corresponda";
        if (posicion >= 0 && posicion < this.astrosActuales){
            astro = this.listaAstros[posicion].toString();
        }
        return astro;
    }

    public String mostrarInfoTodosAstros(){
        String texto = "";
        if(this.astrosActuales > 0) { //verifica que haya mascotas, si el contador es 0, salta directamente al else
            for(Astros a : this.listaAstros){ //para cada objeto de tipo Mascotas (m) dentro del arrar this.misMascotas...
                if(a != null) { //esto evita que el programa lea un hueco vacio
                    texto += a.toString();
                }
            }
        }else{
            texto = "No hay astros en el inventario"; // si mascotasActuales era 0, manda este mensaje der error
        }
        return texto; //envia de vuelta el String con todos los datos
    }
}

