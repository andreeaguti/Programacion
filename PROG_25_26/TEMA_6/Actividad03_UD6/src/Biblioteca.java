import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;


public class Biblioteca implements Serializable {

    private static List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Biblioteca{");
        sb.append(", libros=").append(libros);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Biblioteca biblioteca = (Biblioteca) o;
        return Objects.equals(libros, biblioteca.libros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libros);
    }

    //METODO PARA ABRIR FICHERO
    public static void abrirFichero() {
        final String path = ".\\src\\resources\\";
        final String filename = "biblioteca.dat";

        libros = new ArrayList<>();


        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(path + filename))) {
            while (true) {
                try {
                    Libro l = (Libro) lector.readObject();
                    libros.add(l);
                } catch (EOFException e) {
                    break;
                }
            }
            System.out.println("Carga finalizada. Libros cargados: " + libros.size());

        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe. Se creará uno nuevo al guardar.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al manejar archivo: " + e.getMessage());
        }

        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }


    //METODO PARA CREAR LIBRO Y REGISTRARLO EN LA BIBLIOTECA
    public void crearLibro() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {

            System.out.println("Introduce el isbn del libro: ");
            String isbn = sc.nextLine();

            for (Libro l : libros) {
                if (l.getIsbn().equalsIgnoreCase(isbn)) {
                    System.out.println("Error: Ya existe un libro con ese ISBN.");
                    return;
                }
            }

            System.out.println("Introduce el titulo del libro: ");
            String titulo = sc.nextLine();
            System.out.println("Introduce a el autor del libro: ");
            String autor = sc.nextLine();

            System.out.println("Introduce la fecha de publicación del libro (dd/mm/aaaa): ");
            String fechaPublicacion = sc.nextLine();

            LocalDate fechaFinal = LocalDate.parse(fechaPublicacion, formato);

            Libro nuevo = new Libro(isbn, titulo, autor, fechaPublicacion);

            libros.add(nuevo);

            System.out.println("Libro guardado correctamente en la biblioteca");

        }catch (DateTimeParseException e){
            System.out.println("Error: El formato de fecha no es válido (usa dd/mm/aaaa).");
        } catch (Exception e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    //METODO PARA MOSTRAR LIBROS EXISTENTES
    public static void mostrarLibros(){
        if(libros.isEmpty()){
            System.out.println("No hay libros en la biblioteca");
        }else{
            for(Libro libro : libros){
                System.out.println(libro.toString());
            }
        }
    }


//METODO PARA ELIMINAR LIBROS POR ISBN
    public static void eliminarLibro(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el isbn del libro que desea eliminar: ");
        String codigo = sc.nextLine();

        Libro pAux= null;
        for(Libro libro : libros){
            if(libro.getIsbn().equals(codigo)){
                pAux = libro;
                break;
            }
        }
        if(pAux != null){
            libros.remove(pAux);
            System.out.println("Libro eliminado correctamente en la biblioteca");
        }else {
            System.out.println("Libro no encontrado");
        }
    }

    //METODO PARA GUARDAR LIBROS EN FICHERO
    public static void guardarEnFichero() {
        final String path = ".\\src\\resources\\";
        final String filename = "biblioteca.dat";

        // Creo la carpeta si no existe
        File doc = new File(path);
        if (!doc.exists()) doc.mkdirs();

        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(path + filename))) {
            // Guardamos cada libro de la lista uno por uno
            for (Libro l : libros) {
                escritor.writeObject(l);
            }
            System.out.println("Datos guardados correctamente en el fichero.");
        } catch (IOException e) {
            System.out.println("Error al guardar en el fichero: " + e.getMessage());
        }
    }
}
