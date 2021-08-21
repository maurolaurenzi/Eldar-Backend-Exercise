package webapp.domain;

public abstract class MarcaTarjeta {
    private NombreMarca nombre;

    public MarcaTarjeta(NombreMarca nombre) {
        this.nombre = nombre;
    }

    public abstract Double tasaOperacion(Double importe);
}
