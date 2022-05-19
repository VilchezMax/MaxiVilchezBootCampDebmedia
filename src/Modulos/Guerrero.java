package Modulos;

public abstract class Guerrero {
    //Atributos
    private int id;
    private String nombre;
    private double fuerza;

    //Constructores

    public Guerrero(int id, String nombre, double fuerza) {
        this.id = id;
        this.nombre = nombre;
        this.fuerza = fuerza;
    }

    //Setters & Getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getFuerza() {
        return fuerza;
    }

    public void setFuerza(double fuerza) {
        this.fuerza = fuerza;
    }

    //Metodos
    public double ataqueBasico(){
        return this.fuerza * arma.poderAtaque;
    }
}
