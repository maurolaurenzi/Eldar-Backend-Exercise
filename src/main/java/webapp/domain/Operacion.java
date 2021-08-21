package webapp.domain;

import java.time.LocalDate;

public class Operacion {
    private Tarjeta tarjeta;
    private LocalDate fecha;
    private Double monto;

    //class method: it should be called without creating a class instance
    public static boolean esValida(Double importe){
        return importe > 1000.00;
    }
    //code smell: metodo "pasamanos" -> mejorar
    public static Double calcularTasa(MarcaTarjeta marca, Double importe){
        return marca.tasaOperacion(importe);
    }
}
