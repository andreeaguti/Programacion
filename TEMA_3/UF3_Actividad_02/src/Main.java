import java.beans.JavaBean;
import java.time.LocalDate;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String opcion = "";
        do {
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
                    if (videoDaw == null) {
                        System.out.println("Primero debe crear el videoclub (Opción 1)");
                        break;
                    }
                    //Pido el código y el titulo
                    String codigo = MiUtils.comprobarPatronRepetidamente("^P-\\d{4}$", "Ingrese el codigo de la pelicula:");
                    String titulo = MiUtils.comprobarPatronRepetidamente(".+", "Ingrese el titulo de la pelicula:");

                    Genero[] generosDisponibles = Genero.values(); //devuelve la colección
                    Genero generoSeleccionado = null;
                    int opcionGeneros = -1;
                    do {
                        System.out.print("Elija el genero de la pelicula: \n");
                        for (int i = 0; i < generosDisponibles.length; i++) {
                        System.out.println("  " + (i + 1) + ". " + generosDisponibles[i]);
                        }
                        System.out.print("Ingrese el numero de opcion: ");
                        if (sc.hasNextInt()) {
                            opcionGeneros = sc.nextInt();
                        }else {
                            opcionGeneros = -1;
                            sc.nextLine();
                        }
                        if (opcionGeneros >= 1 && opcionGeneros <= generosDisponibles.length) {
                            // Si es válido, asigna el enum
                            generoSeleccionado = generosDisponibles[opcionGeneros - 1];
                        } else {
                            System.err.println("Opción no válida. Por favor, ingrese un número entre 1 y " + generosDisponibles.length + ".");
                        }
                    } while (generoSeleccionado == null);
                    Pelicula pelicula = new Pelicula(codigo, titulo, generoSeleccionado);
                    videoDaw.agregarPelicula(pelicula); //la registro en el videoclub
                    System.out.println("Pelicula con titulo: " + titulo + " creada con exito.");
                    System.out.println(pelicula.mostrarInfoPelicula()); //muestra la información de la película
                    break;
                case "3":
                    if (videoDaw == null) {
                        System.out.println("Primero debe crear el videoclub (Opción 1)");
                        break;
                    }
                    String dni = MiUtils.comprobarPatronRepetidamente("[0-9]{8}[A-Z]{1}", "Introduzca su DNI (ej: 12345678A): ");
                    String nombre = MiUtils.comprobarPatronRepetidamente(".+", "Introduzca su nombre: ");
                    String numSocio = MiUtils.comprobarPatronRepetidamente("[A-Z]{1}-[0-9]{4}", "Introduzca código de cliente (ej: S-0001): ");
                    String direccionCliente = MiUtils.comprobarPatronRepetidamente(".+", "Introduzca su dirección: ");
                    java.time.LocalDate fechaRegistro = LocalDate.now();



                    break;
                case "4":






            }
        } while (!opcion.equals("8"));
    }
        private static void imprimirMenuOpciones() {
            System.out.println("Escoga la opcion que desee");
            System.out.println("1. Crear y registrar VideoClub en la franquicia.");
            System.out.println("2. Registrar película en videoclub.");
            System.out.println("3. Crear y registrar cliente en videoclub");
            System.out.println("4. Alquilar película");
    }


}