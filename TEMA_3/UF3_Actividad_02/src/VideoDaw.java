import java.time.LocalDate;

//HACEMOS LA ENCAPSULACION
public class VideoDaw {
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private Pelicula [] peliculasRegistradas;
    private Cliente [] clientesRegistrados;

//CREAMOS LOS CONSTRUCTORES
public VideoDaw (String cif, String direccion){
    this.cif = cif;
    this.direccion = direccion;
    this.fechaAlta = LocalDate.now();
    this.peliculasRegistradas = new Pelicula [10];
    this.clientesRegistrados = new Cliente [100];
    }

//DEFINO GETTERS
    public String getCif() {
        return cif;
    }
    public String getDireccion() {
        return direccion;
    }
    public LocalDate getFechaAlta() {
        return fechaAlta;
    }
    public Pelicula [] getPeliculasRegistradas() {
        return this.peliculasRegistradas;
    }
    public Cliente [] getClientesRegistrados() {
        return this.clientesRegistrados;
    }

//DEFINO SETTERS
    //Voy a crear setter de direccion y de los 2 arrays
public void setDireccion (String direccion) {
     if (direccion == null || direccion.trim().isEmpty()) {
         System.out.println("La direccion no puede estar vacia");
     } else {
         this.direccion = direccion;
     }
 }
public void setPeliculasRegistradas (Pelicula [] peliculasRegistradas){
    this.peliculasRegistradas = peliculasRegistradas;
    }
public void setClientesRegistrados (Cliente [] clientesRegistrados){
        this.clientesRegistrados = clientesRegistrados;
    }
//CREO METODO PARA MOSTRAR LA INFORMACION DEL VIDEOCLUB
public String mostrarInfoVideoClub() {
    String mostrarInfoVideoClub = "";
    mostrarInfoVideoClub = "CIF: " + this.getCif() + "\n";
    mostrarInfoVideoClub += "Direccion: " + this.getDireccion() + "\n";
    mostrarInfoVideoClub += "Fecha de alta: " + this.getFechaAlta() + "\n";
    mostrarInfoVideoClub += "Peliculas registradas: " + this.getPeliculasRegistradas() + "\n";
    mostrarInfoVideoClub += "Clientes registrados: " + this.getClientesRegistrados() + "\n";
    return mostrarInfoVideoClub;
}
//METODO PARA VER LAS PELICULAS REGISTRADAS
public String mostrarPeliculasRegistradas(){
    String mostrarPeliculasRegistradas = "";
    int contador = 0;
    mostrarPeliculasRegistradas += "Las peliculas registradas son:" + "\n";
    for (Pelicula pelicula : this.peliculasRegistradas) {
        if (pelicula == null || contador == 0) {
            System.out.println("Por el momento no hay peliculas registradas");
        }else {
            contador++;
            mostrarPeliculasRegistradas += pelicula.mostrarInfoPelicula();
        }
    }
    return mostrarPeliculasRegistradas;
    }
//METODO PARA VER LOS CLIENTES REGISTRADOS
public String mostrarClientesRegistrados(){
    String mostrarClientesRegistrados = "";
    int contador = 0;
    mostrarClientesRegistrados += "Los clientes registrados son:" + "\n";
    for (Cliente cliente : this.clientesRegistrados) {
        if (cliente == null || contador == 0) {
            System.out.println("Por el momento no hay clientes registrados");
        }else {
            contador++;
            mostrarClientesRegistrados += cliente.mostrarInfoCliente();
        }
    }
    return mostrarClientesRegistrados;
}
//METODO PARA ALQUILAR UNA PELICULA, COMPROBAR QUE ESA PELICULA NO ESTÉ YA ALQUILADA
    public String alquilarPelicula () {
    String alquilarPelicula = "";
    int contador = 0;
    if (is)
    }

}
