import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();



//Creo las variables
String piedra = "P";
String papel = "L";
String tijera = "T";
String salir = "S";

String [] jugadas = {"P","L","T"}; //Creo un array

String jugadaUsuario;
//como mejora pongo que el maximo de jugadas sea 10, el programa finaliza jugando 10 veces  o pulasndo s
int maxJugadas = 10;
int intento = 0;

//Explicacion del juego al usuario
        sc = new Scanner(System.in);
        System.out.println("Estas en el juego Piedra, Papel o Tijera");
        System.out.println("Intrucciones del juego:");
        System.out.println("P = Piedra");
        System.out.println("L = Papel");
        System.out.println("T = Tijera");
        System.out.println("Dispones de " + maxJugadas + " jugadas o pulsa S = Salir del juego");

//como mejora añado un contador que diga las victorias de cada jugador y las veces que han empatado
int victoriasUsuario = 0;
int victoriasOrdenador = 0;
int empates = 0;

//bucle do-while y condicion if-else
do{
    int Aleatorio = random.nextInt(jugadas.length);
    String jugadaOrdenador = jugadas[Aleatorio];

    System.out.println("Elije tu jugada (P,L,T o S para salir):");
    jugadaUsuario = sc.next().toUpperCase(); // Lo pasamos a mayusculas


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
            intento++;
    }else {
        System.out.println("Jugada no valida, introduce P, L, T o S para salir");
    }

} while (!jugadaUsuario.equals(salir) && intento < maxJugadas);

//Al final muestro el contador con las jugadas
        System.out.println("Victorias del usuario: " + victoriasUsuario);
        System.out.println("Victorias del ordenador: " + victoriasOrdenador);
        System.out.println("Empates: " + empates);

    }
}