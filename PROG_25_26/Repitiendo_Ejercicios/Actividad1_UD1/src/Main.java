import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //Ejercicio 01
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 01");
    System.out.println("Buenos dias");

    //Ejercicio 02
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 02");
    double lado = 5;
    double area = lado * lado;
    System.out.println("Lado: " + lado);
    System.out.println("Area: " + area);

    //Ejercicio 03
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 03");
    System.out.println("Introduzca el valor del lado");
    lado = sc.nextDouble();
    area = lado * lado;
    System.out.println("El area del lado es: " + area);

    //Ejercicio 04
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 04");
    System.out.println("Introduzca el valor del lado");

    System.out.println("Introduce el primer numero:");
    double numero1 = sc.nextDouble();

    System.out.println("Introduce el segundo numero:");
    double numero2 = sc.nextDouble();

    double suma = numero1 + numero2;
    double resta = numero1 - numero2;
    double multiplicacion = numero1 * numero2;
    double division = numero1 / numero2;

    System.out.println("La suma es: " + suma);
    System.out.println("La resta es: " + resta);
    System.out.println("La division es: " + division);
    System.out.println("La multiplicacion es: " + multiplicacion);

    //Ejercicio 05
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 05");

    System.out.println("Introduzca la longitud de radio: ");
    double radio = sc.nextDouble();

    double longitud = 2 * Math.PI * radio;
    double area1 = radio * radio * Math.PI;
    double volumen = (4.0 / 3.0) * Math.PI * radio * radio * radio;

    System.out.println("El perimetro es: " + longitud);
    System.out.println("El area del radio es: " + area1);
    System.out.println("El volumen es: " + volumen);

    //Ejercicio 06
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 06");

    System.out.println("Introduzca el precio del articulo: ");
    double articulo = sc.nextDouble();
    System.out.println("Introduzca el precio de venta final: ");
    double precioFinal = sc.nextDouble();

    double descuento = articulo - precioFinal;
    double porcentaje = descuento / articulo;
    double porcentaje2 = porcentaje * 100.0;

    System.out.println("El porcentaje del descuento es de: " + porcentaje2 + " %");

    //Ejercicio 07
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 07");

    System.out.println("Introduzca la distancia en millas marinas: ");
    double distancia = sc.nextDouble();

    double metros = distancia * 1852;

    System.out.println("La distancia en metros es de: " + metros);

    //Ejercicio 08
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 08");

    System.out.println("Introduzca el primer numero: ");
    double num1 = sc.nextDouble();
    System.out.println("Introduzca el segundo numero: ");
    double num2 = sc.nextDouble();

    System.out.println("El orden ascendente es: " + Math.min (num1, num2) + Math.max(num1, num2));

    //Ejercicio 09
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 09");

    System.out.println("Introduzca el primer numero: ");
    double num3 = sc.nextDouble();
    System.out.println("Introduzca el segundo numero: ");
    double num4 = sc.nextDouble();

    System.out.println("Cual es mayor?" + Math.max(num3, num4));
    System.out.println("Son iguales? " + (num3 == num4));

    //Ejercicio 10
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 10");
    System.out.println("Introduzca el primer numero: ");
    double num5 = sc.nextDouble();
    System.out.println("Introduzca el segundo numero: ");
    double num6 = sc.nextDouble();
    System.out.println("Introduzca el tercer numero: ");
    double num7 = sc.nextDouble();

    double mayor = Math.max(Math.max(num5,num6), num7);

    System.out.println("El numero mayor es:" + mayor);

    //Ejercicio 11
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 11");

    System.out.println("Introduzca el primer numero: ");
    double num8 = sc.nextDouble();
    System.out.println("Introduzca el segundo numero (OJO no se puede poner cero): ");
    double num9 = sc.nextDouble();

    double suma2 = num8 + num9;
    double resta2 = num8 - num9;
    double multiplicacion2 = num8 * num9;
    double division2 = num8 / num9;

    System.out.println("La suma es: " + suma2);
    System.out.println("La resta es: " + resta2);
    System.out.println("La division es: " + division2);
    System.out.println("La multiplicacion es: " + multiplicacion2);

    //Ejercicio 12
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 12");

    System.out.println("Introduzca el primer numero: ");
    double num10 = sc.nextDouble();
    System.out.println("Introduzca el segundo numero: ");
    double num11 = sc.nextDouble();

    System.out.println("El mayor es: " + Math.max(num10, num11));

    //Ejercicio 13
    sc=new Scanner(System.in);
    System.out.println("Ejercicio 13");

    System.out.println("Introduzca un numero: ");
    double num12 = sc.nextDouble();

    if (num12 >= 0){
        System.out.println("El numero es positivo");
    }else{
        System.out.println("El numero es negativo");
    }
    }
}