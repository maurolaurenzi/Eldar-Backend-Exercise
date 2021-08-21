package webapp.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
//@DiscriminatorValue("NARA")
public class Nara extends MarcaTarjeta {

    public Nara(NombreMarca nombre) {

        super(nombre);
    }
    //default constructor
    public Nara(){
        super();
    }

    @Override
    public Double porcentajeTasa(LocalDate fecha) {
        Double currentDay = Double.valueOf(fecha.getDayOfMonth());
        return (currentDay/2)*0.01;
    }
}
