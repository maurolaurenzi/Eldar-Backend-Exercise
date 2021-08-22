package webapp.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import webapp.domain.*;
import webapp.repositories.RepositorioMarcaTarjetas;
import webapp.repositories.RepositorioOperaciones;
import webapp.repositories.RepositorioTarjetas;

import java.time.LocalDate;

@Component //this should be detected by Spring as a Spring-managed component in which we perform JPA operations
public class BootStrapData implements CommandLineRunner {
    private final RepositorioTarjetas repositorioTarjetas;
    private final RepositorioMarcaTarjetas repositorioMarcaTarjetas;
    private final RepositorioOperaciones repositorioOperaciones;

    public BootStrapData(RepositorioTarjetas repositorioTarjetas,
                         RepositorioMarcaTarjetas repositorioMarcaTarjetas,
                         RepositorioOperaciones repositorioOperaciones) {
        this.repositorioTarjetas = repositorioTarjetas;
        this.repositorioMarcaTarjetas = repositorioMarcaTarjetas;
        this.repositorioOperaciones = repositorioOperaciones;
    }

    @Override
    public void run(String... args) throws Exception {
        MarcaTarjeta visa;
        MarcaTarjeta nara;
        MarcaTarjeta amex;

        Tarjeta tarjetaVisa;
        Tarjeta tarjetaNara;
        Tarjeta tarjetaAmex;

        Operacion compra;

        visa = new Visa(NombreMarca.VISA);
        LocalDate vencimientoVisa = LocalDate.of(2027,8,13);
        nara = new Nara(NombreMarca.NARA);
        LocalDate vencimientoNara = LocalDate.of(2023,8,13);
        amex = new Amex(NombreMarca.AMEX);
        LocalDate vencimientoAmex = LocalDate.of(2025,8,13);

        tarjetaVisa = new Tarjeta(visa,432100000,"Juan","Doe",vencimientoVisa);
        tarjetaNara = new Tarjeta(nara,432199999,"Pepe","Gomez",vencimientoNara);
        tarjetaAmex = new Tarjeta(amex, 432177777,"Ana","Perez",vencimientoAmex);

        compra = new Operacion(tarjetaNara, LocalDate.now(), 7000.00);

        repositorioMarcaTarjetas.save(visa);
        repositorioMarcaTarjetas.save(nara);
        repositorioMarcaTarjetas.save(amex);

        repositorioTarjetas.save(tarjetaVisa);
        repositorioTarjetas.save(tarjetaNara);
        repositorioTarjetas.save(tarjetaAmex);

        repositorioOperaciones.save(compra);

        System.out.println("Iniciando Aplicacion...");
        System.out.println("Cantidad de tarjetas en sistema: " + repositorioTarjetas.count());
        System.out.println("Cantidad de marcas en sistema: " + repositorioMarcaTarjetas.count());

        System.out.println("Obteniendo toda la informacion sobre una tarjeta: "
                + tarjetaVisa.obtenerDatos());

        System.out.println("Compra por $" + compra.getMonto() + " es valida: "
                + compra.esValida(7000.00));

        System.out.println("Tarjeta Amex con vencimiento: " + tarjetaAmex.getFechaVencimiento().toString()
                + " es valida: " + tarjetaAmex.esValida());

        System.out.println("Tarjeta Amex y Tarjeta Visa son iguales: "
                + tarjetaAmex.equals(tarjetaVisa));

        System.out.println("Calculamos Tasa para AMEX con importe de $2000.00: "
                + Operacion.calcularTasa(amex, 2000.00, LocalDate.now()));

    }
}
