package webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Entity
public class Operacion {
    @Id @GeneratedValue
    private Long id;
    @ManyToOne
    private Tarjeta tarjeta;
    private LocalDate fecha;
    private Double monto;

    public Operacion(Tarjeta tarjeta, LocalDate fecha, Double monto) {
        this.tarjeta = tarjeta;
        this.fecha = fecha;
        //chequear valor de monto
        this.monto = monto;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    //class method: it should be called without creating a class instance
    public static boolean esValida(Double importe){

        return importe > 1000.00;
    }
    //code smell: metodo "pasamanos" -> mejorar
    public static Double calcularTasa(MarcaTarjeta marca, Double importe, LocalDate fecha){
        return marca.tasaOperacion(importe, fecha);
    }
}
