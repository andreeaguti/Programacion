import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

/*Ejercicio 01:Crea un programa que cree una matriz de tamaño 5x5 que almacene los números
del 1 al 25 y luego muestre la matriz por pantalla. */
System.out.println("Actividad 01");
sc = new Scanner(System.in);

int matriz[][] = new int[5][5];
int numeros = 1; //valor inicial


        for (int i = 0; i < matriz.length; i++) { //aqui rellenamos las filas
            for (int j = 0; j < matriz[i].length ; j++) { //aqui rellenamos las columnas
                matriz[i][j] = numeros; //numero actual
                numeros++; //aumentamos el numero
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

/* Ejercicio 02: Crea un programa que cree una matriz de 10x10 e introduzca los valores
 de las tablas de multiplicar del 1 al 10 (cada tabla en una fila).
 Luego mostrará la matriz por pantalla. */
System.out.println("Actividad 02");
sc = new Scanner(System.in);

int tabla[][] = new int[10][10];

for (int i = 0; i < tabla.length; i++) { //fila
    for (int j = 0; j < tabla[i].length; j++) { //columna
        tabla[i][j] = (i + 1) * (j + 1);
        System.out.print(tabla[i][j] + " ");
    }
    System.out.println(); //Este buvle for hay que hacerle siempre para recorre un array
}

/*Ejercicio 03:Crea un programa que cree una matriz de tamaño NxM (tamaño introducido por teclado) e introduzca en ella
NxM valores (también introducidos por teclado). Luego deberá recorrer la matriz y al final mostrar por pantalla cuántos
valores son mayores que cero, cuántos son menores que cero y cuántos son igual a cero.*/
System.out.println("Actividad 03");
sc = new Scanner(System.in);

double[][] matriz3;

System.out.println("Introduce el numero de filas (N): ");
int filas = sc.nextInt();
System.out.println("Introduce el numero de columnas (M): ");
int columnas = sc.nextInt();

if(n >0 && m>0){
    matriz3 = new double[n][m];

    int nPositivos = 0, nNegativos = 0, nNulos = 0;
    for (int i = 0; i < matriz3.length; i++) {
    for (int j = 0; j < matriz3[i].length; j++) {

    System.out.println("Ingrese el valor i= " + i + " j= "+j);
    double valor = sc.nextDouble();
    matriz3[i][j] = valor;

         if(valor == 0){
            nNulos++;
             }else if(valor > 0){
                nPositivos++;

                }else {
                   nNegativos++;
                    }
                }
            }

            for (int i = 0; i < matriz3.length; i++) {
                for (int j = 0; j < matriz3[i].length; j++) {
                    System.out.print(matriz3[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("Hay "+nPositivos + " valores positivos en la matriz");
            System.out.println("Hay "+nNegativos + " valores negativos en la matriz");
            System.out.println("Hay "+nNulos + " valores nulos en la matriz");
        }
        else{
            System.out.print("Las dimensiones deben de ser positivas");
        }


/* Ejercicio 04: Necesitamos crear un programa para almacenar las notas de
4 alumnos (llamados “Alumno 1”, “Alumno 2”, etc.) y 5 asignaturas.
El usuario introducirá las notas por teclado y luego el programa mostrará
la nota mínima, máxima y media de cada alumno.*/
System.out.println("Actividad 04");
sc = new Scanner(System.in);

double[][]notas = new double[4][5];

System.out.println("Introduce los valores de las notas: ");
   for (int i = 0; i < 4; i++) {
       System.out.print("Alumno" + (i+1));
      for (int j = 0; j < 5; j++) {
          System.out.print("Nota de la asignatura" + (j+1)+ ":");
          notas[i][j] = sc.nextDouble();
      }
   }
for (int i = 0; i < 4; i++) {
    double suma = 0;
    double max = notas[i][0];
    double min = notas[i][0];

    for (int j = 0; j < 5; j++) {
        double nota = notas[i][j];
        suma += nota;
        if (nota > max) {
            max = nota;
    }
        if (nota < min) {
            min = nota;
    }
    }
double media = suma / 5;
    System.out.println("\nAlumno " + (i + 1) + ":");
    System.out.println("Nota mínima: " + min);
    System.out.println("Nota máxima: " + max);
    System.out.println("Nota media: " + media);

}
/*Ejercicio 05: Necesitamos crear un programa para registrar sueldos de
hombres y mujeres de una empresa y detectar si existe brecha salarial
entre ambos. El programa pedirá por teclado la información de N personas
distintas (valor también introducido por teclado). Para cada persona,
pedirá su género (0 para varón y 1 para mujer) y su sueldo.
Esta información debe guardarse en una única matriz. Luego se mostrará
 por pantalla el sueldo medio de cada género.
 */
System.out.println("Actividad 05");
sc = new Scanner(System.in);

int personas = 0;

double[][] matriz2 = new double;








    }
}