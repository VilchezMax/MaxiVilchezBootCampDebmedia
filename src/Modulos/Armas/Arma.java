package Modulos.Armas;

import Interfaces.IUtilidades;

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
        return this.getClass()+" "+this.getNombre()+", de ID="+this.getId()+"y con poder de ataque "+this.getPoderAtaque()+".";
    }
}
