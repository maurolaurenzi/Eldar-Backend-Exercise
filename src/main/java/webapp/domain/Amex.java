package webapp.domain;

import java.time.LocalDate;

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
