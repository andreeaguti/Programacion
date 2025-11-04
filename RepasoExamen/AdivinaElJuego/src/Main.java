import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
Random rand = new Random();

/** Enunciado:
 Crea un programa que:
 1.	Genere un número aleatorio entre 1 y 100.
 2.	Pida al jugador que intente adivinarlo.
 3.	Tras cada intento, indique si el número a adivinar es mayor o menor que el introducido.
 4.	Cuando el jugador acierte, mostrará el número de intentos usados.
 5.	El juego termina cuando acierta o cuando lleva 10 intentos. **/

//Preparo las constantes y variables
int maxIntentos = 10; //numero de intentos
int numeroSecreto = rand.nextInt(100) + 1; // para que sea del 1 al 100
int contador = 0; // contador de los intentos
boolean acertado = false;
int intento;
//Instrucciones del juego al usuario
        System.out.println("Estas en el juego adivina el numero");
        System.out.println("Tienes que adivinar el numero entre el 1 y el 100");
        System.out.println("Tienes " + maxIntentos + " intentos para adivinarlo");

// bucle while y condicion
while (!acertado && contador < maxIntentos) {
    System.out.println("Introduzca el numero:");
    intento = sc.nextInt();
    contador++;

    if (intento == numeroSecreto) {
        acertado = true;
    } else if (intento > numeroSecreto ) {
        System.out.println("El numero secreto es mas pequeño");
    }else if (intento < numeroSecreto){
        System.out.println("El numero secreto es mas mayor");
    }
}
if (acertado) {
    System.out.println("Has acertado el numero secreto en " + contador + " intentos ");
} else {
    System.out.println("Has agotado los" + maxIntentos + " intentos para adivinarlo" );
    System.out.println("El numero secreto era: " + numeroSecreto);
}

 }
}