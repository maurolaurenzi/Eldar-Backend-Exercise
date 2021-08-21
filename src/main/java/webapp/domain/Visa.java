package webapp.domain;

import java.time.LocalDate;

public class Visa extends MarcaTarjeta{

    public Visa(NombreMarca nombre) {
        super(nombre);
    }

    @Override
    public Double porcentajeTasa(LocalDate fecha) {
        Double currentYear = Double.valueOf(fecha.getYear());
        Double currentMonth = Double.valueOf(fecha.getMonthValue());
        return ((currentYear%100)/currentMonth)*0.01;
    }

}
