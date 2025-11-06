import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

/** Enunciado:
 Ejercicio 3: Estadísticas de Dados (Arrays)
 Simula el lanzamiento de un dado de 6 caras 1000 veces.
 Usa un array de enteros de tamaño 6 para guardar la cuenta de cuántas veces ha salido
 cada cara (índice 0 para el '1',índice 5 para el '6', etc.).
 Realiza un bucle que itere 1000 veces, generando un número aleatorio del 1 al 6 en
 cada vuelta e incrementando la posición correspondiente del array.
 Al finalizar, muestra los resultados: "El 1 ha salido X veces", "El 2 ha salido Y veces"
 , etc.
 */

//Creo un array para las 6 caras y las variables
    int[] caras = new int[6];

// bucle que itere 1000 veces
    for (int i = 0; i < 1000; i++){
        int dado = rand.nextInt(6) + 1;
        if (dado == 1){
            caras[0]++;
        } else if (dado == 2) {
            caras[1]++;
        }else if (dado == 3) {
            caras[2]++;
        }else if (dado == 4) {
            caras[3]++;
        }else if (dado == 5) {
            caras[4]++;
        }else if (dado == 6) {
            caras[5]++;
        }
    }
//Muestro el resultado recorriendo un array
        for (int i = 0; i < caras.length; i++){
        System.out.println("El " + (i + 1) + " ha salido " + caras[i] + " veces");
        }

    }
}