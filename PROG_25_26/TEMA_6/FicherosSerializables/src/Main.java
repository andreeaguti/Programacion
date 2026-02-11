import javax.xml.xpath.XPath;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        final String path = "./src/resources/";
        final String fileName = "";
        boolean fileMode = false;

        Alumno pp = new Alumno("Pepe", "Blanco", 18, "pepe@gmail.com");
        pp.calificar("Programación", 5);
        pp.calificar("Bases de datos", 7);
        pp.calificar("Lenguaje de marcas", 9);
        pp.calificar("Sistemas informáticos", 5);
        pp.calificar("Inglés", 2);


        //CREACION Y APERTURA DEL FICHERO
        FileOutputStream file;
        ObjectOutputStream buffer;

        try{
            file = new FileOutputStream(path+fileName, fileMode);
            buffer = new ObjectOutputStream(file);
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo");
            ret
        }

        //ESCRITURA DEL FICHERO
        try{
            buffer.writeObject(pp);
            System.out.println("Archivo creado con exito");
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo");
        }

        try {
            file.close();
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error al cerrar el archivo");
        }



    }
}