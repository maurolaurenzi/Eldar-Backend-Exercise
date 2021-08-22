package webapp.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MarcaTarjeta {
    @Id @GeneratedValue
    private Long id;
    @Enumerated(EnumType.STRING)
    private NombreMarca nombre;

    public MarcaTarjeta(NombreMarca nombre) {
        this.nombre = nombre;
    }

    //default constructor
    public MarcaTarjeta(){}

    public NombreMarca getNombre() {

        return nombre;
    }

    public void setNombre(NombreMarca nombre) {

        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //decido pasar la fecha por parametro para poder realizar tests con fechas fijas
    public abstract Double porcentajeTasa(LocalDate fecha);

    public Double tasaOperacion(Double importe, LocalDate fecha){

        return importe*porcentajeTasa(fecha);
    }


}
