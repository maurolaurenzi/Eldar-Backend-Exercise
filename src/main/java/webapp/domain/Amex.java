package webapp.domain;

import java.time.LocalDate;

public class Amex extends MarcaTarjeta{
    public Amex(NombreMarca nombre) {
        super(nombre);
    }

    @Override
    public Double tasaOperacion(Double importe) {
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        return importe*(currentMonth*0.1);
    }
}
