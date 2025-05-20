package excepciones;

public class StockInsuficienteException extends Exception {
    public StockInsuficienteException(String msg) {
        super(msg);
    }
}
