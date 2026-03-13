import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Empresa {
    private String nombreEmpresa;
    private String cif;
    private LocalDate fechaFundacion;

    private static ArrayList<Trabajador> trabajadores;
    private ArrayList<GerenteDep> gerentes;
    private ArrayList<Director> director;

    public static int contadorGerentes = 0;
    public static int contadorDirectores = 0;

    public Empresa(String nombreEmpresa, String cif, LocalDate fechaFundacion) {
        this.nombreEmpresa = nombreEmpresa;
        this.cif = cif;
        this.fechaFundacion = LocalDate.now();
        this.trabajadores = new ArrayList<>();
        this.gerentes = new ArrayList<>();
        this.director = new ArrayList<>();
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getCif() {
        return cif;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public ArrayList<Trabajador> getTrabajadores() {
        return trabajadores;
    }

    public ArrayList<GerenteDep> getGerentes() {
        return gerentes;
    }

    public ArrayList<Director> getDirector() {
        return director;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    //Sobrescribir metodo toString():
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Empresa{");
        sb.append("nombreEmpresa='").append(nombreEmpresa).append('\'');
        sb.append(", cif='").append(cif).append('\'');
        sb.append(", fechaFundacion=").append(fechaFundacion);
        sb.append(", trabajadores=").append(trabajadores);
        sb.append(", gerentes=").append(gerentes);
        sb.append(", director=").append(director);
        sb.append('}');
        return sb.toString();
    }

    //MOSTRAR INFORMACION TRABAJADORES
    public String mostrarInformacionTrabajadores() {
        String listado = "TRABAJADORES EN LA EMPRESA:\n";
        if (trabajadores.isEmpty()) {
            listado += "No hay trabajadores en la empresa\n";
        }else {
            for (Trabajador t : trabajadores) {
                listado += t.toString()+ "\n";
            }
        }
        return listado;
    }


    //METODO PARA REGISTRAR TRABAJADOR
    public boolean registrarTrabajador(Trabajador t) {
        //Antes de registrarle, recorro la lista, para comprobar que no haya un DNI igual
        for (Trabajador trabajador: trabajadores) {
            if (trabajador.getDni().equals(t.getDni())) {
                throw new IllegalArgumentException("El DNI que acaba de introducir ya existe en esta empresa.");
            }
        }
        return trabajadores.add(t);
    }

//METODO PARA REGISTRAR GERENTE
    public boolean registrarGerente(GerenteDep g) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el DNI del Gerente");
        String dni = sc.nextLine();
        for (Trabajador trabajador: gerentes) {
            if (trabajador.getDni().equals(dni)) {
                throw new IllegalArgumentException("El DNI que acaba de introducir ya existe en esta empresa.");
            }else if (contadorGerentes > 3){
                System.err.println("Cupos de gerentes llenos");
            }
        }
        contadorGerentes++;
        return gerentes.add(g);
    }

//METOO PARA REGISTRAR AL DIRECTOR.
    public boolean registrarDirector(Director d) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el DNI del Director");
        String dni = sc.nextLine();
        for (Trabajador trabajador: director) {
            if (trabajador.getDni().equals(dni)) {
                throw new IllegalArgumentException("El DNI que acaba de introducir ya existe en esta empresa.");
            }
        }
        return director.add(d);
    }


    //METODO PARA ELIMINAR EL TRABAJADOR POR DNI
    public static void eliminarTrabajador(String dniBaja) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el DNI del trabajador que desea eliminar: ");
        String dni = sc.nextLine();

        Trabajador tAux= null;

        for(Trabajador trabajadorAux : trabajadores){
            if(trabajadorAux.getDni().equals(dni)){
                tAux = trabajadorAux;
                break;
            }
        }if(tAux != null){
            trabajadores.remove(tAux);
            System.out.println("Trabajador eliminado correctamente.");
        }else {
            throw new Exception("No existe el trabajador con el dni: " + dni);
        }
    }

    // MeTODO PARA GUARDAR EN TEXTO PLANO
    public void guardarTrabajadoresTXT(String nombreFichero) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreFichero))) {
            for (Trabajador a : trabajadores) {
                // Identificamos el tipo para saber cómo reconstruirlo luego
                String tipo = (a instanceof Director) ? "DIRECTOR" : "GERENTE";

                pw.print(tipo + ";" + a.getNombre() + ";" + a.getFechaNacimiento() + ";" + a.getDni() + ";" + a.getDireccion());

                // Si es Película, añadimos su género
                if (a instanceof Director) {
                    pw.print(";" + ((Director) a).getNumTelefono());
                }
                // Si es Videojuego, añadimos plataforma y su género específico
                else if (a instanceof GerenteDep) {
                    pw.print(";" + ((GerenteDep) a).getGerencia() + ";" + ((GerenteDep) a).getTrabajadores().size() + ";");
                }
                pw.println(); // Salto de línea para el siguiente artículo
            }
        }
    }

    public void cargarArticulosTXT(String nombreFichero) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreFichero))) {
            String linea;
            this.getTrabajadores().clear();

            while ((linea = br.readLine()) != null) {
                String[] d = linea.split(";");
                String tipo = d[0];
                String nombre = d[1];
                String numeroSS = d[2];
                int salario = Integer.parseInt(d[3]);
                boolean isCoche = Boolean.parseBoolean(d[4]);

                if (tipo.equals("DIRECTOR")) {
                    int numeroTelefono = Integer.parseInt(d[4]);
                    Director d = new Director(numeroTelefono);
                    d.setCoche(isCoche);

                } else {
                    Gerencia gerencia = Gerencia.valueOf(d[5]);
                }
            }
        }
    }


}
