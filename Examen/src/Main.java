import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

//Creo las variables necesarias

String modificar = "A";
String estadisticas = "B";
String ampliarValor = "C";
String salir = "S";

String [] opciones = {"A","B","C","S"};


//Explicacion del programa

System.out.println("Debe introducir una cantidad de numeros a almacenar ");

String opcionUsuario;

//PEDIR CANTIDAD TOTAL DE NUMEROS

        System.out.println("Introduzca cuantos numeros desea almacenar:");
        int numerosAlmacenar = sc.nextInt();

//Creo un array que pida la cantidad total de numeros y pida los numeros que desea almacenar.

        int[] cantidad = new int[numerosAlmacenar];
        int suma = 0; //Para hacer la suma
        int max = Integer.MIN_VALUE,   min = Integer.MAX_VALUE; //Para sacar el max y el min
        int media = 0; //Para hacer la media

        for (int i = 0; i < cantidad.length; i++) {
            System.out.println("Introduce el numero en la posición " + (i+1) + ": ");
            cantidad [i] = sc.nextInt();
        }

//Explicacion al usuario de lo que las opciones que puede elegir

        System.out.println(Arrays.toString(cantidad));

        System.out.println("Podrá elegir entre las siguientes opciones:");
        System.out.println("A. Modificar colección");
        System.out.println("B. Mostrar estadísticas de la colección");
        System.out.println("C. Ampliar el valor de la colección");
        System.out.println("S. Introduce una S si desea abandonar el programa");

do {
    System.out.println("Elija la opción que desee (A, B, C o S para salir)");
    opcionUsuario = sc.next().toUpperCase();

    if (opcionUsuario.equals(salir)) {
        System.out.println("Saliendo del programa...");


    } else if (opcionUsuario.equals(modificar)) {
        System.out.println("Podrá realizar las siguientes modificaciones:");
        System.out.println("1. Insertar número");
        System.out.println("2. Borrar número");
        System.out.println("3. Modificar número de una posición específica");

    }
    else if (opcionUsuario.equals(estadisticas)) {
        for (int i = 0; i < cantidad.length; i++) {
            suma += cantidad[i];
        }for (int i = 0; i < cantidad.length; i++) {
            max = Math.max(cantidad[i], max);
            min = Math.min(cantidad[i], min);
        }
        media = suma/ cantidad.length;

        System.out.println("La media de los numeros es: " + media);
        System.out.println("La suma es: " + suma);
        System.out.println("El numero máximo es: " + max);
        System.out.println("El numero minimo es: " + min);

    }else if (opcionUsuario.equals(ampliarValor)) {
        System.out.println("Ampliando el valor...");
    }

}while(!opcionUsuario.equals(salir));

    }
}




