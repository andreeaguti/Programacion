import java.time.LocalDate;

//HACEMOS LA ENCAPSULACION
public class VideoDaw {
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private Pelicula [] peliculasRegistradas;
    private Cliente [] clientesRegistrados;

    private int contadorClientesRegistrados;
    private int contadorPeliculasRegistradas;

//CREAMOS LOS CONSTRUCTORES
public VideoDaw (String cif, String direccion){
    this.cif = cif;
    this.direccion = direccion;
    this.fechaAlta = LocalDate.now();
    this.peliculasRegistradas = new Pelicula [10];
    this.clientesRegistrados = new Cliente [20];
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


//METODOS ✅

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

    //METODO PARA REGISTRAR CLIENTES
    public void agregarCliente (Cliente cliente) {
        if (this.existeCliente(cliente)) {
            System.out.println("El cliente ya existe");
        }
        if (this.contadorClientesRegistrados < this.clientesRegistrados.length) {
            this.clientesRegistrados[this.contadorClientesRegistrados] = cliente;
        }else if (this.contadorClientesRegistrados >= this.clientesRegistrados.length) {
            this.ampliarDimensionClientes();
            this.clientesRegistrados[this.contadorClientesRegistrados] = cliente;
        }
        this.contadorClientesRegistrados++;
        System.out.println("Cliente " + cliente.getNombre() + " registrado");
    }

    private void ampliarDimensionClientes(){
        Cliente[] clientesRegistradosAux = new Cliente[this.clientesRegistrados.length + 10];
        for(int i = 0; i < this.clientesRegistrados.length; i++){
            clientesRegistradosAux[i] = this.clientesRegistrados[i];
        }
        this.clientesRegistrados = clientesRegistradosAux;
    }

    public boolean existeCliente (Cliente cliente){
        for (int i = 0; i < this.contadorClientesRegistrados; i++){
            if (this.clientesRegistrados[i].getDni().equals(cliente.getDni())){
                return true;
            }
        }
        return false;
    }
    //METODO PARA REGISTRAR PELICULAS
    public void agregarPelicula (Pelicula pelicula) {
        if (this.existePelicula(pelicula)) {
            System.out.println("La pelicula ya está registrada. ");
        }
        if (this.contadorPeliculasRegistradas < this.peliculasRegistradas.length) {
            this.peliculasRegistradas[this.contadorPeliculasRegistradas] = pelicula;
        }else if (this.contadorPeliculasRegistradas >= this.peliculasRegistradas.length) {
            this.ampliarDimensionPeliculas();
            this.peliculasRegistradas[this.contadorPeliculasRegistradas] = pelicula;
        }
        this.contadorPeliculasRegistradas++;
        System.out.println("Pelicula " + pelicula.getTitulo() + " registrada");
    }
    private void ampliarDimensionPeliculas(){
        Pelicula[] peliculasRegistradasAux = new Pelicula[this.peliculasRegistradas.length + 10];
        for(int i = 0; i < this.peliculasRegistradas.length; i++){
            peliculasRegistradasAux[i] = this.peliculasRegistradas[i];
        }
        this.peliculasRegistradas = peliculasRegistradasAux;
    }
    public boolean existePelicula (Pelicula pelicula) {
        for (int i = 0; i < this.contadorPeliculasRegistradas; i++){
            if (this.peliculasRegistradas[i].getCodigo().equals(pelicula.getCodigo())){
                return true;
            }
        }
        return false;
    }

//METODO PARA VER LOS CLIENTES REGISTRADOS
public String mostrarClientesRegistrados(){
    String mostrarClientesRegistrados = "";
    mostrarClientesRegistrados += "Los clientes registrados son:" + "\n";

    if (this.contadorClientesRegistrados == 0) {
        System.out.println("No hay clientes registrados");
    }
    for (int i=0; i<this.contadorClientesRegistrados; i++) {
        mostrarClientesRegistrados += "Cliente" + (i + 1) + "\n";
        mostrarClientesRegistrados += this.clientesRegistrados[i].mostrarInfoCliente();
    }
    return mostrarClientesRegistrados;
}

//METODO PARA COMPROBAR QUE ESA PELICULA NO ESTÉ ALQUILADA
    public boolean peliculaAlquilada (Pelicula pelicula) {
    boolean retorno = false; //de primeras no está alquilada
    if (pelicula == null) {
        retorno = true;
    } else if (pelicula.isAlquilada()) {
        retorno = true;
    }
    return retorno;
    }

//METODO PARA ALQUILAR UNA PELICULA
public void alquilarPelicula (Pelicula pelicula, Cliente cliente) {
    if (peliculaAlquilada(pelicula)) {
        System.out.println("No se puede alquilar");
    }else {
        pelicula.setAlquilada(true);
        cliente.agregarPelicula(pelicula);
        System.out.println("Pelicula alquilada!!");
    }
}
//METODO PARA DAR DE BAJA A UN CLIENTE
public boolean darBajaCliente (String dniBaja) {
    //recorro el array buscando el dni
    for (int i = 0; i < this.contadorClientesRegistrados; i++) {
        if (this.clientesRegistrados[i].getDni().equals(dniBaja)) {
            this.clientesRegistrados[i].setFechaBaja(LocalDate.now());
        //eliminamos esa posición del array
            for (int j = i; j < this.contadorClientesRegistrados -1; j++) {
                this.clientesRegistrados[j] = this.clientesRegistrados[j +1];
            }
            this.clientesRegistrados[this.contadorClientesRegistrados -1] = null;
            this.contadorClientesRegistrados--; //le restamos al contador el cliente eliminado
            System.out.println("Cliente con DNI:" +  dniBaja + "dado de baja");
            return true;
        }
    }
    System.out.println("Cliente no encontrado");
    return false;
}
//METODO PARA DEVOLVER UNA PELÍCULA






}