package Modulos;


import Modulos.Armas.Baculo;

import java.text.DecimalFormat;

public class Mago extends Guerrero {
    //Atributo
    private Baculo arma;

    //Constructores
    public Mago(){
        super();
    }
    public Mago(int id, String nombre, double fuerza){
        super(id, nombre, fuerza);
    }

    public Mago(int id, String nombre, double fuerza, Baculo arma) {
        super(id, nombre, fuerza);
        this.arma = arma;
    }

    //Setters & Getters
    public Baculo getArma() {
        return arma;
    }

    public void setArma(Baculo arma) {
        this.arma = arma;
    }

    //Metodo
    public double ataqueBasico() {return super.ataqueBasico(); }
    public double ataqueMagico() {
        if(this.arma!=null) {
            return super.ataqueBasico() * this.arma.getPoderAtaque();
        } else {
            return ataqueBasico();
        }
    }

    @Override
    public String toString() {
        final DecimalFormat df = new DecimalFormat("0.00");
        if(this.arma==null){
            return super.toString()+", sin arma.";
        } else {
            return super.toString()+" y poder de ataque basico de "+df.format(this.ataqueMagico())+" por su "+this.arma.getClass().getSimpleName();
        }
    }

}
