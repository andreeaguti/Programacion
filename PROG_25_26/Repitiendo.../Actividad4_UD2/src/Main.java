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
        //Crea un programa que pida dos valores enteros P y Q, luego cree un array que contenga todos los valores
        //desde P hasta Q, y lo muestre por pantalla.
        System.out.println("Introduce el valor de P");
        int p = sc.nextInt();
        System.out.println("Introduce el valor de Q");
        int q = sc.nextInt();

        int tamano= (q-p)+1;
        int ejercicio7[] = new int[tamano];

        for (int i = 0; i < ejercicio7.length; i++) { //recorro el array desde la posición 0 hasta la última posición del tamaño del array
            ejercicio7[i]=p+i;
        }
        System.out.println(Arrays.toString(ejercicio7)); //muestra por pantalla los array

        //Ejercicio 08
        System.out.println("Ejercicio 08");
        sc = new Scanner(System.in);
        //Crea un programa que cree un array con 100 números reales aleatorios entre 0.0 y 1.0, utilizando
        // Math.random(), y luego le pida al usuario un valor real R. Por último, mostrará cuántos valores del array
        // son igual o superiores a R.

        double[] numerosReales5 = new double[100];

        for (int i = 0; i < numerosReales5.length; i++) {
            numerosReales5[i]=Math.random();
        }
        System.out.println(Arrays.toString(numerosReales5));

        System.out.println("Introduce un valor R");
        int r = sc.nextInt();
        int contadorMayores = 0;
        int contadorMenores = 0;
        for (int i = 0; i < numerosReales5.length; i++) {
            if (numerosReales5[i] >= r) {
                contadorMayores++;
            }else  {
                contadorMenores++;
            }
        }
        System.out.println("Hay " + contadorMayores + "numeros mayores que R");
        System.out.println("Hay " + contadorMenores + "numeros menores que R");

        //Ejercicio 09
        System.out.println("Ejercicio 09");
        sc = new Scanner(System.in);
        //Crea un programa que cree un array de enteros de tamaño 100 y lo rellene con valores enteros aleatorios
        // entre 1 y 10 (utiliza 1 + Math.random()*10). Luego pedirá un valor N y mostrará en qué posiciones del
        // array aparece N.
        int[] numerosReales6 = new int[100];

        for (int i = 0; i < numerosReales6.length; i++) {
            numerosReales6[i]=(int) (Math.random()*10+1);
            //Math.random() da un decimal entre 0 y 1. Al multiplicar por 10 y sumar 1, y luego convertir a (int),
            //obtienes un número entero entre 1 y 10. Este número se guarda en la posición i.
        }
        System.out.println("Introduce un valor del 1 al 10");
        int valor1 = sc.nextInt();
        //recorro el array
        for (int i = 0; i < numerosReales6.length; i++) { //recorro el array desde la posición 0 hasta la última posición del tamaño del array
           if (valor1 == numerosReales6[i]) {
               System.out.println("N aparece en la posicion: " +i);
           }
        }
        //Ejercicio 10
        System.out.println("Ejercicio 10");
        sc = new Scanner(System.in);

        //Crea un programa para realizar cálculos relacionados con la altura (en metros) de personas. Pedirá un valor N
        //y luego almacenará en un array N alturas introducidas por teclado. Luego mostrará la altura media,
        // máxima y mínima, así como cuántas personas miden por encima y por debajo de la media.
        System.out.println("Introduce el valor de N");
        int alturas = sc.nextInt();

        double[] ejercicio10 = new double[alturas];

        //creo las variables
        double sumaAlturas = 0.0;
        double maxima = -Double.MAX_VALUE; //inicializa la variable "max", con el valor más pequeño que puede guardar un double
        //porque cualquier número que se introduzca, será mayor que este mínimo
        double minima = Double.MAX_VALUE;// inicializa "min" con el valor más grande posible
        //cualquier número que el usuario escriba sera menor que este
        int contadorMas=0; //??
        int contadorMenos=0;
        for (int i = 0; i < ejercicio10.length; i++) { //recorro el array desde la posición 0 hasta la última posición del tamaño del array
            System.out.println("Introduzca la altura de la persona: " + (i+1) + ": ");
            ejercicio10[i] = sc.nextDouble(); //coge el número que el usuario escribe y lo guarda en la posición del array
            sumaAlturas += ejercicio10[i]; //suma
        }
        double mediaAltura = sumaAlturas/ejercicio10.length;
        System.out.println("La media es: " + mediaAltura);
        //bucle para buscar el máximo y el mínimo
        for (int i = 0; i < ejercicio10.length; i++) {
            maxima = Math.max (ejercicio10[i], maxima); //compara el número actual del array con el valor que tenemos guardado en max, se queda con el mas grande
            //lo va comparando con todos los numeros del array
            minima = Math.min (ejercicio10[i], minima); //compara el número actual con el min guardado y se queda con el más pequeño de los dos
        }
        System.out.println("La media es: " + mediaAltura);
        System.out.println("El más bajo es: " + minima);
        System.out.println("El más alto es: " + maxima);

        //recorro el array
        for (int i = 0; i < ejercicio10.length; i++) { //recorro el array desde la posición 0 hasta la última posición del tamaño del array
            if (ejercicio10[i] >= mediaAltura) {
                contadorMas++;
            }else {
                contadorMenos++;
            }
        }
        System.out.println("Hay " + contadorMas + " personas que miden mas de la media");
        System.out.println("Hay " + contadorMenos + " personas que miden menos de la media");

        //Ejercicio 11
        System.out.println("Ejercicio 11");
        sc = new Scanner(System.in);

        //Crea un programa que cree dos arrays de enteros de tamaño 100. Luego introducirá en el primer array todos
        //los valores del 1 al 100. Por último, deberá copiar todos los valores del primer array al segundo array
        // en orden inverso, y mostrar ambos por pantalla.
        int [] array1 = new int[100];
        int [] array2 = new int[100];

        for (int i = 0; i < array1.length; i++) {
            array1[i] = i + 1; //guardo los numeros, la i empieza en 0, pongo el +1 para que empiece en 1
    }
        for (int i = 0; i < array2.length; i++) {
            array2[i] = array1[(array1.length-1) -i];
            //array1.length -1, va a ser 99 (la ultima posicion)
        }
        System.out.println(Arrays.toString(array1)); //muestro los array
        System.out.println(Arrays.toString(array2));




    }
}