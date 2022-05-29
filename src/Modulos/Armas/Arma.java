package Modulos.Armas;

import Interfaces.IUtilidades;

import java.text.DecimalFormat;

public abstract class Arma implements IUtilidades {
    //Atributos
    private int id;
    private String nombre;
    private double poderAtaque;
    //Constructores
    public Arma(){
        this.id= IUtilidades.idRandom();
        this.nombre= "Arma basica";
        this.poderAtaque= (Math.random()*100);
    }

    public Arma(int id, String nombre, double poderAtaque) {
        this.id = id;
        this.nombre = nombre;
        this.poderAtaque = poderAtaque;
    }


    //Setters & getters

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

    public double getPoderAtaque() {
        return poderAtaque;
    }

    public void setPoderAtaque(double poderAtaque) {
        this.poderAtaque = poderAtaque;
    }

    //Metodos


    @Override
    public String toString() {
        final DecimalFormat df = new DecimalFormat("0.00");
        return "(ID "+this.getId()+") - "+this.getClass().getSimpleName()+" "+this.getNombre()+" con poder de ataque "+df.format(this.getPoderAtaque())+".";
    }
}
