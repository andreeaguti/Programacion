import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Ejercicio 01
        sc=new Scanner(System.in);
        System.out.println("Ejercicio 01");

        System.out.println("Introduzca su edad: ");
        int edad = sc.nextInt();

        if (edad>=18){
            System.out.println("Eres mayor de edad");
        }

        //Ejercicio 02
        sc=new Scanner(System.in);
        System.out.println("Ejercicio 02");

        System.out.println("Introduzca su edad: ");
        int edad1 = sc.nextInt();

        if (edad1 >= 18){
            System.out.println("Eres mayor de edad");
        }else{
            System.out.println("Eres menor de edad");
        }

        //Ejercicio 03
        sc=new Scanner(System.in);
        System.out.println("Ejercicio 03");

        for (int i = 1; i<=20; i++) {
            System.out.println(i);
        }

        //Ejercicio 04
        sc=new Scanner(System.in);
        System.out.println("Ejercicio 04");

        for (int i = 0; i <= 200; i+=2) {
            System.out.println(i);
        }

        //Ejercicio 05
        sc=new Scanner(System.in);
        System.out.println("Ejercicio 05");

        for (int i = 1; i <= 200; i++) {
            if (i % 2 == 0){
                System.out.println(i);
            }
        }

        //Ejercicio 06
        sc=new Scanner(System.in);
        System.out.println("Ejercicio 06");

        System.out.println("Introduzca un numero");
        int numero = sc.nextInt();

        for (int i = 1; i <= numero; i++) {
            System.out.println(i);
        }

        //Ejercicio 07
        sc=new Scanner(System.in);
        System.out.println("Ejercicio 07");

        System.out.println("Introduzca su nota:");
        int nota = sc.nextInt();

        if (nota < 3){
            System.out.println("Muy deficiente");
        }else if (nota < 5){
            System.out.println("Insuficiente");
        }else if (nota >= 5 && nota < 6){
            System.out.println("Bien");
        }else if (nota >= 6 && nota < 9){
            System.out.println("Notable");
        }else if (nota >= 9 && nota <= 10){
            System.out.println("Sobresaliente");
        }else {
            System.out.println("Nota no valida");
        }

        //Ejercicio 08
        sc=new Scanner(System.in);
        System.out.println("Ejercicio 08");

        System.out.println("Introduzca un numero positivo:");
        double numeroPositivo = sc.nextDouble();

        int factorial = 1;
        for (int i = 1; i <= numeroPositivo; i++) {
            factorial = factorial *i;
        }
        System.out.println("Su factorial es:" + factorial);


        //Ejercicio 09
        sc=new Scanner(System.in);
        System.out.println("Ejercicio 09");

        System.out.println("Introduzca la hora:");
        int hora = sc.nextInt();
        System.out.println("Introduzca los minutos");
        int minuto = sc.nextInt();
        System.out.println("Introduzca los segundos:");
        int segundo = sc.nextInt();

        if (segundo >= 60 ) {
            minuto++;
            segundo = 0;
            if (minuto >= 60) {
                hora++;
                minuto = 0;
                if (hora >= 24) {
                    hora = 0;
                }
            }
        }
        System.out.println("La hora es: " + hora + ":" + minuto + ":" + segundo);

        //Ejercicio 10
        sc=new Scanner(System.in);
        System.out.println("Ejercicio 10");
        boolean hayNegativos = false;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Introduze un numero:");
            double numero22 = sc.nextDouble();
            if (numero22 < 0){
                hayNegativos = true;
            }
        }
        System.out.println("Hay negativos: " + hayNegativos);


        //Ejercicio 11
        sc=new Scanner(System.in);
        System.out.println("Ejercicio 11");
        int contadorPositivos = 0;
        int contadorNegativos = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.println("Introduce un numero:");
            double numero21 = sc.nextDouble();
            if (numero21 < 0){
                contadorNegativos++;
            } else if (numero21 > 0) {
                contadorPositivos++;
            }else {
                System.out.println("El número no puede ser 0");
            }
        }
        System.out.println("Número negativos: " + contadorNegativos);
        System.out.println("Número positivos: " + contadorPositivos);

        //Ejercicio 12
        sc=new Scanner(System.in);
        System.out.println("Ejercicio 12");
        int numerosPositivos = 0;
        int numerosNegativos = 0;
        int numeroCero = 0;

        do {
            System.out.println("Introduzca un numero: ");
            numero = sc.nextInt();
            if (numero > 0){
                numerosPositivos++;
            }else if (numero < 0){
                numerosNegativos++;
            }
        }while (numero != 0 );
        System.out.println("Número negativos: " + contadorNegativos);
        System.out.println("Número positivos: " + contadorPositivos);

        //Ejercicio 13
        System.out.println("\nEjercicio 13");
        sc = new Scanner(System.in);

        int suma = 0;
        int multiplica = 1;

        for(int i = 1; i <= 10; i++){
            suma  = suma + i; // suma += i;
            multiplica = multiplica * i; // multiplica *= i;
        }
        System.out.println("La suma de los 10 primeros numeros naturales es: " + suma);
        System.out.println("La multiplicacion de los 10 primeros numeros naturales es: " + multiplica);




    }
}