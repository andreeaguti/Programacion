/*Ejercicio 02: Crea una nueva clase AvisarHaciendaException que herede de Exception. La
utilizaremos para lanzar una excepción cuando haya que avisar a hacienda.*/

public class AvisarHaciendaException extends Exception {
    public AvisarHaciendaException(String mensaje) {
        super(mensaje);
    }
}
