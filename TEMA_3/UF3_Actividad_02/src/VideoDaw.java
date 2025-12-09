import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;  //PARA EPOCH

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
    //METODO PARA BUSCAR POR DNI
        public Cliente buscarClientePorDni(String dni) {
            for (int i = 0; i < this.contadorClientesRegistrados; i++) {
                if (this.clientesRegistrados[i].getDni().equals(dni)) {
                    return this.clientesRegistrados[i];
            }
        }
        return null;
    }
    //METODO PARA BUSCAR PELICULA POR CODIGO

    public Pelicula buscarPeliculaPorCodigo(String codigo) {
        for (int i = 0; i < this.contadorPeliculasRegistradas; i++) {
            if (this.peliculasRegistradas[i].getCodigo().equals(codigo)) {
                return this.peliculasRegistradas[i];
            }
        }
        return null;
    }
    //METODO PARA COMPROBAR SI EXISTE CLIENTE
    public boolean existeCliente (Cliente cliente){
        return buscarClientePorDni(cliente.getDni()) != null;
    }
    //METODO PARA COMPROBAR SI EXISTE PELICULA
    public boolean existePelicula (Pelicula pelicula) {
        return buscarPeliculaPorCodigo(pelicula.getCodigo()) != null;
    }
    //METODO PARA COMPROBAR QUE ESA PELICULA NO ESTÉ ALQUILADA
    public boolean peliculaAlquilada (Pelicula pelicula) {
        if (pelicula == null) {
            return true; //no se puede alquilar si la pelicula no existe
        }
        return pelicula.isAlquilada();
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
    if (this.contadorPeliculasRegistradas == 0) {
        System.out.println("De momento no hay peliculas registradas");
    }
    String mostrarPeliculasRegistradas = "Las peliculas registradas son : \n";
    for (int i = 0; i < this.contadorPeliculasRegistradas; i++) {
        mostrarPeliculasRegistradas += "Pelicula" + (i+1) + "\n";
        mostrarPeliculasRegistradas += this.peliculasRegistradas[i].mostrarInfoPelicula();
    }
    return mostrarPeliculasRegistradas;
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

    //METODO PARA REGISTRAR CLIENTES
    private void ampliarDimensionClientes(){
        Cliente[] clientesRegistradosAux = new Cliente[this.clientesRegistrados.length + 10];
        for(int i = 0; i < this.clientesRegistrados.length; i++){
            clientesRegistradosAux[i] = this.clientesRegistrados[i];
        }
        this.clientesRegistrados = clientesRegistradosAux;
    }

    public void agregarCliente (Cliente cliente) {
        if (this.existeCliente(cliente)) {
            System.out.println("El cliente ya existe");
            return;
        }
        if (this.contadorClientesRegistrados == this.clientesRegistrados.length) {
            this.ampliarDimensionClientes();
        }

        this.clientesRegistrados[this.contadorClientesRegistrados] = cliente;
        this.contadorClientesRegistrados++;

        System.out.println("Cliente " + cliente.getNombre() + " registrado");
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


//METODO PARA ALQUILAR UNA PELICULA
public void alquilarPelicula (Pelicula pelicula, Cliente cliente) {
    if (peliculaAlquilada(pelicula)) {
        System.out.println("No se puede alquilar");
    }else {
        pelicula.setAlquilada(true);
        pelicula.setFechaAlquiler(LocalDateTime.now());
        cliente.agregarPelicula(pelicula);
        System.out.println("Pelicula alquilada!");
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

//METODO PARA DAR DE BAJA PELICULA
    public boolean darBajaPelicula (String peliculaBaja) {
    //recorro array buscando la pelicula
        for (int i = 0; i < this.contadorPeliculasRegistradas; i++) {
            if (this.peliculasRegistradas[i].getCodigo().equals(peliculaBaja)) {
                this.peliculasRegistradas[i].setFechaBaja(LocalDate.now());
                //elimino la posicion del array
                for (int j = i; j < this.contadorPeliculasRegistradas-1; j++) {
                    this.clientesRegistrados[j] = this.clientesRegistrados[j+1];
                }
                this.peliculasRegistradas[this.contadorPeliculasRegistradas-1] = null;
                this.contadorPeliculasRegistradas--; //le restamos al contador el cliente eliminado
                return true;
            }
        }
        return false;
    }

//METODO PARA DEVOLVER UNA PELÍCULA
    public void devolverPelicula (Pelicula pelicula, Cliente cliente) {

    final long SEGUNDOS_MAX = 172800;

        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaAlquiler = pelicula.getFechaAlquiler();

        // 1. Comprobar si la película tiene una fecha de alquiler registrada
        if (fechaAlquiler != null && pelicula.isAlquilada()) {

            // Convertimos local date a segundos
            ZoneOffset zonaOffset = ZoneOffset.systemDefault().getRules().getOffset(fechaActual);

            // Convertir ambas fechas a segundos Epoch (long)
            long epochActual = fechaActual.toEpochSecond(zonaOffset);
            long epochAlquiler = fechaAlquiler.toEpochSecond(zonaOffset);

            // Calcular la diferencia en segundos
            long segundosTranscurridos = epochActual - epochAlquiler;

            // 2. Comprobar si ha excedido el tiempo máximo
            if (segundosTranscurridos > SEGUNDOS_MAX) {

                System.out.println("La película '" + pelicula.getTitulo() + " ha excedido el tiempo máximo de 48 horas de alquiler.");
            } else {
                System.out.println("Devolución dentro del plazo.");
            }

        } else if (!pelicula.isAlquilada()) {
            System.out.println("ERROR: La película '" + pelicula.getTitulo() + "' no está marcada como alquilada ");
            // Intentamos eliminarla del cliente de todas formas, por si hay inconsistencia.
        }
        // Eliminar la película de la lista del cliente
        boolean eliminadaDeCliente = cliente.eliminarPelicula(pelicula.getCodigo());

        if (eliminadaDeCliente) {

            pelicula.setAlquilada(false);
            pelicula.setFechaAlquiler(null); // Borramos la fecha de alquiler para el próximo alquiler
            System.out.println("Película " + pelicula.getTitulo() + "' devuelta al videoclub.");
        } else {
            System.out.println("La película '" + pelicula.getTitulo() + "' no estaba registrada en la lista de alquileres del cliente " + cliente.getNombre() + ". Solo se actualizó el estado general de la película.");
        }
    }
    }
