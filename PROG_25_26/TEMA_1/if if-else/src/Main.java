import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

// Pide un número al usuario y muestra si es positivo o negativo.

        System.out.println("Introduce un numero:");
        int numero = sc.nextInt();

        if (numero >= 0){
            System.out.println("El numero es positivo");
        } else{
            System.out.println("El numero es negativo");
        }

// Pide la edad y muestra si la persona es mayor o menor de edad.
        System.out.println("Introduzca su edad: ");
        int edad = sc.nextInt();

        if(edad >= 18) {
            System.out.println("Eres mayor de edad:");
        } else {
            System.out.println("Eres menor de edad:");
        }

//Determina si un número entero es par o impar.
        System.out.println("Introduce un numero:");
        int numero2 = sc.nextInt();

        if (numero2 % 2 == 0 ){
            System.out.println("El numero es par");
        }else {
            System.out.println("El numero es impar");
        }

//Pide una nota (0–10) y muestra si está suspendido, aprobado o sobresaliente.
        System.out.println("Introduzca la nota: ");
        int nota = sc.nextInt();
        if (nota < 5){
            System.out.println("Estas suspendido");
        }else if (nota <7){
            System.out.println("Estas aprobado");
        }else if (nota < 9){
            System.out.println("Tienes un notable");
        } else {
            System.out.println("Tienes un sobresaliente");
        }

//Pide tres números y muestra cuál es el mayor.
        System.out.println("Introduce un numero: ");
        int num1 = sc.nextInt();
        System.out.println("Introduce un numero: ");
        int num2 = sc.nextInt();
        System.out.println("Introduce un numero: ");
        int num3 = sc.nextInt();

        if (num1 >= num2 && num1 >= num3){
            System.out.println("El numero mayor es: " + num1);
        }else if (num2 >= num1 && num2 >= num3){
            System.out.println("El numero mayor es: " + num2);
        }else {
            System.out.println("El numero mayor es: " + num3);
        }
//Si el cliente gasta más de 100 €, se aplica un 10% de descuento.
        System.out.println("Introduce el total de la compra ");
        double compra = sc.nextDouble();

        if (compra >= 100){
            double descuento = compra * 0.10;
            compra = compra - descuento;
            System.out.println("la compra se descuenta un 10%, se quedaria en: " + compra);
        }else {
            System.out.println("el total de la compra es: " + compra);
        }

//Pide al usuario un número y muestra si es positivo, negativo o cero.
        System.out.println("Introduce un numero: ");
        int Numero1 = sc.nextInt();

        if (Numero1 > 0){
            System.out.println("El numero es positivo");
        }else if (Numero1 < 0){
            System.out.println("El numero es negativo");
        }else
            System.out.println("El numero es cero");
/* Pide la edad del usuario y muestra:
“Eres menor de edad” si tiene menos de 18 años.
“Eres mayor de edad” si tiene 18 o más */
        System.out.println("Introduczca su edad: ");
        int age = sc.nextInt();

        if (age >= 18) {
            System.out.println("Eres mayor de edad");
        } else {
            System.out.println("Eres menor de edad");
        }
//Pide un número entero y muestra si es par o impar.
        System.out.println("Introduce un numero: ");
        int Numero2 = sc.nextInt();

        if(Numero2 % 2 == 0){
            System.out.println("El numero es par");
        }else {
            System.out.println("El numero es impar");
        }
/*Pide una nota (de 0 a 10).
Si es menor de 5, muestra “Suspendido”.
Si es 5 o más, muestra “Aprobado”*/

        System.out.println("Introduzca una nota: ");
        int note = sc.nextInt();
        if (note < 5){
            System.out.println("Estas suspendido");
        }else {
            System.out.println("Estas aprobado");
        }
//Pide un número y muestra si está entre 10 y 50 (ambos inclusive).
        System.out.println("Introduce un numero: ");
        int Numero3 = sc.nextInt();

        if (Numero3 >= 10 && Numero3 <= 50){
            System.out.println("El numero esta dentro del rango");
        }else  {
            System.out.println("El numero no esta dentro del rango");
        }



    }
}