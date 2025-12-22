import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
/*Cuando se conoce el número de veces que ha de repetirse el bloque de instrucciones.
for (inicialización ; condición ; incremento)
{
Bloque de acciones (System.out.println(“Numero: ” + i))
}
Inicialización: empieza en x numero. int i = 1;
Condición: hasta cuando lo repite. i <= 10;
Incremento: cuanto suma cada vez. i++;
*/

//Ejercicio 01: Numeros del 1 al 10
        System.out.println("Ejercicio 01");
        sc = new Scanner(System.in);

        for (int i = 0; i <= 10; i++){
            System.out.println("Numero:" + i);
        }
//Ejercicio 02: Numeros pares del 1 al 20
        System.out.println("Ejercicio 02");
//sc = new Scanner(System.in) --> no hace falta porque no lo usamos en este ejercicio

        for (int i = 0; i<= 20; i+=2){
            System.out.println("Numero:" + i);
        }
//Ejercicio 03: Suma de los primeros 10 numeros.
        System.out.println("Ejercicio 03");

        int suma = 0;

        for (int i = 1; i <= 10; i++){
            suma = suma + i;
        }
        System.out.println("La suma de los 10 primeros numeros es: " + suma);

//Ejercicio 04: Tabla de multiplicar.
        System.out.println("Ejercicio 04");

        System.out.println("Introduce un numero:" );
        int numero = sc.nextInt();

        for (int i =1; i<=10; i++){
            System.out.println(numero + "*" + i + "=" + (numero*i));
        }

//Ejercicio 05: Contador hacia atras.
        System.out.println("Ejercicio 05");

        for (int i = 10; i >= 0; i --){
            System.out.println("Numero:" + i);
        }









    }
}