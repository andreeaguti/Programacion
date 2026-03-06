import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VideoDaw {

    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private List<Articulo> articulosRegistrados;
    private List<Cliente> clientesRegistrados;
    private List<Pelicula> peliculasRegistradas;

    private int contadorArticulos;
    private int contadorClientes;
    private int contadorPeliculas;


    public VideoDaw(String cif, String direccion, LocalDate fechaAlta, List<Articulo> articulosRegistrados, List<Cliente> clientesRegistrados, List<Pelicula> peliculasRegistradas) throws DireccionIncorrectaException, Exception{
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.articulosRegistrados = new ArrayList<>(articulosRegistrados);
        this.clientesRegistrados = new ArrayList<>(clientesRegistrados);
        this.peliculasRegistradas = new ArrayList<>(peliculasRegistradas);
    }

    public String getCif() {
        return cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public List<Articulo> getArticulosRegistrados() {
        return articulosRegistrados;
    }

    public List<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }

    public void setDireccion(String direccion) throws DireccionIncorrectaException{
        if (direccion == null) {
            throw new DireccionIncorrectaException("La dirección no puede estar vacía");
        } else {
            this.direccion = direccion;
        }
    }

    public void setArticulosRegistrados(List<Articulo> articulosRegistrados) {
        this.articulosRegistrados = articulosRegistrados;
    }

    public void setClientesRegistrados(List<Cliente> clientesRegistrados) {
        this.clientesRegistrados = clientesRegistrados;
    }

    //METODO PARA MOSTRAR LA INFORMACION DEL VIDEOCLUB
    public String mostrarInfoVideoClub() {
        String mostrarInfoVideoClub = "";
        mostrarInfoVideoClub = "CIF: " + this.getCif() + "\n";
        mostrarInfoVideoClub += "Direccion: " + this.getDireccion() + "\n";
        mostrarInfoVideoClub += "Fecha de alta: " + this.getFechaAlta() + "\n";
        mostrarInfoVideoClub += "Articulos registrados: " + this.getArticulosRegistrados() + "\n";
        mostrarInfoVideoClub += "Clientes registrados: " + this.getClientesRegistrados() + "\n";
        return mostrarInfoVideoClub;
    }


    //METODO PARA REGISTRAR PELICULA
    public void registrarPelicula() {
        Scanner sc = new Scanner(System.in);

        // Código con validacion
        String codigo = MiUtils.comprobarPatronRepetidamente("^[A-Z]-\\d{4}$", "Introduzca el código de la película");

        // Titulo
        System.out.println("Introduzca el título de la película: ");
        String titulo = sc.nextLine();

        //Género
        Genero genero = null;
        while (genero == null) {
            try{
                System.out.println("Introduzca el género (ACCION, COMEDIA, TERROR, DRAMA...): ");
                genero = Genero.valueOf(sc.nextLine().toUpperCase());
            }catch(IllegalArgumentException e) {
                System.out.println("Error: El género introducido no es válido.");
            }
        }
        //Fechas automaticas
        LocalDate fechaRegistro = LocalDate.now();
        LocalDate fechaBaja = null;
        LocalDateTime fechaAlquiler = null;

        // Estado
        boolean isAlquilada = false;

        // Creo la pelicula
        Pelicula nueva = new Pelicula(codigo, titulo, fechaRegistro, fechaBaja, genero, fechaAlquiler, isAlquilada);
        peliculasRegistradas.add(nueva);
        articulosRegistrados.add(nueva);

        System.out.println("Película registrada: " + nueva.toString());
    }

    //METODO PARA VER LAS PELICULAS REGISTRADAS mostrarPeliculasRegistradas().

    public String mostrarPeliculasRegistradas() {
        String info = "No hay peliculas registradas";
        if (peliculasRegistradas.size() <= 0) {
            System.out.println("Lista de peliculas vacia");
        } else {
            for (Pelicula art : peliculasRegistradas) {
                System.out.println(peliculasRegistradas.toString());
            }
        }
        return info;
    }

    //METODO PARA REGISTRAR CLIENTES
    public void registrarClientes() {
        Scanner sc = new Scanner(System.in);

        LocalDate fechaNacimiento = null;

        // DNI con validacion
        String dni = MiUtils.comprobarPatronRepetidamente("^[0-9]{8}[A-Z]$", "Introduzca el DNI del cliente");

        //NOMBRE
        System.out.println("Introduzca el nombre del cliente: ");
        String nombre = sc.nextLine();

        //DIRECCION
        System.out.println("Introduzca la direccion del cliente: ");
        String direccion = sc.nextLine();

        //FECHA DE NACIMIENTO
        LocalDate fechaLimite = LocalDate.now().minusYears(18);
        boolean esMayor = false;
        while (!esMayor) {
            try {
                System.out.println("Introduzca la fecha de nacimiento (AAAA-MM-DD): ");
                fechaNacimiento = LocalDate.parse(sc.nextLine());
                if (fechaNacimiento.isBefore(fechaLimite) || fechaNacimiento.isEqual(fechaLimite)) {
                    esMayor = true;
                } else {
                    System.out.println("Error: El cliente debe ser mayor de edad.");
                    return; // O puedes usar un bucle para volver a pedirla
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato incorrecto. Use AAAA-MM-DD.");
            }
        }

        //NUMERO DE SOCIO CON VALIDACION
        String numSocio = MiUtils.comprobarPatronRepetidamente("^S-\\d{4}$", "Introduzca el Numero de socio del cliente");

        //FECHA BAJA
        LocalDate fechaBaja = null;

        try {
            // Al llamar al constructor, la colección se crea vacía automáticamente
            Cliente nuevo = new Cliente(dni, nombre, direccion, fechaNacimiento, numSocio, fechaBaja);

            // Lo añado a la lista
            clientesRegistrados.add(nuevo);

            System.out.println("Cliente registrado con éxito.");

        } catch (DniIncorrectoException e) {
            System.out.println("No se pudo registrar: " + e.getMessage());
        }
    }

    public String mostrarClientesRegistrados() {
        String info = "No hay clientes registrados";
        if (clientesRegistrados.size() <= 0) {
            System.out.println("Lista de clientes vacia");
        } else {
            for (Cliente cliente : clientesRegistrados) {
                System.out.println(clientesRegistrados.toString());
            }
        }
        return info;
    }

    //Un método para alquilar una película alquilar película o videojuego, comprobar que ese artículo no esté ya alquilado.
    public void alquilarArticulo() {
        Scanner sc = new Scanner(System.in);

        String codSocio = MiUtils.comprobarPatronRepetidamente("^S-\\d{4}$", "Introduzca su código de socio (ej: S-0001):");
        Cliente clienteEncontrado = null;

        for (Cliente c : clientesRegistrados) {
            if (c.getNumSocio().equals(codSocio)) {
                clienteEncontrado = c;
                break;
            }
        }
        if (clienteEncontrado == null) {
            System.out.println("Error: El cliente no está registrado.");
        }

        String codArticulo = MiUtils.comprobarPatronRepetidamente("^P-\\d{4}$", "Introduzca el código del artículo a alquilar (ej: P-0001):");
        Articulo articuloEncontrado = null;

        for (Articulo a : articulosRegistrados) {
            if (a.getCodigo().equals(codArticulo)) {
                articuloEncontrado = a;
                break;
            }
        }
        if (articuloEncontrado != null) {

            boolean yaAlquilado = false;
            if (articuloEncontrado instanceof Pelicula) {
                yaAlquilado = ((Pelicula) articuloEncontrado).isAlquilada();
            } else if (articuloEncontrado instanceof Videojuego) {
                yaAlquilado = ((Videojuego) articuloEncontrado).isAlquilada();
            }

            if (!yaAlquilado) {
                if (articuloEncontrado instanceof Pelicula) {
                    ((Pelicula) articuloEncontrado).setAlquilada(true);
                    ((Pelicula) articuloEncontrado).setFechaAlquiler(LocalDateTime.now());
                } else {
                    ((Videojuego) articuloEncontrado).setAlquilada(true);
                    ((Videojuego) articuloEncontrado).setFechaAlquiler(LocalDateTime.now());
                }

                clienteEncontrado.getArticulosAlquilados().add(articuloEncontrado);
                System.out.println("Alquiler realizado con éxito: " + articuloEncontrado.getTitulo());

            } else {
                System.out.println("Lo sentimos, este artículo ya se encuentra alquilado.");
            }
        } else {
            System.out.println("No se ha encontrado ningún artículo con ese código.");
        }
    }


    public void darBajaCliente() throws Exception{
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el numero de cliente que desea dar de baja (S-0001): ");
        String bajaCliente = sc.nextLine();
        for (Cliente c : clientesRegistrados) {
            if (c.getNumSocio().equals(bajaCliente)) {
                clientesRegistrados.remove(c);
                System.out.println("Cliente eliminado correctamente.");
                break;
            }else {
                throw new Exception("No existe el producto con el referencia: " + bajaCliente);
            }
        }
    }

    public void darBajaArticulo() throws Exception{
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el numero de articulo que desea dar de baja (P-0001): ");
        String bajaArticulo = sc.nextLine();
        for (Articulo a : articulosRegistrados) {
            if (a.getCodigo().equals(bajaArticulo)) {
                articulosRegistrados.remove(a);
                System.out.println("Articulo eliminado correctamente.");
                break;
            }else {
                throw new Exception("No existe el producto con el código: " + bajaArticulo);
            }
        }
    }






    }


