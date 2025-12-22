import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);

/*Ejercicio 01: Crea un programa que pida una cadena de texto por teclado y luego
muestre cada palabra de la cadena en una línea distinta.*/

System.out.println("Actividad 01");
sc = new Scanner(System.in);

System.out.println("Escriba un texto: ");
String texto =  sc.nextLine();

String [] palabras = texto.split(" ");

System.out.println("El texto es: ");
for(String palabra : palabras){
    System.out.println(palabra);
}
/* Ejercicio 02: Crea un programa que pida dos cadenas de texto por teclado y
luego indique si son iguales, además de si son iguales sin diferenciar entre
mayúsculas y minúsculas. */
System.out.println("Actividad 02");
sc = new Scanner(System.in);

System.out.println("Escriba un texto: ");
String texto1 =  sc.nextLine();

System.out.println("Escriba un texto: ");
String texto2 =  sc.nextLine();

if(texto1.equalsIgnoreCase(texto2)){
    System.out.println("El texto es igual sin diferenciar mayusculas de minusculas");
} else{
    System.out.println("El texto no es el mismo");
}

/*Ejercicio 03: Crea un programa que pida por teclado tres cadenas de texto:
nombre y dos apellidos. Luego mostrará un código de usuario (en mayúsculas)
formado por la concatenación de las tres primeras letras de cada uno de ellos.
Por ejemplo, si se introduce “Lionel”, “Tarazón” y “Alcocer” mostrará
“LIOTARALC”. */

System.out.println("Actividad 03");
sc = new Scanner(System.in);

System.out.println("Escriba un nombre: ");
String nombre =  sc.nextLine();

System.out.println("Escriba el primer apellido: ");
String apellido1 =  sc.nextLine();

System.out.println("Escriba el segundo apellido: ");
String apellido2 =  sc.nextLine();

String snombre = nombre.substring(0,3).toUpperCase(); //estamos cogiendo las 3 primeras letras
String sapellido1 = apellido1.substring(0,3).toUpperCase();
String sapellido2 = apellido2.substring(0,3).toUpperCase();

System.out.println(snombre + sapellido1 + sapellido2);


/* Ejercicio 04: Crea un programa que muestre por pantalla cuantas vocales de cada
tipo hay (cuantas ‘a’, cuantas ‘e’, etc.) en una frase introducida por teclado.
No se debe diferenciar entre mayúsculas y minúsculas. Por ejemplo, dada
la frase “Mi mama me mima” dirá que hay:
No de A's: 3
No de E's: 1
No de I's: 2
No de O's: 0
No de U's: 0 */

System.out.println("Actividad 04");
sc = new Scanner(System.in);

System.out.println("Escriba un texto ");
String textoContarVocales =  sc.nextLine();

textoContarVocales = textoContarVocales.toLowerCase(); // convierto el texto a minusculas

int contadorA = 0;
int contadorE = 0;
int contadorI = 0;
int contadorO = 0;
int contadorU = 0;

for (int i = 0; i < textoContarVocales.length(); i++) {
    char vocal = textoContarVocales.charAt(i);
 // esto es un bucle para que recorra todas las letras de la frase
    switch (vocal) {
        case 'a':
            contadorA++;
            break;
        case 'e':
            contadorE++;
            break;
        case 'i':
            contadorI++;
            break;
        case 'o':
            contadorO++;
            break;
        case 'u':
            contadorU++;
            break;
    }
}
System.out.println("Numero de caracteres A: " + contadorA);
System.out.println("Numero de caracteres E: " + contadorE);
System.out.println("Numero de caracteres I: " + contadorI);
System.out.println("Numero de caracteres O: " + contadorO);
System.out.println("Numero de caracteres U: " + contadorU);

/*Ejercicio 05: Realiza un programa que lea una frase por teclado e indique
si la frase es un palíndromo o no (ignorando espacios y sin diferenciar
entre mayúsculas y minúsculas). Supondremos que el usuario solo introducirá
letras y espacios (ni comas, ni puntos, ni acentos, etc.). Un palíndromo
es un texto que se lee igual de izquierda a derecha que de derecha a izquierda.
 */
System.out.println("Actividad 05");
sc = new Scanner(System.in);

System.out.println("Escriba una frase: ");
String frase = sc.nextLine();

frase = frase.toLowerCase(); //paso todo el texto a minusculas

String sinEspacios = frase.replace(" ",""); //elimino todos los espacios

String fraseAlreves = new StringBuilder(sinEspacios).reverse().toString();

if (sinEspacios.equals(fraseAlreves)){
    System.out.println("Es un palindromo");
}else {
    System.out.println("No es un palindromo");
}



    }
}