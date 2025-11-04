import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


    /**    Enunciado:
        Crea un programa que:
        1.	Pida el número de entradas que quiere comprar un usuario.
        2.	Guarde los precios en un array (por ejemplo: entrada normal = 8€, día del espectador = 5€).
        3.	Calcule el total a pagar.
        4.	Si el usuario compra más de 5 entradas, aplica un 10% de descuento. **/

//Crear variables
double [] precios = new double [] {8.0, 5.0 };
int numeroEntradas;
double precioUnitario;
int tipoEntrada;


do {
    System.out.println("Elija entrada: \n1. Entrada normal (8€) \n2. Entrada dia del espectador (5€)");
    tipoEntrada = sc.nextInt();
    if (tipoEntrada != 1 && tipoEntrada != 2) {
    System.out.println("Ingrese un tipo de entrada valido");
    }
}while(tipoEntrada != 1 && tipoEntrada != 2);


if(tipoEntrada==1){
precioUnitario = precios[0];
    }else {
    precioUnitario = precios[1];
}

System.out.println("Ingrese el numero de entradas que desea: ");
numeroEntradas = sc.nextInt();

double precioTotal = numeroEntradas * precioUnitario;

if (numeroEntradas > 5){
    System.out.println("Tienes un 10% de descuento!");
    double descuento = precioTotal * 0.10;
    precioTotal = precioTotal - descuento;
}
    System.out.println("El precio de las entradas es de: " + precioTotal + "€");

    }
}