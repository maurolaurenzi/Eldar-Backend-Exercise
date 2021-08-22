package webapp.domain;

import com.sun.istack.NotNull;
import webapp.domain.exceptions.OperacionInvalidaException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Entity
public class Operacion {
    @Id @GeneratedValue
    private Long id;
    @NotNull
    @ManyToOne
    private Tarjeta tarjeta;
    @NotNull
    private LocalDate fecha;
    @NotNull
    private Double monto;

    public Operacion(Tarjeta tarjeta, LocalDate fecha, Double monto) throws OperacionInvalidaException {
        this.tarjeta = tarjeta;
        this.fecha = fecha;
        //chequear valor de monto
        if(monto > 1000.00) {
            this.monto = monto;
        }
        else{
            throw new OperacionInvalidaException("Operacion Invalida. El monto debe ser mayor a $1000");
        }
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

    public boolean esValida(){
        return monto > 1000.00;
    }
    //code smell: metodo "pasamanos" -> mejorar
    public static Double calcularTasa(MarcaTarjeta marca, Double importe, LocalDate fecha){
        return marca.tasaOperacion(importe, fecha);
    }
}
