package domain;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import webapp.domain.*;
import webapp.domain.exceptions.OperacionInvalidaException;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OperacionTests {
    MarcaTarjeta visa = new Visa(NombreMarca.VISA);
    Tarjeta tarjetaVisa = new Tarjeta(visa,
            432155555,
            "Juan",
            "Perez",
            LocalDate.of(2024,7,6));
    Operacion operacion;

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void operacionDeberiaSerValida(){
        Operacion operacion = new Operacion(tarjetaVisa,LocalDate.now(),500.00);
        assertTrue(operacion.esValida());
    }
    @Test
    public void operacionDeberiaSerInvalida(){
        exception.expect(OperacionInvalidaException.class);
        exception.expectMessage("Operacion Invalida. El monto debe ser menor a $1000");
        Operacion operacion = new Operacion(tarjetaVisa,LocalDate.now(),5000.00);
    }
    @Test
    public void operacionConTasaEsperada(){
        MarcaTarjeta visa = new Visa(NombreMarca.VISA);
        LocalDate fechaTest = LocalDate.of(2021,8,21);
        assertEquals(Operacion.calcularTasa(visa,300.00,fechaTest),7.87,0.01);
    }
}
