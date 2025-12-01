import java.time.LocalDate;

public class Cliente {

    //HACEMOS LA ENCAPSULACION

    private final String dni;
    private String nombre;
    private String numSocio;
    private String direccion;
    private LocalDate fechaNacimiento;
    private LocalDate fechaBaja;
    private Pelicula[] peliculasAlquiladas;

    private int contadorPeliculasAlquiladas;


    //CREAMOS LOS CONSTRUCTORES
    public Cliente(String dni, String nombre, String numSocio, String direccion, LocalDate fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.numSocio = numSocio;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaBaja = null;
        this.peliculasAlquiladas = new Pelicula[10];
    }

    //DEFINO GETTERS
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumSocio() {
        return numSocio;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public LocalDate getFechaBaja() {
        return fechaBaja;
    }

    public Pelicula[] getPeliculasAlquiladas() {
        return this.peliculasAlquiladas;
    }

    //DEFINO SETTERS
    public void setnumSocio(String numSocio) {
        this.numSocio = numSocio;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaBaja(LocalDate fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public void setPeliculasAlquiladas(Pelicula[] peliculasAlquiladas) {
        this.peliculasAlquiladas = peliculasAlquiladas;
    }

//METODOS ✅

    //METODO PARA MOSTRAR INFORMACIÓN DEL CLIENTE
    public String mostrarInfoCliente() {
        String mostrarInfoCliente = "";
        mostrarInfoCliente = "DNI: " + this.getDni() + "\n";
        mostrarInfoCliente += "Nombre: " + this.getNombre() + "\n";
        mostrarInfoCliente += "Numero de socio: " + this.getNumSocio() + "\n";
        mostrarInfoCliente += "Dirección: " + this.getDireccion() + "\n";
        mostrarInfoCliente += "Fecha de nacimiento: " + this.getFechaNacimiento() + "\n";
        mostrarInfoCliente += "Fecha de baja: " + this.getFechaBaja() + "\n";
        return mostrarInfoCliente;
    }


    //METODO PARA MOSTRAR ULTIMAS PELICULAS ALQUILADAS
    public String mostrarPeliculasAlquiladas() {
        String mostrarPeliculasAlquiladas = "";
        int contador = 0;
        mostrarPeliculasAlquiladas += "Peliculas alquiladas de : " + this.getNombre() + "\n";
        for (Pelicula pelicula : this.peliculasAlquiladas) { //recorro el array
            if (pelicula != null) {
                contador++;
                mostrarPeliculasAlquiladas += pelicula.mostrarInfoPelicula();
            }
        }
        if(contador == 0){
            mostrarPeliculasAlquiladas += "El cliente no tiene ninguna pelicula alquilada";
        }
        return mostrarPeliculasAlquiladas;
    }


//METODO PARA AGREGAR PELICULAS ALQUILADAS

public void agregarPelicula (Pelicula pelicula) {
        if (this.contadorPeliculasAlquiladas < this.peliculasAlquiladas.length ) {
            this.peliculasAlquiladas [this.contadorPeliculasAlquiladas] = pelicula;
        }else if (this.contadorPeliculasAlquiladas >= this.peliculasAlquiladas.length) {
            this.ampliarDimensionPeliculas();
            this.peliculasAlquiladas[this.contadorPeliculasAlquiladas] = pelicula;
        }
    this.contadorPeliculasAlquiladas++;
}
private void ampliarDimensionPeliculas(){
        Pelicula[] peliculasAlquiladasAux = new Pelicula[this.peliculasAlquiladas.length + 10];
        for(int i = 0; i < this.peliculasAlquiladas.length; i++){
            peliculasAlquiladasAux[i] = this.peliculasAlquiladas[i];
        }
        this.peliculasAlquiladas = peliculasAlquiladasAux;
    }

//METODO PARA ELIMINAR PELICULA ALQUILADA
public boolean eliminarPelicula (String peliculaEliminada) {
        for (int i = 0; i < this.contadorPeliculasAlquiladas; i++) { //recorro array buscando la pelicula que quiero eliminar
            if (this.peliculasAlquiladas[i].equals(peliculaEliminada)) {
                this.peliculasAlquiladas[i].setFechaBaja(LocalDate.now());
                //eliminamos esa posicion en el array
                for (int j = i; j < this.contadorPeliculasAlquiladas -1; j++) {
                    this.peliculasAlquiladas[j] = this.peliculasAlquiladas[j +1];
                }
                this.peliculasAlquiladas[this.contadorPeliculasAlquiladas -1] =null;
                this.contadorPeliculasAlquiladas--;
                System.out.println("Pelicula devuelta con exito");
                return true;
            }
        }
        return false;
}
}


