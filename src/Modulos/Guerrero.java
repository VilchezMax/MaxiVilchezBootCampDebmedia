package Modulos;


import Modulos.Armas.Arma;

import java.text.DecimalFormat;

public abstract class Guerrero {
    //Atributos
    private int id;
    private String nombre;
    private double fuerza;
    private Arma arma; //Agrego este atributo aunque no estaba en el diagrama xq facilita mucho el uso del metodo cargarArma(Guerrero,Arma)

    //Constructores
    public Guerrero(){
        this.id= (int) (Math.random()*1000);
        this.nombre= "NN";
        this.fuerza= Math.random()*100;
        this.arma=null;
    }
    public Guerrero(int id, String nombre, double fuerza) {
        this.id = id;
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.arma=null;
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

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    //Metodos
    // Éste me hubiese gustado que lo hagan abstracto, y que no tengamos una implementacion acá.
    public double ataqueBasico(){
        return this.fuerza;
    }

    @Override
    public String toString() {
        final DecimalFormat df = new DecimalFormat("0.00");
        return "(ID "+this.getId()+") - "+this.getNombre()+", "+this.getClass().getSimpleName()+" con una fuerza de "+df.format(this.getFuerza())+" puntos ";
    }
}
