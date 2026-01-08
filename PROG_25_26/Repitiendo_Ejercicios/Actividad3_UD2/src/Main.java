import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //EJERCICIO 1
        System.out.println("Introduce una cantidad de € (múltiplo de 5)");
        int cantidad = sc.nextInt();

        //declaro variables
        int billetes500=0;
        int billetes200=0;
        int billetes100=0;
        int billetes50=0;
        int billetes20=0;
        int billetes10=0;
        int billetes5=0;


        if (cantidad % 5 != 0) { //calcula el resto de dividir la cantidad entre 5
            System.out.println("Cantidad no valida, tiene que ser múltiplo de 5");
        } //es decir, si el resto de la cantidad entre 5 no es 0, devuelve ese mensaje

        if (cantidad >= 500){ //si la cantidad es > o = a 500, entra en el bucle
            billetes500 = cantidad / 500; //aquí al dividir, calcula cuantas veces cabe 500 en la cantidad introducida
            cantidad = cantidad % 500; //calcula lo que sobra despues de haber repartido los billetes de 500.
        }
        if (cantidad >= 200){ //si la cantidad es > o = a 500, entra en el bucle
            billetes200 = cantidad / 200; //aquí al dividir, calcula cuantas veces cabe 500 en la cantidad introducida
            cantidad = cantidad % 200; //calcula lo que sobra despues de haber repartido los billetes de 500.
        }
        if (cantidad >= 100){ //si la cantidad es > o = a 500, entra en el bucle
            billetes100 = cantidad / 100; //aquí al dividir, calcula cuantas veces cabe 500 en la cantidad introducida
            cantidad = cantidad % 100; //calcula lo que sobra despues de haber repartido los billetes de 500.
        }
        if (cantidad >= 50){ //si la cantidad es > o = a 500, entra en el bucle
            billetes50 = cantidad / 50; //aquí al dividir, calcula cuantas veces cabe 500 en la cantidad introducida
            cantidad = cantidad % 50; //calcula lo que sobra despues de haber repartido los billetes de 500.
        }
        if (cantidad >= 20){ //si la cantidad es > o = a 500, entra en el bucle
            billetes20 = cantidad / 20; //aquí al dividir, calcula cuantas veces cabe 500 en la cantidad introducida
            cantidad = cantidad % 20; //calcula lo que sobra despues de haber repartido los billetes de 500.
        }
        if (cantidad >= 10){ //si la cantidad es > o = a 500, entra en el bucle
            billetes10 = cantidad / 10; //aquí al dividir, calcula cuantas veces cabe 500 en la cantidad introducida
            cantidad = cantidad % 10; //calcula lo que sobra despues de haber repartido los billetes de 500.
        }
        if (cantidad >= 5){ //si la cantidad es > o = a 5, entra en el bucle
            billetes5 = cantidad / 5; //aquí al dividir, calcula cuantas veces cabe 500 en la cantidad introducida
            cantidad = cantidad % 5; //calcula lo que sobra despues de haber repartido los billetes de 500.
        }
        if (billetes500 > 0)
            System.out.println("Billetes de 500€: " + billetes500);
        if (billetes200 > 0)
            System.out.println("Billetes de 200€: " + billetes200);
        if (billetes100 > 0)
            System.out.println("Billetes de 100€: " + billetes100);
        if (billetes50 > 0)
            System.out.println("Billetes de 50€: " + billetes50);
        if (billetes20 > 0)
            System.out.println("Billetes de 20€: " + billetes20);
        if (billetes10 > 0)
            System.out.println("Billetes de 10€: " + billetes10);
        if (billetes5 > 0)
            System.out.println("Billetes de 5€: " + billetes5);

        //EJERCICIO EXTRA:
        // Conversor de Segundos a Tiempo Legible
        //Enunciado: Crea un programa que pida al usuario una cantidad de segundos (por ejemplo, 10.000).
        // El programa debe calcular cuántos días, horas, minutos y segundos contiene esa cifra, mostrando siempre el mínimo de unidades posibles.
        //Lógica de conversión:
        //1 minuto = 60 segundos.
        //1 hora = 60 minutos (3.600 segundos).
        //1 día = 24 horas (86.400 segundos).

        System.out.println("Introduce una cantidad de segundos");
        int segundosT = sc.nextInt();

        int dias=0;
        int horas=0;
        int minutos=0;
        int segundos=0;

        if (segundosT >= 86400){ //si la cantidad es > o = a 86400, entra en la condicion
            dias = segundosT / 86400; //aquí al dividir, calcula cuantas veces cabe 86400 en la cantidad introducida
            segundosT = segundosT % 86400; //calcula lo que sobra después de haber repartido los 86400 segundos
        }
        if (segundosT >= 3600){ //si la cantidad es > o = a 3600, entra en la condicion
            horas = segundosT / 3600; //aquí al dividir, calcula cuantas veces cabe 86400 en la cantidad introducida
            segundosT = segundosT % 3600; //calcula lo que sobra después de haber repartido los 86400 segundos
        }
        if (segundosT >= 60){ //si la cantidad es > o = a 60, entra en la condicion
            minutos = segundosT / 60; //aquí al dividir, calcula cuantas veces cabe 60 en la cantidad introducida
            segundosT = segundosT % 60; //calcula lo que sobra después de haber repartido los 86400 segundos
        }
        if (segundosT >= 1){ //si la cantidad es < a 1, entra en la condicion
            segundos = segundosT / 1; //aquí al dividir, calcula cuantas veces cabe 1 en la cantidad introducida
            segundosT = segundosT % 1; //calcula lo que sobra después de haber repartido los 86400 segundos
        }
        // o segundosT = segundos

        if (dias > 0)
            System.out.println("Dias: " + dias);
        if (horas > 0)
            System.out.println("Horas: " + horas);
        if (minutos > 0)
            System.out.println("Minutos: " + minutos);
        if (segundos > 0)
            System.out.println("Segundos: " + segundos);


        //EJERCICIO 2
        int opcion;
        int num1 = 0, num2= 0;

        do {
            System.out.print("Ingrese una opcion: ");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    sc =new Scanner(System.in);
                    System.out.println("Ingrese un numero: ");
                    num1 = sc.nextInt();
                    System.out.println("Ingrese un numero: ");
                    num2 = sc.nextInt();
                    int suma = num1 + num2;
                    System.out.println("La suma es: " + suma);
                    break;
                case 2:
                    sc =new Scanner(System.in);
                    System.out.println("Ingrese un numero: ");
                    num1 = sc.nextInt();
                    System.out.println("Ingrese un numero: ");
                    num2 = sc.nextInt();
                    int resta = num1 - num2;
                    System.out.println("La resta es: " + resta);
                    break;
                case 3:
                    sc =new Scanner(System.in);
                    System.out.println("Ingrese un numero: ");
                    num1 = sc.nextInt();
                    System.out.println("Ingrese un numero: ");
                    num2 = sc.nextInt();
                    int multiplicacion = num1 * num2;
                    System.out.println("La multiplicacion es: " + multiplicacion);
                    break;
                case 4:
                    System.out.println("Dividir");
                    System.out.println("Ingrese un numero: ");
                    num1 = sc.nextInt();
                    System.out.println("Ingrese un numero: ");
                    num2 = sc.nextInt();
                    int division = num1 / num2;
                    System.out.println("La division es: " + division);
                    break;
                case 5:
                    System.out.println("Saliendo...");
            }

        }while (opcion != 5);





//2. Realiza un programa que muestre un menú de opciones como el siguiente:
//1. Sumar
//2. Restar
//3. Multiplicar
//4. Dividir (incluir manejo de división por 0)
//5. Salir
//El menú debe de repetirse hasta que se escoja la opción 5 (Salir).












    }
}