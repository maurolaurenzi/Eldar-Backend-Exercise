package webapp.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="marca",
        discriminatorType = DiscriminatorType.STRING)
public abstract class MarcaTarjeta {
    @Id @GeneratedValue
    private Long id;
    @Transient
    private NombreMarca nombre;

    public MarcaTarjeta(NombreMarca nombre) {

        this.nombre = nombre;
    }
    //se pasa la fecha por parametro para realizar tests con fechas fijas
    public abstract Double porcentajeTasa(LocalDate fecha);

    public Double tasaOperacion(Double importe, LocalDate fecha){
        return importe*porcentajeTasa(fecha);
    }
}
