import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
/** Ejercicio:
 Una empresa de comida rápida ha realizado una encuesta de satisfacción a 50
 clientes. Les ha pedido que valoren su comida con una puntuación del 1 al 5
 (siendo 1 "Muy mala" y 5 "Excelente").
 Simula las respuestas de la encuesta y muestra los resultados.
 Crea un array int[] valoraciones de tamaño 5 para contar cuántos clientes
 han dado cada puntuación.
 Usa un bucle que se repita 50 veces (los 50 clientes).
 En cada vuelta, genera una valoración aleatoria entre 1 y 5.
 Incrementa la posición correcta del array valoraciones (recuerda el truco
 del índice valor - 1).
 Al final, muestra los resultados:
 Cuántos votos ha tenido cada puntuación.**/

//Creo el array que necesito
   int[] puntuaciones = new int[5];
        double sumaTotal = 0;
//creo un buble para los 50 clientes

   for(int i = 0; i < 50; i++){
    int valoracion = rand.nextInt(5) + 1;
        if (valoracion == 1){
            puntuaciones[0]++;
            }else if (valoracion == 2){
            puntuaciones[1]++;
            }else if (valoracion == 3){
            puntuaciones[2]++;
            }else if (valoracion == 4){
            puntuaciones[3]++;
            }else if (valoracion == 5){
            puntuaciones[4]++;

        }
        }
//Muestro el resultado recorriendo un array
        for(int i = 0; i < puntuaciones.length; i++){
        System.out.println("Valoracion " + (i + 1) + " ha tenido " + puntuaciones[i]+ " votos");
        }





    }
}