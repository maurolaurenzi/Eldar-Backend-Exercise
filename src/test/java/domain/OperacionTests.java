package domain;

import org.junit.Test;
import webapp.domain.MarcaTarjeta;
import webapp.domain.NombreMarca;
import webapp.domain.Operacion;
import webapp.domain.Visa;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OperacionTests {
    @Test
    public void operacionDeberiaSerValida(){
        assertTrue(Operacion.esValida(5000.00));
    }
    @Test
    public void operacionDeberiaSerInvalida(){
        assertTrue(!Operacion.esValida(500.00));
    }
    @Test
    public void operacionConTasaEsperada(){
        MarcaTarjeta visa = new Visa(NombreMarca.VISA);
        LocalDate fechaTest = LocalDate.of(2021,8,21);
        assertEquals(Operacion.calcularTasa(visa,3000.00,fechaTest),78.75,0.01);
    }
}
