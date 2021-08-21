package webapp.domain;

import java.time.LocalDate;

public class Nara extends MarcaTarjeta{

    public Nara(NombreMarca nombre) {
        super(nombre);
    }

    @Override
    public Double porcentajeTasa(LocalDate fecha) {
        Double currentDay = Double.valueOf(fecha.getDayOfMonth());
        return (currentDay/2)*0.01;
    }
}
