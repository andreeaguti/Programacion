import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//Ejercicio 01: Contar del 1 al 10
        System.out.println("Ejercicio 01");
        sc = new Scanner(System.in);

        int i = 1;
        while (i <= 10) {
            System.out.println("Numero:" + i);
            i++;
        }


//Ejercicio 03: Pedir un numero hasta que el ususario escriba 0
        System.out.println("Ejercicio 03");
        sc = new Scanner(System.in);

        int numero = -1;
        while (numero != 0) {
            System.out.println("Introduce un numero o 0 para salir:");
            numero = sc.nextInt();
        }
        System.out.println("Programa finalizado");

//Ejercicio 04: Contar cuantos numeros positivos introduce el usuario
        System.out.println("Ejercicio 04");
        sc = new Scanner(System.in);

        int num;
        int contador = 0;

        System.out.print("Introduce un número (0 para terminar): ");
        num = sc.nextInt();

        while (num != 0) { // mientras no sea 0
            if (num > 0) {
                contador++;
            }
            System.out.print("Introduce otro número (0 para terminar): ");
            num = sc.nextInt();
        }
        System.out.println("Has introducido " + contador + " números positivos.");


//Ejercicio 05: Calcular la media de varios numeros

/*Objetivo:
El usuario introduce varios números (positivos o negativos).
Cuando escribe 0, el programa muestra la media de los números introducidos (sin contar el 0).*/

        System.out.println("Ejercicio 05");
        sc = new Scanner(System.in);

        int number;
        int contador2 = 0;
        double suma = 0;

        System.out.print("Introduce un número (0 para terminar): ");
        number = sc.nextInt();

        while (number != 0) { // mientras el número no sea 0
            suma += number;   // se acumula la suma
            contador++;       // se cuenta un número más

            System.out.print("Introduce otro número (0 para terminar): ");
            number = sc.nextInt();
        }
        if (contador > 0) {
            double media = suma / contador;
            System.out.println("La media de los números es: " + media);
        } else {
            System.out.println("No se introdujeron números.");
        }

// EJERCICIOS CON DO-WHILE

//Ejercicio 1: Pedir numeros hasta introducir 0 y contar cuantos numeros se han introducido

            sc = new Scanner(System.in);

            int numero3;
            int contador1 = 0;

            do {
                System.out.print("Introduce un número (0 para terminar): ");
                numero3 = sc.nextInt();

                if (numero3 != 0) {
                    contador1++;
                }

            } while (numero3 != 0);

            System.out.println("Has introducido " + contador1 + " números.");

//Ejercicio 02
            sc = new Scanner(System.in);

            int numeroSecreto = 8;
            int intento;

            do {
                System.out.println("Adivina el numero secreto:");
                intento = sc.nextInt();
                if (intento > numeroSecreto) {
                    System.out.println("Demasiado alto");
                } else if (intento < numeroSecreto) {
                    System.out.println("Demasiado bajo");
                }
            } while (intento != numeroSecreto);

            System.out.println("Correcto el numero secreto era : " + numeroSecreto);

//Ejercicio 03

sc = new Scanner(System.in);

int opcion;

do {
    System.out.println("1. Saludar");
    System.out.println("2. Mostrar fecha");
    System.out.println("3. Salir");
    System.out.println("Elija una opcion");
    opcion = sc.nextInt();

    switch (opcion) {
        case 1:
            System.out.println("Buenos dias!!");
            break;
        case 2:
            System.out.println("Hoy estamos a 27 de octubre de 2025");
            break;
        case 3:
            System.out.println("El programa se va a cerrar");
            break;
        default:
            System.out.println("Numero no valido");
    }
}while (opcion != 3) ;




        }
    }

