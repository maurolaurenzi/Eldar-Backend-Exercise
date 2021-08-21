package domain;

import org.junit.Before;
import org.junit.Test;
import webapp.domain.*;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MarcaTarjetaTests {
    MarcaTarjeta visa;
    MarcaTarjeta nara;
    MarcaTarjeta amex;

    @Before
    public void init(){
        visa = new Visa(NombreMarca.VISA);
        nara = new Nara(NombreMarca.NARA);
        amex = new Amex(NombreMarca.AMEX);
    }

    @Test
    public void tasasDeOperacionEsperadas(){
        LocalDate fechaTest = LocalDate.of(2021,8,21);
        assertEquals(visa.tasaOperacion(3000.00, fechaTest),78.75,0.01);
        assertEquals(nara.tasaOperacion(3000.00, fechaTest),315.0,0.1);
        assertEquals(amex.tasaOperacion(3000.00, fechaTest),24.0,0.1);
    }
}
