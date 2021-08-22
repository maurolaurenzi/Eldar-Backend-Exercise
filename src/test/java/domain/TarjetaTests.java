package domain;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import webapp.domain.*;
import webapp.domain.exceptions.OperacionInvalidaException;
import webapp.domain.exceptions.TarjetaInvalidaException;

import java.time.LocalDate;

import static org.junit.Assert.assertTrue;

public class TarjetaTests {
    MarcaTarjeta visa;
    MarcaTarjeta nara;
    MarcaTarjeta amex;

    Tarjeta tarjetaVisa;
    Tarjeta tarjetaNara;
    Tarjeta tarjetaAmex;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Before
    public void init(){
        visa = new Visa(NombreMarca.VISA);
        LocalDate vencimientoVisa = LocalDate.of(2027,8,13);
        nara = new Nara(NombreMarca.NARA);
        LocalDate vencimientoNara = LocalDate.of(2023,8,13);
        amex = new Amex(NombreMarca.AMEX);

        tarjetaVisa = new Tarjeta(visa,432100000,"Juan","Doe",vencimientoVisa);
        tarjetaNara = new Tarjeta(nara,432199999,"Pepe","Gomez",vencimientoNara);

    }

    @Test
    public void tarjetasDeberianSerValidas(){
        assertTrue(tarjetaVisa.esValida());
        assertTrue(tarjetaNara.esValida());
    }

    @Test
    public void tarjetaAmexDeberiaSerInvalida(){
        exception.expect(TarjetaInvalidaException.class);
        exception.expectMessage("Tarjeta Invalida. La fecha de vencimiento " +
                "debe ser mayor a la fecha actual.");
        LocalDate vencimientoAmex = LocalDate.of(2020,8,13);
        tarjetaAmex = new Tarjeta(amex, 432177777,"Ana","Perez",vencimientoAmex);
    }
}
