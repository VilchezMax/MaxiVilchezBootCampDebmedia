package Modulos;

import Modulos.Armas.Arco;
import Modulos.Armas.Arma;

import java.text.DecimalFormat;

public class Arquero extends Guerrero {
    //Atributos
    private Arco arma;

    //Constructores
    public Arquero(){
        super();
    }
    public Arquero(int id, String nombre, double fuerza) {
        super(id, nombre, fuerza);
    }

    public Arquero(int id, String nombre, double fuerza, Arco arma) {
        super(id, nombre, fuerza);
        this.arma = arma;
    }

    //Setters & Getters
    public Arco getArma() {
        return arma;
    }

    public void setArma(Arco arma) {
        this.arma = arma;
    }

    //Metodo
    @Override
    public double ataqueBasico() {
        if(this.arma!=null) {
            return super.ataqueBasico() * this.arma.getPoderAtaque();
        } else {
            return super.ataqueBasico();
        }
    }

    @Override
    public String toString() {
        final DecimalFormat df = new DecimalFormat("0.00");
        if(this.arma==null){
            return super.toString()+", sin arma.";
        } else {
            return super.toString()+" y poder de ataque basico de "+df.format(this.ataqueBasico())+" por su "+this.arma.getClass().getSimpleName();
        }
    }

}
