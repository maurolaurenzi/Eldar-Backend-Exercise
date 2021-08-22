package webapp.domain.exceptions;

public class OperacionInvalidaException extends RuntimeException{
    public OperacionInvalidaException(String mensaje){
        super(mensaje);
    }
}
