import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

//Explicacion del juego al usuario
sc = new Scanner(System.in);
System.out.println("Estas en el juego Piedra, Papel o Tijera");
System.out.println("Intrucciones del juego:");
System.out.println("P = Piedra");
System.out.println("L = Papel");
System.out.println("T = Tijera");
System.out.println("S = Salir del juego");


//Declaro las variables
String piedra = "P";
String papel = "L";
String tijera = "T";
String salir = "S";

String [] jugadas = {"P","L","T"}; //array

String jugadaUsuario;

//como mejora añado un contador que diga las victorias de cada uno
int victoriasUsuario = 0;
int victoriasOrdenador = 0;
int empates = 0;

//bucle do-while y condicion if-else
do{

    int Aleatorio = random.nextInt(jugadas.length);
    String jugadaOrdenador = jugadas[Aleatorio];

    System.out.println("Elije tu jugada (P,L,T o S para salir)");
    jugadaUsuario = sc.next().toUpperCase(); // lo pasamos a mayusculas porque nuestro usuario es tonto

    if(jugadaUsuario.equals(salir)){
        System.out.println("Saliendo del juego...");

        }else if (jugadaUsuario.equals(piedra) || jugadaUsuario.equals(papel)||jugadaUsuario.equals(tijera) ){
        System.out.println("Jugada del usuario:" + jugadaUsuario);
        System.out.println("Jugada del ordenador: " + jugadaOrdenador);

            if (jugadaUsuario.equals(jugadaOrdenador)){
                System.out.println("¡EMPATE!");
                empates++;
            }else if (jugadaUsuario.equals(papel) && jugadaOrdenador.equals(piedra)){
                System.out.println("¡GANASTE!");
                victoriasUsuario++;
            }else if (jugadaUsuario.equals(piedra) && jugadaOrdenador.equals(tijera)){
                System.out.println("¡GANASTE!");
                victoriasUsuario++;
            }else if (jugadaUsuario.equals(tijera) && jugadaOrdenador.equals(papel)){
                System.out.println("¡GANASTE!");
                victoriasUsuario++;
            }else {
                System.out.println("¡PERDISTE!");
                victoriasOrdenador++;
            }
    }else {
        System.out.println("Jugada no valida, introduce P, L, T o S para salir");
    }

} while (!jugadaUsuario.equals(salir));

//Muestro el contador
        System.out.println("Victorias del usuario: " + victoriasUsuario);
        System.out.println("Victorias del ordenador: " + victoriasOrdenador);
        System.out.println("Empates: " + empates);

    }
}