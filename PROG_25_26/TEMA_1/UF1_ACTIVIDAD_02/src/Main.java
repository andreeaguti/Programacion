
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        //Ejercicio 01
        System.out.println("Ejercicio 01");
        Scanner sc = new Scanner(System.in);

        System.out.println("Por favor, introduzca su edad");
        int edad = sc.nextInt();
        //int se utiliza para numeros enteros y double para numeros con decimales
        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        }

        //Ejercicio 02
        System.out.println("Ejercicio 02");
        sc = new Scanner(System.in);

        System.out.println("Por favor, introduzca sus anos");
        int anos = sc.nextInt();
        if (anos >= 18) {
            System.out.println ("Eres mayor de edad");
        }
        else if(anos > 18 && anos >= 0) {
            System.out.println ("Eres menor de edad");
        }
        else {
            System.out.println("La edad es invalida");
        }

        //Ejercicio 03
        System.out.println("Ejercicio 03");
        sc = new Scanner(System.in);

        for (int i = 1; i<=20; i++) {
            System.out.println("Los primeros 20 números naturales son:");
        }

        //Ejercicio 04
        System.out.println("Ejercicio 04");
        sc = new Scanner(System.in);

        for (int i = 2; i<=200; i += 2) {
            System.out.println("Los números pares entre el 1 y el 200 son:");
        }


        //Ejercicio 05
        System.out.println("Ejercicio 05");
        sc = new Scanner(System.in);

        for (int i = 2; i<=200; i++) {
            if ( i % 2 ==0) {
                System.out.println("El par es: "+i);
            }
        }

        //Ejercicio 06
        System.out.println("Ejercicio 06");
        sc = new Scanner(System.in);

        System.out.println("Introduce un numero:");
        int numero = sc.nextInt();

        for (int i = 1; i<= numero; i++) {
            System.out.println("El numero natural es:" + i);
        }

        //Ejercicio 07
        System.out.println("Ejercicio 07");
        sc = new Scanner(System.in);

        System.out.println("Introduce la nota del alumno:");
        double nota = sc.nextDouble();

        if(nota < 0.0 || nota > 10.0) {
            System.out.println("La nota no puede ser negativa");
        }
        else if(nota < 3) {
            System.out.println("Muy deficiente");
        }
        else if(nota < 5) {
            System.out.println("Insuficiente");
        }
        else if(nota <6) {
            System.out.println("Bien");
        }
        else if (nota < 9) {
            System.out.println("Notable");
        }
        else if (nota <=10) {
            System.out.println("Sobresaliente");
        }

        //Ejercicio 08
        System.out.println("Ejercicio 08");
        sc = new Scanner(System.in);

        System.out.println("Introduce un numero: ");
        int num2 = sc.nextInt();

        //Factorial Ej num = 5 --> factorial = 5*4*3*2*1
        int factorial = 1;
        for (int i = 1; i <= num2; i++) {
            factorial = factorial * i;
        }
        System.out.println("El factorial es:" + factorial);

        //Ejercicio 09
        System.out.println("Ejercicio 09");
        sc = new Scanner(System.in);

        System.out.println("Introduce los segundos: ");
        int segundos = sc.nextInt();

        System.out.println("Introduce los minutos: ");
        int minutos = sc.nextInt();

        System.out.println("Introduce las horas: ");
        int horas = sc.nextInt();

        System.out.println("La hora actual es:" + horas + ":" + minutos + ":" + segundos );

        segundos ++;

        if(segundos >= 60); {
            minutos ++;
            segundos = 0;

            if (minutos >=60) {
                segundos = 0;
                horas++;

                if (horas >= 24) {
                    horas = 0;
                }


            }
        }
        System.out.println("La hora modificada es:" + horas + ":" + minutos + ":" + segundos );

        //Ejercicio 10
        System.out.println("Ejercicio 10");
        sc = new Scanner(System.in);

        boolean hayNegativos = false;
        for (int i = 0; i < 10; i++){
            System.out.println("Introduce un numero distinto de cero");
            double n = sc.nextDouble();
            if (n < 0){
                hayNegativos = true;
            }
        }
        System.out.println("Hay numeros negativos: " + hayNegativos);

        //Ejercicio 11
        System.out.println("Ejercicio 11");
        sc = new Scanner(System.in);

        int nPositivos = 0;
        int nNegativos = 0;
        for(int i = 0; i < 10; i++) {
            System.out.println("Introduce un numero distinto de cero");
            double n = sc.nextDouble();
            if (n > 0) {
                nPositivos++;
            }
            if (n < 0) {
                nNegativos++;
            }
        }

        //Ejercicio 12
        System.out.println("Ejercicio 12");
        sc = new Scanner(System.in);

        int numeroNegativos = 0;
        int numeroPositivos = 0;
        int Numero = 0;

        do {
            System.out.println("Introduce un número distinto a cero o cero para parar:");
            numero = sc.nextInt();
            if(numero < 0){
                numeroNegativos++;
            }
            if(numero > 0){
                numeroPositivos++;
            }

        }while(numero != 0);

        System.out.println("Hay" + numeroNegativos + "numeros negativos y hay " + numeroPositivos + " numeros positivos");

        //Ejercicio 13
        System.out.println("Ejercicio 13");
        sc = new Scanner(System.in);

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

        //Ejercicio 14
        System.out.println("Ejercicio 14");
        sc = new Scanner(System.in);
        double tarifaNormal = 25.0;

        System.out.println("Introduce el nombre del trabajador");
        String nombre = sc.nextLine();

        System.out.println("Introduce el numero de horas trabajadas");
        double horasTrabajadas = sc.nextDouble();

        double salarioBruto = 0.0;
        double salarioNeto = 0.0;
        if(horasTrabajadas >= 0 && horasTrabajadas <= 35){
            salarioBruto = tarifaNormal * horasTrabajadas;
        } else if (horasTrabajadas > 35) {
            salarioBruto = 1.5 * tarifaNormal * (horasTrabajadas-35) + 35 * tarifaNormal;

        } else{
            System.out.println("Las horas trabajadas no pueden ser negativas");
        }

        if(salarioBruto <= 500){
            salarioNeto = salarioBruto;
        }
        else if(salarioBruto > 500 && salarioBruto <= 900){
            salarioNeto = 500 +  (salarioBruto - 500) * 0.75;
        }
        else if(salarioBruto > 900 ){
            salarioNeto = 500 +  (salarioBruto - 500) * 0.75 + (salarioBruto - 900) * 0.55;
        }

        System.out.println("El nombre del trabajador es: " + nombre);
        System.out.println("El numero de horas trabajadas es: " + horas);
        System.out.println("La tarifa por hora es: " + tarifaNormal);
        System.out.println("La salario bruto es: " + salarioBruto);
        System.out.println("La salario neto es: " + salarioNeto);
        System.out.println("Las tasas aplicadas son: " + (salarioBruto - salarioNeto));

    }
}

//Test