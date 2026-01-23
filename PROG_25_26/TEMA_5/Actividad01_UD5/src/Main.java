import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    /*EJERCICIO 1: Implementa un programa que pida al usuario un valor entero A utilizando un nextInt() (de
Scanner) y luego muestre por pantalla el mensaje “Valor introducido: …”. Se deberá tratar la
excepción InputMismatchException que lanza nextInt() cuando no se introduce un entero
válido. En tal caso se mostrará el mensaje “Valor introducido incorrecto”. */
        System.out.println("Ejercicio 01");
        sc = new Scanner(System.in);

        try {
            System.out.println("Introduzca un valor entero 'A' ");
            int valorA = sc.nextInt();
            System.out.println("Valor de A: " + valorA);
        } catch (InputMismatchException e) {
            System.out.println("Valor introducido incorrecto. ");
            System.out.println("Error: " + e.getMessage());
        }

/*EJERCICIO 2: Implementa un programa que pida dos valores int A y B utilizando un nextInt() (de Scanner),
calcule A/B y muestre el resultado por pantalla. Se deberán tratar de forma independiente las
dos posibles excepciones, InputMismatchException y ArithmeticException, mostrando en cada
caso un mensaje de error diferente en cada caso. */
        //InputMisMatchException: Por introducir un nombre NO entero
        //ArithmeticException: Por dividir entre 0
        System.out.println("Ejercicio 02");
        sc = new Scanner(System.in);

        try {
            System.out.println("Introduzca un valor entero 'A' ");
            int valorA = sc.nextInt();
            System.out.println("Introduzca un valor entero 'B' ");
            int valorB = sc.nextInt();
            int division = valorA / valorB;
            System.out.println("Valor division: " + division);
        } catch (InputMismatchException e) {
            System.out.println("¡Tiene que ser un número entero! ");
            System.out.println("Error: " + e.getMessage());
        }catch (ArithmeticException e) {
            System.out.println("No se puede dividir entre 0 ");
            System.out.println("Error: " + e.getMessage());
        }

/*EJERCICIO 3:Implementa un programa que cree un vector tipo double de tamaño 5 y luego, utilizando un
bucle, pida cinco valores por teclado y los introduzca en el vector. Tendrás que manejar la/las
posibles excepciones y seguir pidiendo valores hasta rellenar completamente el vector. */
        System.out.println("Ejercicio 03");
        sc = new Scanner(System.in);

        double[] ejercicio3 = new double[5];


            for (int i = 0; i < ejercicio3.length; i++) {
                try {
                    System.out.println("Introduzca 5 valores para el vector ");
                    ejercicio3[i] = sc.nextDouble();//asigna cada número a la posición i del array, es decir, el primer número lo guarda en la posición 0

                } catch (InputMismatchException e) {
                    sc = new Scanner(System.in);
                    System.out.println("Tiene que tener decimales ");
                    System.out.println("Introduzca 5 valores para el vector ");
                    ejercicio3[i] = sc.nextDouble();//asigna cada número a la posición i del array, es decir, el primer número lo guarda en la posición 0
                }
            }

/*EJERCICIO 4: Implementa un programa con tres funciones:
• void imprimePositivo(int p): Imprime el valor p. Lanza una ‘Exception’ si p < 0
• void imprimeNegativo(int n): Imprime el valor n. Lanza una ‘Exception’ si p >= 0
• La función main para realizar pruebas. Puedes llamar a ambas funciones varias veces
con distintos valores, hacer un bucle para pedir valores por teclado y pasarlos a las
funciones, etc. Maneja las posibles excepciones. */
        System.out.println("Ejercicio 03");
        sc = new Scanner(System.in);












































    }
}