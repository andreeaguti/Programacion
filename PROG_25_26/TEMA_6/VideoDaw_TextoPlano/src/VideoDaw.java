import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class VideoDaw {
    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private ArrayList<Articulo> articulosRegistrados;
    private ArrayList<Cliente> clientesRegistrados;

    public VideoDaw(String cif, String direccion, LocalDate fechaAlta) {
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.articulosRegistrados = new ArrayList<>();
        this.clientesRegistrados = new ArrayList<>();
    }

    // --- GUARDAR EN TXT ---
    public void guardarArticulosTXT(String nombreFichero) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreFichero))) {
            for (Articulo a : articulosRegistrados) {
                // Identificamos el tipo para saber cómo reconstruirlo luego
                String tipo = (a instanceof Pelicula) ? "PELICULA" : "VIDEOJUEGO";

                // Formato: TIPO;COD;TITULO;FECHAREGISTRO;ISALQUILADO
                pw.print(tipo + ";" + a.getCod() + ";" + a.getTitulo() + ";" + a.getFechaRegistro() + ";" + a.isAlquilado());

                // Si es Película, añadimos su género
                if (a instanceof Pelicula) {
                    pw.print(";" + ((Pelicula) a).getGenero());
                }
                // Si es Videojuego, añadimos plataforma y su género específico
                else if (a instanceof Videojuego) {
                    pw.print(";" + ((Videojuego) a).getPlataformavj() + ";" + ((Videojuego) a).getGeneroVideojuego());
                }
                pw.println(); // Salto de línea para el siguiente artículo
            }
        }
    }

    // --- CARGAR DESDE TXT ---
    public void cargarArticulosTXT(String nombreFichero) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            this.articulosRegistrados.clear(); // Limpiamos la lista actual antes de cargar

            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(";"); // d de "datos"
                String tipo = d[0];
                String cod = d[1];
                String titulo = d[2];
                LocalDate fReg = LocalDate.parse(d[3]);
                boolean isAlq = Boolean.parseBoolean(d[4]);

                if (tipo.equals("PELICULA")) {
                    Genero gen = Genero.valueOf(d[5]);
                    Pelicula p = new Pelicula(cod, titulo, gen);
                    p.setFechaRegistro(fReg);
                    p.setAlquilado(isAlq);
                    articulosRegistrados.add(p);
                } else {
                    PLATAFORMAVJ plat = PLATAFORMAVJ.valueOf(d[5]);
                    GeneroVideojuego gvj = GeneroVideojuego.valueOf(d[6]);
                    Videojuego v = new Videojuego(cod, titulo, gvj, plat);
                    v.setFechaRegistro(fReg);
                    v.setAlquilado(isAlq);
                    articulosRegistrados.add(v);
                }
            }
        }
    }

    // Getters necesarios para el Main
    public ArrayList<Articulo> getArticulosRegistrados() { return articulosRegistrados; }
    public ArrayList<Cliente> getClientesRegistrados() { return clientesRegistrados; }
}

/*Conversiones:

Para fechas: LocalDate.parse(string).

Para números: Integer.parseInt(string).

Para booleanos: Boolean.parseBoolean(string).

Para Enums: Genero.valueOf(string).*/

/*import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class VideoDaw {
    // ... Atributos y constructor (CIF, Direccion, listas...) igual que antes

    // --- MÉTODO PARA GUARDAR TODO (ARTÍCULOS Y CLIENTES) ---
    public void guardarTodoTXT(String nombreFichero) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreFichero))) {

            // 1. Guardamos los Artículos
            for (Articulo a : articulosRegistrados) {
                String subTipo = (a instanceof Pelicula) ? "PELI" : "VJUEGO";
                // Formato: ART;SUBTIPO;COD;TITULO;FECHA_REG;ALQUILADO;DATOS_EXTRA
                pw.print("ART;" + subTipo + ";" + a.getCod() + ";" + a.getTitulo() + ";" + a.getFechaRegistro() + ";" + a.isAlquilado());

                if (a instanceof Pelicula) {
                    pw.println(";" + ((Pelicula) a).getGenero());
                } else {
                    pw.println(";" + ((Videojuego) a).getPlataformavj() + ";" + ((Videojuego) a).getGenerovjuego());
                }
            }

            // 2. Guardamos los Clientes
            for (Cliente c : clientesRegistrados) {
                // Formato: CLI;DNI;NOMBRE;DIRECCION;FECHA_NAC;NUMSOCIO
                pw.println("CLI;" + c.getDNI() + ";" + c.getNombre() + ";" + c.getDireccion() + ";" + c.getFechaNacimiento() + ";" + c.getNumSocio());
            }
        }
    }

    // --- MÉTODO PARA CARGAR TODO DESDE EL MISMO ARCHIVO ---
    public void cargarTodoTXT(String nombreFichero) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            this.articulosRegistrados.clear();
            this.clientesRegistrados.clear();

            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(";"); // p de "partes"
                String prefijo = p[0];

                if (prefijo.equals("ART")) {
                    reconstruirArticulo(p);
                } else if (prefijo.equals("CLI")) {
                    reconstruirCliente(p);
                }
            }
        }
    }

    // Métodos auxiliares privados para no enguarrar el código principal
    private void reconstruirArticulo(String[] p) {
        String subTipo = p[1];
        if (subTipo.equals("PELI")) {
            Pelicula pel = new Pelicula(p[2], p[3], Genero.valueOf(p[6]));
            pel.setFechaRegistro(LocalDate.parse(p[4]));
            pel.setAlquilado(Boolean.parseBoolean(p[5]));
            articulosRegistrados.add(pel);
        } else {
            Videojuego vj = new Videojuego(p[2], p[3], GeneroVideojuego.valueOf(p[7]), PLATAFORMAVJ.valueOf(p[6]));
            vj.setFechaRegistro(LocalDate.parse(p[4]));
            vj.setAlquilado(Boolean.parseBoolean(p[5]));
            articulosRegistrados.add(vj);
        }
    }

    private void reconstruirCliente(String[] p) {
        // Recordamos: p[0]=CLI, p[1]=DNI, p[2]=Nombre, p[3]=Dir, p[4]=F_Nac, p[5]=Socio
        Cliente cli = new Cliente(p[1], p[2], p[3], LocalDate.parse(p[4]));
        // Aquí podrías forzar el número de socio guardado si fuera necesario
        clientesRegistrados.add(cli);
    }
}*/

