import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

    //Validación para nombre
        MiUtils.comprobarPatronRepetidamente("^[A-Z][a-zA-Z]*$", "Introduzca el nombre: ");
    //Validación para número de teléfono
        MiUtils.comprobarPatronRepetidamente("^[679][0-9]{8}$", "Introduzca el numero de teléfono: ");
    //Validación para el correo
        MiUtils.comprobarPatronRepetidamente("[a-z0-9._-]+@[a-z]+\\.[a-z]{2,4}", "Introduzca el correo: ");








    }
}