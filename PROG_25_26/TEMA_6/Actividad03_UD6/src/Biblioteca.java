import java.io.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Biblioteca {

    private static final String PATH = "Biblioteca.dat";
    private HashSet<Libro> libros;

public Biblioteca(){
    libros = new HashSet<>();
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

    //METODO PARA GUARDAR
    public void guardarEnFichero() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PATH))) {
            oos.writeObject(libros);
            System.out.println("Datos guardados correctamente en " + PATH);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    //METODO PARA ABRIR FICHERO
    public void abrirFichero() {
        FileInputStream file;
        ObjectInputStream buffer;

        try{
            file = new FileInputStream(".\\src\\resources\\Biblioteca.dat");
            buffer = new ObjectInputStream(file);
        }catch (IOException e){
            System.out.println("Error al abrir la biblioteca");
            System.out.println(e.getMessage());
            return;
        }
        /*Leemos la lista de libros
        boolean eof = false;
        while (!eof) {
            try {
                libros = (Libro) buffer.readObject();
                System.out.println(libros);
            } catch (EOFException e) {
                eof = true;
            }catch (IOException e2){
            System.out.println("Error al abrir la biblioteca");
            System.out.println(e2.getMessage());}
        }catch(ClassNotFoundException){
        S}*/
    }


}
