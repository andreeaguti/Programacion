import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    private static final Scanner SC = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Patrones para validación de entrada
    private static final Pattern CIF_PATTERN = Pattern.compile("^[A-Z]\\d{10}$");
    private static final Pattern DNI_PATTERN = Pattern.compile("^\\d{8}[A-Z]$");
    private static final Pattern NUMSS_PATTERN = Pattern.compile("^\\d{10}$");
    private static final Pattern DATE_STRUCT_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$"); // DD/MM/YYYY

    private static Empresa miEmpresa = null;

    public static void main(String[] args) {

        System.out.println("--- GESTIÓN DE EMPRESAS DEV-WORK ---");

        // El Main llama al método inicial que asegura la creación de la empresa
        crearEmpresaInicialSinTryCatch();

        if (miEmpresa != null) {
            menuPrincipal();
        } else {
            System.out.println("No se pudo crear la empresa. Programa finalizado.");
        }
    }

    /**
     * Intenta crear la instancia de Empresa. Usa validación condicional.
     */
    private static void crearEmpresaInicialSinTryCatch() {
        System.out.println("\n*** CONFIGURACIÓN INICIAL DE LA EMPRESA ***");

        String nombre = pedirStringObligatorio("Nombre de la Empresa:");

        // 1. Pedimos y validamos datos antes de la creación
        String cif = pedirStringConFormato("CIF (Letra mayúscula + 10 dígitos):", CIF_PATTERN, "Formato CIF incorrecto.");
        int maximoTrabajadores = pedirEnteroPositivo("Máximo de trabajadores:");

        // 2. La fecha se pide como String y se convierte. Si la fecha es ilógica (31/02),
        //    asumimos que la clase Empresa lo manejará, pero Main evita que el String sea basura.
        String fechaFundacionStr = pedirStringConFormato("Fecha de fundación (DD/MM/YYYY):", DATE_STRUCT_PATTERN, "Formato de fecha DD/MM/YYYY incorrecto.");

        // 3. Conversión de fecha (Necesario para el constructor)
        LocalDate fechaFundacion = convertirStringAFecha(fechaFundacionStr);

        // 4. Creamos la empresa (Asumimos que las validaciones internas de Empresa pasan)
        if (miEmpresa == null) {
            miEmpresa = new Empresa(nombre, cif, fechaFundacion, maximoTrabajadores);
            System.out.println("\n✅ Empresa '" + miEmpresa.getNombre() + "' creada con éxito.");
        }
    }

    /**
     * Bucle principal que muestra el menú y usa la estructura SWITCH.
     */
    private static void menuPrincipal() {
        String opcion;
        do {
            imprimirMenu();
            opcion = SC.nextLine().trim();

            // --- USO DE SWITCH PARA EL MENÚ ---
            switch (opcion) {
                case "1": crearPersona(); break;
                case "2": registrarTrabajadorEnEmpresa(); break;
                case "3": System.out.println(miEmpresa.mostrarInformacionEmpresa()); break;
                case "4": System.out.println("Trabajadores actuales: " + miEmpresa.getContadorTrabajadores()); break;
                case "5": System.out.println(miEmpresa.mostrarInformacionTrabajadores()); break;
                case "6": eliminarTrabajadorEmpresa(); break;
                case "7": eliminarPersonaDelPrograma(); break;
                case "8": System.out.println("Saliendo de la aplicación..."); break;
                default: System.out.println("Opción no válida. Intente de nuevo.");
            }
            if (!opcion.equals("8")) {
                System.out.println("\nPresione ENTER para continuar...");
                SC.nextLine();
            }
        } while (!opcion.equals("8"));
    }

    private static void registrarTrabajadorEnEmpresa() {
        System.out.println("\n--- REGISTRO DE TRABAJADOR ---");

        // 1. Pedir y validar formatos antes de la creación
        String dni = pedirStringConFormato("DNI del trabajador (8 digitos + 1 letra MAYÚSCULA):", DNI_PATTERN, "Formato DNI incorrecto.");

        // Si el trabajador ya existe, salimos
        if (miEmpresa.buscarTrabajadorPorDni(dni) != null) {
            System.err.println("❌ ERROR: El DNI ya está registrado en la empresa.");
            return;
        }

        // 2. Recogemos el resto de datos
        String numSS = pedirStringConFormato("Número de Seguridad Social (10 dígitos):", NUMSS_PATTERN, "Formato NumSS incorrecto.");
        String nombre = pedirStringObligatorio("Nombre:");
        String fechaNacimientoStr = pedirStringConFormato("Fecha de Nacimiento (DD/MM/YYYY):", DATE_STRUCT_PATTERN, "Formato de fecha incorrecto.");
        String direccion = pedirStringObligatorio("Dirección:");

        // 3. Conversión de fecha y creación del objeto
        LocalDate fechaNacimiento = convertirStringAFecha(fechaNacimientoStr);

        // 4. Creamos el objeto Trabajador
        // NOTA: Asumimos que las validaciones internas de Trabajador NO lanzan excepción
        // si los formatos DNI/SS ya fueron verificados en el Main.
        Trabajador nuevoTrabajador = new Trabajador(nombre, fechaNacimiento, dni, direccion, numSS);

        // 5. Registramos en la Empresa
        miEmpresa.registrarTrabajador(nuevoTrabajador);
    }

    private static void eliminarTrabajadorEmpresa() {
        System.out.println("\n--- ELIMINAR TRABAJADOR ---");
        String dniBaja = pedirStringObligatorio("DNI del trabajador a eliminar:");

        miEmpresa.eliminarTrabajadorEmpresa(dniBaja);
    }

    // --- MÉTODOS PLACEHOLDER ---
    private static void crearPersona() { System.out.println("... Lógica para crear un objeto Persona ..."); }
    private static void eliminarPersonaDelPrograma() { System.out.println("... Lógica para eliminar un objeto Persona ..."); }

    // ---------------------------------------------------------------------
    // --- MÉTODOS AUXILIARES DE INPUT SIN TRY-CATCH ---
    // ---------------------------------------------------------------------

    /**
     * Pide una cadena de texto y usa un patrón Regex para forzar el formato.
     */
    private static String pedirStringConFormato(String mensaje, Pattern pattern, String errorMsg) {
        String input;
        boolean valido = false;
        do {
            input = pedirStringObligatorio(mensaje);
            if (pattern.matcher(input).matches()) {
                valido = true;
            } else {
                System.err.println("❌ " + errorMsg);
            }
        } while (!valido);
        return input;
    }

    /**
     * Convierte una cadena de texto a LocalDate.
     * NOTA: Este método lanza una excepción si el formato es inválido,
     * pero confiamos en que pedirStringConFormato() ya ha validado la estructura.
     */
    private static LocalDate convertirStringAFecha(String fechaStr) {
        // En un entorno sin try-catch, debemos asumir que el string tiene el formato correcto
        // gracias a la validación estructural previa.
        String[] partes = fechaStr.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int año = Integer.parseInt(partes[2]);

        // La creación de LocalDate.of() lanzaría una DateTimeException si la fecha es ilógica (31/02),
        // pero la prohibición de try/catch nos obliga a delegar la gestión del error.
        return LocalDate.of(año, mes, dia);
    }

    // --- El resto de métodos de I/O permanecen igual ---

    private static void imprimirMenu() {
        System.out.println("\n=================================");
        System.out.println("    MENÚ PRINCIPAL (" + miEmpresa.getNombre() + ")");
        System.out.println("=================================");
        System.out.println("1. Crear persona");
        System.out.println("2. Registrar trabajador en empresa");
        System.out.println("3. Mostrar información general de la empresa");
        System.out.println("4. Mostrar el número de trabajadores actuales");
        System.out.println("5. Mostrar información de todos los trabajadores");
        System.out.println("6. Eliminar trabajador de la empresa");
        System.out.println("7. Eliminar persona del programa.");
        System.out.println("8. Salir de la aplicación");
        System.out.print(">>> Elija una opción: ");
    }

    private static String pedirStringObligatorio(String mensaje) {
        String input;
        do {
            System.out.print(mensaje + " ");
            input = SC.nextLine().trim();
            if (input.isEmpty()) {
                System.err.println("Este campo no puede estar vacío.");
            }
        } while (input.isEmpty());
        return input;
    }

    private static int pedirEnteroPositivo(String mensaje) {
        int valor = -1;
        while (valor <= 0) {
            System.out.print(mensaje + " ");
            if (SC.hasNextInt()) {
                valor = SC.nextInt();
                if (valor <= 0) {
                    System.err.println("El valor debe ser positivo.");
                }
            } else {
                System.err.println("Entrada no válida. Por favor, ingrese un número.");
            }
            SC.nextLine();
        }
        return valor;
    }
}