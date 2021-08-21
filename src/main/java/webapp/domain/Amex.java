package webapp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("AMEX")
public class Amex extends MarcaTarjeta {
    public Amex(NombreMarca nombre) {
        super(nombre);
    }

    @Override
    public Double porcentajeTasa(LocalDate fecha) {
        Double currentMonth = Double.valueOf(fecha.getMonthValue());
        return (currentMonth*0.1)*0.01;
    }
}
