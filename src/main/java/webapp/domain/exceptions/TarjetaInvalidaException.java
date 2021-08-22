package webapp.domain.exceptions;

public class TarjetaInvalidaException extends RuntimeException{
    public TarjetaInvalidaException(String mensaje){
        super(mensaje);
    }
}
