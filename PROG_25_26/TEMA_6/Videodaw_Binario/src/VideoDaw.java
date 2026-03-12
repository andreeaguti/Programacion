import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.*;
import java.io.Serializable;
import exceptions.ArticuloYaRegistradoException;
import exceptions.ClienteYaRegistradoException;

public class VideoDaw implements Serializable {

    @Serial
    private static final long serialVersionUID = 1210630457771155714L;


    // ATRIBUTOS
    private String CIF;
    private String direccion;
    private LocalDate fechaAlta;
    private ArrayList<Articulo> articulosRegistrados;//ANUAR RECOMIENDA TRABAJAR ESTO CON MAPA, PARA EVITAR REPETIDOS
    private ArrayList<Cliente> clientesRegistrados;//ANUAR RECOMIENDA TRABAJAR ESTO CON MAPA, PARA EVITAR REPETIDOS


    //CONSTRUCTOR

    public VideoDaw(String CIF, String direccion, LocalDate fechaAlta) {
        this.CIF = CIF;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.articulosRegistrados = new ArrayList<>();
        this.clientesRegistrados = new ArrayList<>();

    }

    // GETTERS

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public ArrayList<Articulo> getArticulosRegistrados() {
        return articulosRegistrados;
    }

    public ArrayList<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }

    // SETTERS

    public void setCIF(String CIF) {
        this.CIF = CIF;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }


    // MOSTRAR INFO DEL VIDEOCLUB

    public String mostrarInfoVideoClub() {
        String info = "";
        info += "CIF: " + CIF + "\n";
        info += "Direccion: " + direccion + "\n";
        info += "FechaAlta: " + fechaAlta + "\n";
        info += "Total Articulos Registrados: " + articulosRegistrados.size() + "\n";
        info += "Total Clientes Registrados: " + clientesRegistrados.size() + "\n";
        return info;
    }

    // MOSTRAR ARTICULOS REGISTRADAS

    public String mostrararticulosRegistrados() {
        String listado = "ARTICULOS REGISTRADOS:\n";
        if (articulosRegistrados.isEmpty()) {
            listado += "No hay articulos registrados\n";
        } else {
            for (Articulo a : articulosRegistrados) {
                listado += a.toString() + "\n";
            }
        }
        return listado;
    }


    // MOSTRAR CLIENTES REGISTRADOS

    public String mostrarClientesRegistrados() {
        String listado = "CLIENTES REGISTRADOS:\n";
        if (clientesRegistrados.isEmpty()) {
            listado += "No hay clientes registrados\n";
        }else  {
            for (Cliente c : clientesRegistrados) {
                listado += "- " + c.getNombre() + " (Socio: " + c.getNumSocio() + ")\n";
            }
        }
        return listado;
    }

    // REGISTRAR CLIENTE +EXCEPCION

    public boolean registrarCliente(Cliente c) throws ClienteYaRegistradoException { //Indica que este metodo "puede lanzar" un error.
        //Antes de añadir, recorres la lista. Si encuentras un DNI igual, lanzas la excepción personalizada. Esto evita duplicados. El metodo registrarArticulo hace exactamente lo mismo con el codigo.
        for (Cliente cli : clientesRegistrados) {
            if (cli.getDNI().equalsIgnoreCase(c.getDNI())) {
                throw new ClienteYaRegistradoException("El cliente con DNI " + c.getDNI() + " ya existe.");
            }
        }
        return clientesRegistrados.add(c);
    }

    // DAR DE BAJA CLIENTE
    public boolean darBajaCliente(String dni) {
        //Fíjate que no borras al cliente de la lista. Simplemente le pones una fechaBaja. Esto es mejor en gestión para mantener el histórico de alquileres.
        for (Cliente c : clientesRegistrados) {
            if (c.getDNI().equalsIgnoreCase(dni)) {
                c.setFechaBaja(LocalDate.now());
                return true;
            }
        }
        return false;
    }


    // REGISTRAR ARTICULO

    public boolean registrarArticulo(Articulo a) throws ArticuloYaRegistradoException {
        for (Articulo art : articulosRegistrados) {
            if (art.getCod().equalsIgnoreCase(a.getCod())) {
                throw new ArticuloYaRegistradoException("El artículo con código " + a.getCod() + " ya existe.");
            }
        }
        return articulosRegistrados.add(a);
    }

    // DAR DE BAJA ARTICULO
    public boolean darBajaArticulo(String cod) {
        for (Articulo a : articulosRegistrados) {
            if (a.getCod().equalsIgnoreCase(cod)) {
                a.setFechaBaja(LocalDate.now());
                return true;
            }
        }
        return false;
    }

    // ALQUILAR PELÍCULA
    public boolean alquilarArticulo(Articulo a, Cliente c) {

        //Comprueba si ya está alquilado
        if (a.isAlquilado()) {
            return false;
        }

        // Si está libre, cambia el estado a true
        a.setAlquilado(true);
        // Y registra la hora actual
        a.setFechaAlquiler(LocalDateTime.now());

        // Lo añado la lista del cliente (el metodo que ya hicimos en Cliente)
        c.addArticuloAlquilado(a);

        return true;
    }

    // DEVOLVER ARTICULO
    public boolean devolverArticulo(Articulo a, Cliente c) {

        // COMPRUEBO SI EL ARTICULO ESTA ALQUILADO
        if (!a.isAlquilado()) {
            return false;
        }

        // RESETEAR EL ESTADO DEL ARTICULO AHORA ESTA DISPONIBLE DE NUEVO
        a.setAlquilado(false);
        a.setFechaAlquiler(null);

        // 3. Lo quitO de la lista del cliente
        // Como use ArrayList,
        return c.removeArticuloAlquilado(a);
    }

    // MeTODO PARA GUARDAR TOoDO EL VIDEOCLUB EN UN ARCHIVO BINARIO!!!!

    public void guardarDatos(String nombreFichero) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
            oos.writeObject(this); // Se guarda  con todo lo que tiene dentro
        }
    }

    // MeTODO PARA CARGAR DATOS (Este es estático porque crea un objeto nuevo)
    public static VideoDaw cargarDatos(String nombreFichero) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombreFichero))) {
            return (VideoDaw) ois.readObject();
        }
    }

}//CIERRE CLASE VIDEODAW
/*// MeTODO PARA GUARDAR EN TEXTO PLANO
public void guardarDatosTexto(String nombreFichero) throws IOException {
    // Usamos PrintWriter para escribir líneas de texto legibles
    try (PrintWriter pw = new PrintWriter(new FileWriter(nombreFichero))) {

        // 1. Guardamos los datos básicos del videoclub
        pw.println(this.CIF + ";" + this.direccion + ";" + this.fechaAlta);

        // 2. Guardamos los artículos (uno por línea)
        pw.println("---ARTICULOS---");
        for (Articulo a : articulosRegistrados) {
            pw.println(a.getCod() + ";" + a.getTitulo() + ";" + a.isAlquilado());
        }

        // 3. Guardamos los clientes (uno por línea)
        pw.println("---CLIENTES---");
        for (Cliente c : clientesRegistrados) {
            pw.println(c.getDNI() + ";" + c.getNombre() + ";" + c.getNumSocio());
        }
    }
}

// MÉTODO PARA CARGAR DESDE TEXTO PLANO
public static VideoDaw cargarDatosTexto(String nombreFichero) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {

        // 1. Leemos la primera línea (Datos del Videoclub)
        String lineaCabecera = br.readLine();
        if (lineaCabecera == null) return null;

        String[] partes = lineaCabecera.split(";");
        String cif = partes[0];
        String dir = partes[1];
        LocalDate alta = LocalDate.parse(partes[2]); // Convertimos texto a fecha

        // Creamos el objeto vacío para ir rellenándolo
        VideoDaw vd = new VideoDaw(cif, dir, alta);

        // Aquí vendría un bucle complejo para leer el resto de líneas,
        // identificar si son artículos o clientes, y hacer "new Pelicula(...)" o "new Cliente(...)"
        // según lo que diga el texto.

        return vd;
    }
}
 */
