import java.time.LocalDate;
import java.util.Scanner;

public class Gestion {

    private static final String PATH = ".\\src\\resources\\";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;

        String archivo = "videodaw.dat";

        Empresa empresa = null;

        do {
            opcion = mostrarMenu(sc);

            switch (opcion) {

                case 1:
                    // Registrar trabajador en empresa:
                    System.out.println(" ¿QUÉ DESEA REGISTRAR? ");
                    System.out.println("1. Director");
                    System.out.println("2. Gerente");
                    System.out.println("3. Trabajador normal");
                    String tipo = sc.nextLine();

                    System.out.print("Introduzca el nombre del trabajador: ");
                    String nombre = sc.nextLine();

                    Persona nuevaPersona = null;

                    if (tipo.equals("1")) {
                        // LÓGICA DE DIRECTOR
                        System.out.println("Introduzca un numero de telefono: ");
                        int telefono = sc.nextInt();

                        String dni = MiUtils.comprobarPatronRepetidamente(
                                "[[0-9]{8}a-zA-Z]",
                                "Introduzca el DNI (formato 12345678A): "
                        );

                        System.out.print("Introduzca la dirección del Trabajador: ");
                        String direccionT = sc.nextLine();


                        String numeroSS = MiUtils.comprobarPatronRepetidamente(
                                "[0-9]{10}",
                                "Introduzca el Numero de la SS (10 digitos): "
                        );

                        System.out.print("Introduzca el email del Trabajador: ");
                        String email = sc.nextLine();

                        System.out.println("Seleccione un departamento:");
                        for (Departamento d : Departamento.values()) {
                            System.out.println("- " + d);
                        }
                        Departamento departamento = Departamento.valueOf(sc.nextLine().toUpperCase());


                        nuevaPersona = new Director(nombre, LocalDate.of(2002, 11, 7), dni, direccionT,
                                numeroSS, email, 5000, departamento, "664819075", "true");

                    } else if (tipo.equals("2")) {
                        // LÓGICA DE GERENTE
                        System.out.println("Introduzca un número de telefono: ");
                        int telefono = sc.nextInt();

                        String dni = MiUtils.comprobarPatronRepetidamente(
                                "[[0-9]{8}a-zA-Z]",
                                "Introduzca el DNI (formato 12345678A): "
                        );

                        System.out.print("Introduzca la dirección del Trabajador: ");
                        String direccion2 = sc.nextLine();


                        String numeroSS = MiUtils.comprobarPatronRepetidamente(
                                "[0-9]{10}",
                                "Introduzca el Numero de la SS (10 digitos): "
                        );

                        System.out.print("Introduzca el email del Trabajador: ");
                        String email = sc.nextLine();

                        System.out.println("Seleccione una gerencia:");
                        for (Gerencia gerencia : Gerencia.values()) {
                            System.out.println("- " + gerencia);
                        }
                        Gerencia gerencia = Gerencia.valueOf(sc.nextLine().toUpperCase());


                        nuevaPersona = new GerenteDep(nombre, LocalDate.of(2003, 8, 9), dni,
                                direccion2, numeroSS, email, 2200, gerencia, "T-0123", gerencia, "10");

                    } else if (tipo.equals("3")) {

                        String numeroSS = MiUtils.comprobarPatronRepetidamente(
                                "[0-9]{10}",
                                "Introduzca el Numero de la SS (10 digitos): "
                        );

                        String dni = MiUtils.comprobarPatronRepetidamente(
                                "[[0-9]{8}a-zA-Z]",
                                "Introduzca el DNI (formato 12345678A): "
                        );
                        System.out.print("Introduzca la dirección del Trabajador: ");
                        String direccionT = sc.nextLine();

                        String numeroSegS = MiUtils.comprobarPatronRepetidamente(
                                "[0-9]{10}",
                                "Introduzca el Numero de la SS (10 digitos): "
                        );
                        System.out.print("Introduzca el email del Trabajador: ");
                        String email = sc.nextLine();

                        System.out.println("Seleccione un departamento:");
                        for (Departamento d : Departamento.values()) {
                            System.out.println("- " + d);
                        }
                        Departamento departamento = Departamento.valueOf(sc.nextLine().toUpperCase());
                    }

                    break;
                case 2: // MOSTRAR INFORMACIÓN
                    //Mostrar información general de la empresa, con todos los trabajadores ordenados por
                    //el DNI, gerentes y director y guardar en un fichero de texto plano llamado
                    //“estructura.dat”.
                    System.out.println(empresa.mostrarInformacionTrabajadores());
                    try {

                        empresa = Empresa.guardarTrabajadoresTXT;
                        empresa = Empresa.cargarArticulosTXT(archivo);
                        System.out.println("--- DATOS CARGADOS CORRECTAMENTE ---");

                    } catch (Exception e) {
                        //Si el archivo no existe o da error, creo uno nuevo desde cero
                        System.out.println("No se encontraron datos previos. Iniciando registro nuevo...");
                    }
                    break;
                case 5:
                    System.out.println(" DAR DE BAJA TRABAJADOR ");
                    System.out.print("DNI del trabajador: ");
                    String dniBaja = sc.nextLine();

                    if (empresa.eliminarTrabajador(dniBaja)) {
                        System.out.println("Cliente dado de baja.");
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;

                case 7:
                    System.out.println("Guardando datos y saliendo...");
                    try {
                        empresa.guardarTrabajadoresTXT(archivo);
                        System.out.println("¡Datos guardados con éxito!");
                    } catch (Exception e) {
                        System.out.println("Error al guardar el archivo.");
                        e.printStackTrace();
                    }
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        }
        while (opcion != 7);
    }

            // MENÚ
            public static int mostrarMenu (Scanner sc){
                System.out.println("\n MENÚ PRINCIPAL ");
                System.out.println("1. Registrar trabajador (Director/Gerente/Normal)");
                System.out.println("2. Mostrar información de la empresa");
                System.out.println("3. Mostrar numero de trabajadores");
                System.out.println("4. Mostar informacion de un departamento");
                System.out.println("5. Eliminar trabajador");
                System.out.println("6. Guardar información de la empresa en fichero");
                System.out.println("7. Guardar y Salir");
                System.out.print("Seleccione una opción: ");

                String entrada = sc.nextLine().trim();
                while (!entrada.matches("[1-7]")) {
                    System.out.print("Opción no válida. Ingrese 1-7: ");
                    entrada = sc.nextLine().trim();
                }

                return Integer.parseInt(entrada);
            }

        }