package webapp.domain;

import java.time.LocalDate;

public class Visa extends MarcaTarjeta{

    public Visa(NombreMarca nombre) {
        super(nombre);
    }

    @Override
    public Double tasaOperacion(Double importe){
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int currentMonth = currentDate.getMonthValue();
        return importe*(currentYear/currentMonth);
    }
}
