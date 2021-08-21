package webapp.domain;

import java.time.LocalDate;

public class Nara extends MarcaTarjeta{

    public Nara(NombreMarca nombre) {
        super(nombre);
    }

    @Override
    public Double tasaOperacion(Double importe) {
        LocalDate currentDate = LocalDate.now();
        int currentDay = currentDate.getDayOfMonth();
        return importe*(currentDay/2);
    }
}
