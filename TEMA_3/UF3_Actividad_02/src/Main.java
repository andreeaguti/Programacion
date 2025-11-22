import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String codigoValido = MiUtils.comprobarPatronRepetidamente("P-[0-9]{4}","Introduzca un codigo");
        String numSocioValido = MiUtils.comprobarPatronNumSocio("S-[0-9]{4}","Introduzca su numero de socio");
        String dniValido = MiUtils.comprobarPatronDNI("[0-9]{8}[A-Z]$","Introduzca su dni");



    }
}