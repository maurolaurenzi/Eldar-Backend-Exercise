package webapp.domain;

import webapp.domain.MarcaTarjeta;
import webapp.domain.Operacion;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Entity
public class Tarjeta {
    @Id @GeneratedValue
    private Long id;
    private Integer numero;
    private String nombreTitular;
    private String apellidoTitutlar;
    private LocalDate fechaVencimiento;
    @ManyToOne
    private MarcaTarjeta marca;
    @OneToMany
    private Set<Operacion> operaciones = new HashSet<Operacion>();


    public Tarjeta(MarcaTarjeta marca, Integer numero, String nombreTitular, String apellidoTitutlar, LocalDate fechaVencimiento) {
        this.numero = numero;
        this.nombreTitular = nombreTitular;
        this.apellidoTitutlar = apellidoTitutlar;
        this.fechaVencimiento = fechaVencimiento;
        this.marca = marca;
    }

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
