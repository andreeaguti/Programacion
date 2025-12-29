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

        double[] numerosReales1 = new double[10]; //creo el array con 10 espacios
        double suma = 0.0; //creo una variable para sumar

        for (int i = 0; i < numerosReales1.length; i++) { //recorro el array desde la posición 0 hasta la última posición del tamaño del array
            System.out.println("Introduce el numero real " + (i+1) + ": ");
            numerosReales1[i] = sc.nextDouble(); //coge el número que el usuario escribe y lo guarda en la posición del array
            suma += numerosReales1[i]; //es lo mismo que suma = suma + numerosReales[i]
        }

        System.out.println("La suma es: " + suma);


        //Ejercicio 03
        System.out.println("Ejercicio 03");
        sc = new Scanner(System.in);
        //Crea un programa que pida diez números reales por teclado, los almacene en un array, y luego lo recorra para
        //averiguar el máximo y mínimo y mostrarlos por pantalla.
        double[] numerosReales2 = new double[10]; //creo array con capacidad para 10 numeros
        //creo las variables
        double max = -Double.MAX_VALUE; //inicializa la variable "max", con el valor más pequeño que puede guardar un double
        //porque cualquier numero que se introduzca, será mayor que este mínimo
        double min = Double.MAX_VALUE;// inicializa "min" con el valor más grande posible
        //cualquier numero que el usuario escriba sera menor que este

        //bucle para llenar el array
        for (int i = 0; i < numerosReales1.length; i++) { //recorro el array desde la posición 0 hasta la última posición del tamaño del array
            System.out.println("Introduce el numero real " + (i+1) + ": ");
            numerosReales2[i] = sc.nextDouble(); //coge el número que el usuario escribe y lo guarda en la posición del array
        }
        //bucle para buscar el máximo y el mínimo
        for (int i = 0; i < numerosReales2.length; i++) {
            max = Math.max (numerosReales2[i], max); //compara el número actual del array con el valor que tenemos guardado en max, se queda con el mas grande
            //lo va comparando con todos los numeros del array
            min = Math.min (numerosReales2[i], min); //compara el número actual con el min guardado y se queda con el más pequeño de los dos
        }
        System.out.println("El más pequeño es: " + min);
        System.out.println("El más grande es: " + max);

        //Ejercicio 04
        System.out.println("Ejercicio 04");
        sc = new Scanner(System.in);
        //Crea un programa que pida veinte números enteros por teclado, los almacene en un array y luego muestre por
        //separado la suma de todos los valores positivos y negativos.
        double[] numerosReales3 = new double[20]; //creo el array
        double sumaPositivos = 0.0; //variable para suma de positivos
        double sumaNegativos = 0.0; //variable para suma de negativos

        for (int i = 0; i < numerosReales3.length; i++) {
            System.out.println("Introduce el numero real " + (i+1) + ": ");
            numerosReales3[i] = sc.nextDouble(); //coge el número que el usuario escribe y lo guarda en la posición del array
            if (numerosReales3[i] >= 0 ) {
                sumaPositivos += numerosReales3[i];
            }else {
                sumaNegativos += numerosReales3[i];
            }
        }
        System.out.println("La suma de los positivos es: " + sumaPositivos);
        System.out.println("La suma de los negativos es: " + sumaNegativos);

        //Ejercicio 05
        System.out.println("Ejercicio 05");
        sc = new Scanner(System.in);

//Crea un programa que pida veinte números reales por teclado, los almacene en un array y luego lo recorra para
//calcular y mostrar la media: (suma de valores) / nº de valores.

        double[] numerosReales4 = new double[2];//creo el array

        double sumaValores = 0.0;
        for (int i = 0; i < numerosReales4.length; i++) { //recorro el array desde la posición 0 hasta la última posición del tamaño del array
            System.out.println("Introduce el numero real " + (i+1) + ": ");
            numerosReales4[i] = sc.nextDouble(); //coge el número que el usuario escribe y lo guarda en la posición del array
            sumaValores += numerosReales4[i]; //suma
        }
        double media = sumaValores/numerosReales4.length;
        System.out.println("La media es: " + media);

        //Ejercicio 06
        System.out.println("Ejercicio 06");
        sc = new Scanner(System.in);
        //Crea un programa que pida dos valores enteros N y M, luego cree un array de tamaño N, escriba M en todas
        // sus posiciones y lo muestre por pantalla.
        System.out.println("Introduce el tamaño del array");
        int n = sc.nextInt();
        System.out.println("Introduce el valor del array");
        int m = sc.nextInt();

        double array[] = new double[n];
        Arrays.fill(array, m); //asigna el valor M a el array entero
        System.out.println(Arrays.toString(array)); //enseñamos lo que hay dentro del array

        //Ejercicio 07
        System.out.println("Ejercicio 07");
        sc = new Scanner(System.in);
    }
}