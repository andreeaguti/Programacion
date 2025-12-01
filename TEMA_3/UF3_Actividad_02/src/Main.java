import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc;

        String opcion = "";
        do {
            sc = new Scanner(System.in);
            imprimirMenuOpciones();
            opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    String cifValido = MiUtils.comprobarPatronRepetidamente("[A-Z]{1}[0-9]{8}", "Introduzca el CIF del videoclub");
                    String direccionVideoclub = MiUtils.comprobarPatronRepetidamente(".+", "Introduzca la dirección del videoclub");
                    VideoDaw videoDaw = new VideoDaw(cifValido, direccionVideoclub);
                    System.out.println("Videoclub " + cifValido + "con direecion: " + direccionVideoclub + " creada.");
                    System.out.println(videoDaw.mostrarInfoVideoClub());
                    break;
                case "2":
                    System.out.print("Ingrese el codigo de la pelicula: ");
                    String codigo = sc.nextLine();
                    System.out.print("Ingrese el titulo de la pelicula: ");
                    String titulo = sc.nextLine();
                    System.out.print("Ingrese el genero de la pelicula: ");
                    Genero genero;
                    System.out.println("Pelicula con codigo: " + codigo + " creada con exito.");
                    /** Pelicula pelicula = new Pelicula (codigo, titulo, genero);
                    System.out.println(pelicula.mostrarInfoPelicula());
                    VideoDaw.agregarPelicula((pelicula)); **/




            }
        } while (!opcion.equals("8"));
    }
        private static void imprimirMenuOpciones() {
            System.out.println("Escoga la opcion que desee");
            System.out.println("1. Crear y registrar VideoClub en la franquicia.");
            System.out.println("2. Registrar película en videoclub.");
            System.out.println("3. Titular");
            System.out.println("4. Saldo");
            System.out.println("5. Ingreso");
            System.out.println("6. Retirada");
            System.out.println("7. Movimientos");
            System.out.println("8. Salir");
    }

}