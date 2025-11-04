import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

/** Enunciado: Crea un programa que:
 Pida al usuario cuántas notas quiere introducir (por ejemplo, 5).
 Cree un array (double[]) de ese tamaño.
 Pida al usuario que introduzca todas las notas una por una usando un bucle.
 Calcule y muestre al final:
 La nota media (promedio).
 La nota más alta.
 La nota más baja.
**/
//Creo las variables, arrays
System.out.println("Cuantas notas desea introducir?");
int cantidad = sc.nextInt();

double [] notas = new double[cantidad];

for (int i = 0; i < notas.length; i++) {
    System.out.println("Introduce la nota nº " + (i +1 + ":"));
    double notaActual = sc.nextDouble();
    notas[i] = notaActual; //guardo esa nota en la posicion "i" del array

}
//variables para calcular lo que pide el ejercicio
double notaMedia = 0;
double notaMasAlta = 0;
double notaMasBaja = 10;

for (int i = 0; i < notas.length; i++) {
    double nota =  notas[i];
    notaMedia += nota;
        if (nota > notaMasAlta) {
            notaMasAlta = nota;
    }if (nota < notaMasBaja) {
            notaMasBaja = nota;
    }
}
  double media = notaMedia / notas.length;

  System.out.println("La notas mas alta es: " + notaMasAlta);
  System.out.println("La nota mas baja es: " + notaMasBaja);
  System.out.println("La nota media es de: " + media);

    }
}