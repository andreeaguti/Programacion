
public class Main {
    public static void main(String[] args) {

        Astros astros = new Astros(19890000000.0, 139.200, 35.6, 150.0, 1295.7);
        System.out.println("Mostramos un astro");
        astros.mostrarAstros();

        Planeta planeta = new Planeta(12120125, 56, 56, 89, 129, 74, 99, true);
        System.out.println("Mostramos un planeta");
        planeta.mostrarAstros();

        Satelites satelites = new Satelites(456.0, 89.0, 47.0, 10.0, 5.0, // Parámetros de Astros
                50000.0, 3000.0, "Tierra");
        System.out.println("Mostramos un planeta");
        satelites.mostrarAstros();
    }
}