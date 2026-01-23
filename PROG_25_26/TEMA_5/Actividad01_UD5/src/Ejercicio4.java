public class Ejercicio4 {

    public static void imprimePositivo (int p) throws Exception{
        if (p < 0){
            throw new Exception("El numero no es positivo");
        }else {
            System.out.println(p);
        }
    }

    public static void imprimeNegativo (int n) throws Exception{
        if (n < 0){
            System.out.println(n);
        }else {
            throw new Exception("El número no es negativo");
        }
    }
}
