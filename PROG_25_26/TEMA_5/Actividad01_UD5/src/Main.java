import java.util.*;

public class Main {
    public static void main(String[] args) throws EdadIncorrectaException, NombreIncorrectoException {
        Scanner sc = new Scanner(System.in);

    /*EJERCICIO 1: Implementa un programa que pida al usuario un valor entero A utilizando un nextInt() (de
Scanner) y luego muestre por pantalla el mensaje “Valor introducido: …”. Se deberá tratar la
excepción InputMismatchException que lanza nextInt() cuando no se introduce un entero
válido. En tal caso se mostrará el mensaje “Valor introducido incorrecto”. */
        System.out.println("Ejercicio 01");
        sc = new Scanner(System.in);

        try {
            System.out.println("Introduzca un valor entero 'A' ");
            int valorA = sc.nextInt();
            System.out.println("Valor de A: " + valorA);
        } catch (InputMismatchException e) {
            System.out.println("Valor introducido incorrecto. ");
            System.out.println("Error: " + e.getMessage());
        }

/*EJERCICIO 2: Implementa un programa que pida dos valores int A y B utilizando un nextInt() (de Scanner),
calcule A/B y muestre el resultado por pantalla. Se deberán tratar de forma independiente las
dos posibles excepciones, InputMismatchException y ArithmeticException, mostrando en cada
caso un mensaje de error diferente en cada caso. */
        //InputMisMatchException: Por introducir un nombre NO entero
        //ArithmeticException: Por dividir entre 0
        System.out.println("Ejercicio 02");
        sc = new Scanner(System.in);

        try {
            System.out.println("Introduzca un valor entero 'A' ");
            int valorA = sc.nextInt();
            System.out.println("Introduzca un valor entero 'B' ");
            int valorB = sc.nextInt();
            int division = valorA / valorB;
            System.out.println("Valor division: " + division);
        } catch (InputMismatchException e) {
            System.out.println("¡Tiene que ser un número entero! ");
            System.out.println("Error: " + e.getMessage());
        }catch (ArithmeticException e) {
            System.out.println("No se puede dividir entre 0 ");
            System.out.println("Error: " + e.getMessage());
        }

/*EJERCICIO 3:Implementa un programa que cree un vector tipo double de tamaño 5 y luego, utilizando un
bucle, pida cinco valores por teclado y los introduzca en el vector. Tendrás que manejar la/las
posibles excepciones y seguir pidiendo valores hasta rellenar completamente el vector. */
        System.out.println("Ejercicio 03");
        sc = new Scanner(System.in);

        double[] ejercicio3 = new double[5];


            for (int i = 0; i < ejercicio3.length; i++) {
                try {
                    System.out.println("Introduzca 5 valores para el vector ");
                    ejercicio3[i] = sc.nextDouble();//asigna cada número a la posición i del array, es decir, el primer número lo guarda en la posición 0

                } catch (InputMismatchException e) {
                    sc = new Scanner(System.in);
                    System.out.println("Tiene que tener decimales ");
                    System.out.println("Introduzca 5 valores para el vector ");
                    ejercicio3[i] = sc.nextDouble();//asigna cada número a la posición i del array, es decir, el primer número lo guarda en la posición 0
                }
            }

/*EJERCICIO 4: Implementa un programa con tres funciones:
• void imprimePositivo(int p): Imprime el valor p. Lanza una ‘Exception’ si p < 0
• void imprimeNegativo(int n): Imprime el valor n. Lanza una ‘Exception’ si p >= 0
• La función main para realizar pruebas. Puedes llamar a ambas funciones varias veces
con distintos valores, hacer un bucle para pedir valores por teclado y pasarlos a las
funciones, etc. Maneja las posibles excepciones. */
        System.out.println("Ejercicio 04");
        sc = new Scanner(System.in);

        // Creamos el objeto de la clase donde están los métodos
        Ejercicio4 ejercicio4 = new Ejercicio4();

        try {
            System.out.println("Introduzca un número positivo 'p' ");
            int p = sc.nextInt();
            ejercicio4.imprimePositivo(p);

            System.out.println("Introduzca un número negativo 'n'");
            int n = sc.nextInt();
            ejercicio4.imprimeNegativo(n);
        } catch (InputMismatchException e){
            System.out.println("Error: ¡Debes introducir un número entero!");
            sc.nextLine();
        } catch (Exception e) {

        System.out.println("Error de lógica: " + e.getMessage());
    }

        /*EJERCICIO 5: Implementa una clase Gato con los atributos nombre y edad, un constructor con parámetros,
los getters y setters, además de un metodo imprimir() para mostrar los datos de un gato. El
nombre de un gato debe tener al menos 3 caracteres y la edad no puede ser negativa. Por ello,
tanto en el constructor como en los setters, deberás comprobar que los valores sean válidos y
lanzar una ‘Exception’ si no lo son. Luego, haz una clase principal con main para hacer pruebas:
instancia varios objetos Gato y utiliza sus setters, probando distintos valores (algunos válidos y
otros incorrectos). Maneja las excepciones. */
        System.out.println("Ejercicio 05");
        sc = new Scanner(System.in);

        ArrayList<Gato> gatos = new ArrayList<>();
        //instancia varios objetos Gato y utiliza sus setters

        Gato g1 = new Gato("Lucas", 5);
        gatos.add(g1);

        try {
        Gato g2 = new Gato("as", 8);
        gatos.add(g2);
        } catch (NombreIncorrectoException e) {
            System.out.println("Error:" + e.getMessage());
        }

        Gato g3 = new Gato("Tobby", 10);
        gatos.add(g3);
        try {
            Gato g4 = new Gato("mustafa", -5);
            gatos.add(g4);
        }catch (EdadIncorrectaException e) {
            System.out.println("Error:" + e.getMessage());
        }

        for (Gato g: gatos) {
            System.out.println(g.toString());
        }
/*Crea una copia del programa anterior y modifica el main para hacer lo siguiente:
• Crea un ArrayList<Gato>. Luego, utilizando un bucle, pide al usuario que introduzca los
datos de 5 gatos: utiliza un Scanner para pedir los datos, instancia el objeto y guárdalo
en el ArrayList. Por último, imprime la información de los gatos.
• Maneja las posibles excepciones de modo que en el ArrayList solo almacenemos objetos
Gato válidos y el bucle se repita hasta crear y almacenar correctamente 5 gatos.*/
        System.out.println("Ejercicio 06");
        sc = new Scanner(System.in);

        ArrayList<Gato> ejercicio6 = new ArrayList<>(5);

        //instancia varios objetos Gato y utiliza sus setters
        while(ejercicio6.size() < 5) {
            try {
                System.out.println("Introduzca nombre del gato: ");
                String nombre = sc.next();
                System.out.println("Introduzca edad del gato: ");
                int edad = sc.nextInt();
                gatos.add(new Gato(nombre, edad));
            }catch (EdadIncorrectaException e) {
                System.out.println("Error:La edad tiene que ser positiva" );
                sc.nextLine();
            }catch (NombreIncorrectoException e) {
                System.out.println("Error:El nombre tiene que tener mas de 3 caracteres");
                sc.nextLine();
            }
            for(Gato g: gatos) {
                System.out.println(g.toString());
            }
        }



























    }
}
