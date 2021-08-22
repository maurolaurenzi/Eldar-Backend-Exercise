package webapp.domain;

import com.sun.istack.NotNull;
import webapp.domain.MarcaTarjeta;
import webapp.domain.Operacion;
import webapp.domain.exceptions.TarjetaInvalidaException;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Tarjeta {
    @Id @GeneratedValue
    private Long id;
    @NotNull @Column(unique = true)
    private Integer numero;
    @NotNull
    private String nombreTitular;
    @NotNull
    private String apellidoTitutlar;
    @NotNull
    private LocalDate fechaVencimiento;
    @NotNull
    @ManyToOne
    private MarcaTarjeta marca;
    @OneToMany
    private Set<Operacion> operaciones = new HashSet<Operacion>();


    public Tarjeta(MarcaTarjeta marca,
                   Integer numero,
                   String nombreTitular,
                   String apellidoTitutlar,
                   LocalDate fechaVencimiento) throws TarjetaInvalidaException {
        this.numero = numero;
        this.nombreTitular = nombreTitular;
        this.apellidoTitutlar = apellidoTitutlar;
        if(fechaVencimiento.isAfter(LocalDate.now())) {
            this.fechaVencimiento = fechaVencimiento;
        }
        else{
            throw new TarjetaInvalidaException("Tarjeta Invalida. " +
                    "La fecha de vencimiento debe ser mayor a la fecha actual.");
        }
        this.marca = marca;
    }
    //default constructor
    public Tarjeta(){}

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getApellidoTitutlar() {
        return apellidoTitutlar;
    }

    public void setApellidoTitutlar(String apellidoTitutlar) {
        this.apellidoTitutlar = apellidoTitutlar;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public MarcaTarjeta getMarca() {
        return marca;
    }

    public void setMarca(MarcaTarjeta marca) {
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean esValida(){

        return fechaVencimiento.isAfter(LocalDate.now());
    }

    public String obtenerDatos(){
        String datos = "Numero: " + numero.toString() + ". Titular: " + nombreTitular + " " + apellidoTitutlar
                + ". Fecha de Vencimiento: " + fechaVencimiento.toString() +
                ". Marca: " + marca.getNombre().toString();
        return datos;
    }
}