/*import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class VideoDaw implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String cif;
    private String direccion;
    private LocalDate fechaAlta;
    private ArrayList<Articulo> articulosRegistrados;
    private ArrayList<Cliente> clientesRegistrados;

    public VideoDaw(String cif, String direccion, LocalDate fechaAlta) {
        this.cif = cif;
        this.direccion = direccion;
        this.fechaAlta = fechaAlta;
        this.articulosRegistrados = new ArrayList<>();
        this.clientesRegistrados = new ArrayList<>();
    }

    // ==========================================
    //   BLOQUE 1: BINARIO (SERIALIZACIÓN)
    // ==========================================

    public void guardarBinario(String fichero) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
            oos.writeObject(this);
        }
    }

    public static VideoDaw cargarBinario(String fichero) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
            return (VideoDaw) ois.readObject();
        }
    }

    // ==========================================
    //   BLOQUE 2: TEXTO PLANO (TXT / CSV)
    // ==========================================

    public void exportarTXT(String fichero) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fichero))) {
            // Guardamos Artículos
            for (Articulo a : articulosRegistrados) {
                String sub = (a instanceof Pelicula) ? "PELI" : "VJUEGO";
                pw.print("ART;" + sub + ";" + a.getCod() + ";" + a.getTitulo() + ";" + a.getFechaRegistro() + ";" + a.isAlquilado());
                if (a instanceof Pelicula) {
                    pw.println(";" + ((Pelicula) a).getGenero());
                } else {
                    pw.println(";" + ((Videojuego) a).getPlataformavj() + ";" + ((Videojuego) a).getGenerovjuego());
                }
            }
            // Guardamos Clientes
            for (Cliente c : clientesRegistrados) {
                pw.println("CLI;" + c.getDNI() + ";" + c.getNombre() + ";" + c.getDireccion() + ";" + c.getFechaNacimiento());
            }
        }
    }

    public void importarTXT(String fichero) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fichero))) {
            String linea;
            articulosRegistrados.clear();
            clientesRegistrados.clear();
            while ((linea = br.readLine()) != null) {
                String[] p = linea.split(";");
                if (p[0].equals("ART")) {
                    if (p[1].equals("PELI")) {
                        Pelicula pel = new Pelicula(p[2], p[3], Genero.valueOf(p[6]));
                        pel.setFechaRegistro(LocalDate.parse(p[4]));
                        pel.setAlquilado(Boolean.parseBoolean(p[5]));
                        articulosRegistrados.add(pel);
                    } else {
                        Videojuego vj = new Videojuego(p[2], p[3], GeneroVideojuego.valueOf(p[7]), PLATAFORMAVJ.valueOf(p[6]));
                        vj.setFechaRegistro(LocalDate.parse(p[4]));
                        vj.setAlquilado(Boolean.parseBoolean(p[5]));
                        articulosRegistrados.add(vj);
                    }
                } else if (p[0].equals("CLI")) {
                    Cliente cli = new Cliente(p[1], p[2], p[3], LocalDate.parse(p[4]));
                    clientesRegistrados.add(cli);
                }
            }
        }
    }

    // Getters para el Main
    public ArrayList<Articulo> getArticulosRegistrados() { return articulosRegistrados; }
}*/