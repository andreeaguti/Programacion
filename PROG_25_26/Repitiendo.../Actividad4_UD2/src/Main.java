import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Ejercicio 01
        System.out.println("Ejercicio 01");
        //Crea un programa que pida diez números reales por teclado, los almacene en un array,
        // y luego muestre todos sus valores.
        double[] numerosReales = new double[10];
        //inicia un bucle for para recorrer el array
        for (int i = 0; i < numerosReales.length; i++) {
            System.out.println("Ingrese diez numeros reales:");
            numerosReales[i] = sc.nextDouble(); //asigna cada número a la posición i del array, es decir, el primer número lo guarda en la posición 0
        }
        System.out.println(Arrays.toString(numerosReales));
        // Arrays.toString es un metodo que convierte el contenido de un array en texto legible

        //Ejercicio 02
        System.out.println("Ejercicio 02");
        sc = new Scanner(System.in);

        double[] numerosReales1 = new double[10];
        double suma = 0.0; //creo una variable para sumar

        for (int i = 0; i < numerosReales1.length; i++) {
            System.out.println("Introduce el numero real " + (i+1) + ": ");
            numerosReales1[i] = sc.nextDouble(); //coge el número que el usuario escribe y lo guarda en la posición del array
            suma += numerosReales1[i]; //es lo mismo que suma = suma + numerosReales[i]
        }

        System.out.println("La suma es: " + suma);

        //Ejercicio 03
        System.out.println("Ejercicio 03");
        sc = new Scanner(System.in);

        double[] numerosReales2 = new double[10];

        for (int i = 0; i < numerosReales1.length; i++) {
            System.out.println("Introduce el numero real " + (i+1) + ": ");
            numerosReales2[i] = sc.nextDouble(); //coge el número que el usuario escribe y lo guarda en la posición del array
        }
        System.out.println(Arrays.toString(numerosReales2));
        











    }
}