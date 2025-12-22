import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

 Scanner sc = new Scanner(System.in);

//Ejercicio 01: Mostrar los valores de un array
/* Crea un programa que:
   Tenga un array con 5 números enteros.
   Muestre todos sus valores por pantalla.
💡 Pista: usa un for para recorrer el array */

System.out.println("Actividad 01");

int numeros[] = new int[]{5,7,3,6,4};

for (int i = 0; i < numeros.length; i++){
    System.out.println("Numero en posicion " + i + ":" + numeros[i]);
}
//Ejercicio 02: Calcular la suma de todos los elementos
       /* Crea un programa que:
        Tenga un array con estos números: {3, 6, 2, 8, 9}.B
        Calcule y muestre la suma total de todos los elementos del array.
💡 Pista: declara una variable suma que empiece en 0 y ve sumando dentro del bucle. */
System.out.println("Actividad 02");
int num[] = new int[]{3,6,2,8,9};

int suma = 0;
for (int i =0; i < num.length; i++){
    suma += num[i];
}
System.out.println("La suma es: " + suma);

//Ejercicio 03: Calcular la media de notas
/* Crea un programa que:
Guarde en un array las notas {7, 8, 5, 9, 6}.
Calcule la media de todas las notas.
Muestre el resultado.*/
System.out.println("Actividad 03");

int notas [] = new int[]{7,8,5,9,6};
int sumaNotas = 0;
int media;

for(int i = 0; i < notas.length; i++){
    sumaNotas += notas[i];
}
media = sumaNotas / notas.length;
System.out.println("La media es: " + media);

//Ejercicio 04: Mostrar el numero mayor
/*Crea un programa que:
Guarde los números {10, 3, 25, 7, 14}.
Encuentre cuál es el mayor número y lo muestre por pantalla.
💡 Pista: usa una variable mayor para ir comparando. */
System.out.println("Actividad 04");
int number[]= new int[]{10,3,25,7,14};
int mayor = number[0]; //Significa que empieza con el primer valor

for (int i = 1; i < number.length; i++) {
    if (number[i] > mayor) {
        mayor = number[i];
    }
}
System.out.println("El numero mayor es: " + mayor);


//Ejercicio 05: Pedir datos al usuario
/*Pida al usuario 5 números enteros y los guarde en un array.
Luego muestre todos los números introducidos. */

System.out.println("Actividad 05");
sc =  new Scanner(System.in);

int[] num2 = new int[5]; // array de 5 posiciones

// Pedimos los números
for (int i = 0; i < num2.length; i++) {
    System.out.print("Introduce un número para la posición " + i + ": ");
    num2[i] = sc.nextInt();
}
// Mostramos los números introducidos
System.out.println("\nLos números que has introducido son:");
for (int i = 0; i < num2.length; i++) {
     System.out.println("Posición " + i + ": " + num2[i]);
     }









    }
}