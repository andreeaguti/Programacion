/*Ejercicio 01: Crea una nueva clase CuentaException que herede de Exception. La utilizaremos para
lanzar excepciones relacionadas con cuentas bancarias. */
public class CuentaException extends Exception {
    public CuentaException(String mensaje) {
        super(mensaje);
    }
}
