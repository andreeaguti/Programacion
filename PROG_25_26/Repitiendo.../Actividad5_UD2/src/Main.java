import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


    /*Crea un programa que pida una cadena de texto por teclado y luego muestre cada palabra
    de la cadena en una línea distinta. */
        System.out.println("Actividad 1");
        sc = new Scanner(System.in);
        System.out.println("Introduzca un texto");
        String texto = sc.nextLine();

        String[] palabras = texto.split(" ");
        //creo un array de Strings (el array va a guardar cadenas de texto)
        // palabras es el nombre de ese array
        //el metodo .split(" ") divide el texto en partes cada vez que encuentra un espacio en blanco
        for (String palabra : palabras) { //
            System.out.println(palabra); //muestra cada palabra en cada vuelta
        }
        //este simbolo : se lee como "en" o "dentro de"



        /*Crea un programa que pida dos cadenas de texto por teclado y luego indique si son iguales, además de si
        son iguales sin diferenciar entre mayúsculas y minúsculas. */
        System.out.println("Actividad 2");
        sc = new Scanner(System.in);

        System.out.println("Introduzca el primer texto");
        String texto1 = sc.nextLine();
        System.out.println("Introduzca el segundo texto");
        String texto2 = sc.nextLine();

        if (texto1.equalsIgnoreCase(texto2)) {
            System.out.println("Son iguales, sin diferenciar entre mayusculas y minusculas");
        } else if (texto1.equals(texto2)) {
            System.out.println("Son exactamente iguales");
        } else {
            System.out.println("No son iguales");
        }

        /* Crea un programa que pida por teclado tres cadenas de texto: nombre y dos apellidos. Luego mostrará un
        código de usuario (en mayúsculas) formado por la concatenación de las tres primeras letras de cada uno de ellos.
        Por ejemplo, si se introduce “Lionel”, “Tarazón” y “Alcocer” mostrará “LIOTARALC”. */
        System.out.println("Actividad 3");
        sc = new Scanner(System.in);

        System.out.println("Introduzca el nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el primer apellido");
        String apellido1 = sc.nextLine();
        System.out.println("Introduzca el segundo apellido");
        String apellido2 = sc.nextLine();

        String c0 = nombre.substring(0, 3).toUpperCase();
        String c1 = apellido1.substring(0, 3).toUpperCase();
        String c2 = apellido2.substring(0, 3).toUpperCase();
        //charAt solo coje un unico caracter, substring los que quieras
        System.out.println("El codigo es: " + c0 + c1 + c2);


        /* Crea un programa que muestre por pantalla cuantas vocales de cada tipo hay (cuantas ‘a’, cuantas ‘e’, etc.) en una frase introducida por teclado. No se debe diferenciar entre mayúsculas y minúsculas. Por ejemplo, dada la frase “Mi mama me mima” dirá que hay:
        Nº de A's: 3
        Nº de E's: 1
        Nº de I's: 2
        Nº de O's: 0
        Nº de U's: 0 */
        System.out.println("Actividad 4");
        sc = new Scanner(System.in);

        System.out.println("Introduzca una frase");
        String frase = sc.nextLine();

        int contadorA = 0;
        int contadorE = 0;
        int contadorI = 0;
        int contadorO = 0;
        int contadorU = 0;

        for (int i = 0; i < frase.length(); i++) {
            switch (frase.toLowerCase().charAt(i)) { //convierte la frase a minusculas, extrae la letra que esta en la posicion i
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
        /* Seria lo mismo que esto:
        // Convertimos la frase a minúsculas y luego a un array de caracteres
        char[] caracteres = frase.toLowerCase().toCharArray();

        for (char letra : caracteres) {
            switch (letra) {
        case 'a': contadorA++; break;
        case 'e': contadorE++; break;
        case 'i': contadorI++; break;
        case 'o': contadorO++; break;
        case 'u': contadorU++; break;
   }
   }
         */


        /* Realiza un programa que lea una frase por teclado e indique si la frase es un palíndromo o no (ignorando espacios y sin diferenciar entre mayúsculas y minúsculas). Supondremos que el usuario solo introducirá letras y espacios (ni comas, ni puntos, ni acentos, etc.). Un palíndromo es un texto que se lee igual de izquierda a derecha que de derecha a izquierda.
        Por ejemplo:
        Amigo no gima
        Dabale arroz a la zorra el abad
        Amo la pacífica paloma
        A man a plan a canal Panama */

        System.out.println("Actividad 5");
        sc = new Scanner(System.in);

        System.out.print("Introduce una frase: ");
        String fraseOriginal = sc.nextLine();
        String fraseProcesada = fraseOriginal.replaceAll(" ", "").toLowerCase();

        if (esPalindromo(fraseProcesada)) {
            System.out.println("Resultado: La frase ES un palíndromo.");
        } else {
            System.out.println("Resultado: La frase NO es un palíndromo.");
        }
    }

        private static boolean esPalindromo(String texto) {

        boolean palindromo = false;

            int izquierda = 0;

            // Puntero de la derecha (final)
            int derecha = texto.length() - 1;

            while (izquierda < derecha) {

                // Comparamos los caracteres en las posiciones de los punteros
                if (texto.charAt(izquierda) != texto.charAt(derecha)) {
                    return palindromo; // Si son diferentes, no es palíndromo
                }

                // Si son iguales, movemos los punteros
                izquierda++; // Hacia la derecha
                derecha--;   // Hacia la izquierda
            }

            // Si el bucle termina sin encontrar diferencias, es un palíndromo
            palindromo = true;
            return palindromo;

}
}