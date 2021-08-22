package webapp.domain;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Amex extends MarcaTarjeta {
    public Amex(NombreMarca nombre) {
        super(nombre);
    }

    //default constructor
    public Amex(){
        super();
    }

    @Override
    public Double porcentajeTasa(LocalDate fecha) {
        Double currentMonth = Double.valueOf(fecha.getMonthValue());
        return (currentMonth*0.1)*0.01;
    }
}
