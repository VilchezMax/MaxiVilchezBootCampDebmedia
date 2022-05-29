package Modulos;

import Modulos.Armas.Arco;
import Modulos.Armas.Arma;
import Modulos.Armas.Espada;

import java.text.DecimalFormat;

public class Berserker extends Guerrero{

    //Atributos
    private Espada arma;

    //Constructores

    public Berserker() {
        super();
    }

    public Berserker(int id, String nombre, double fuerza){
        super(id, nombre, fuerza);
    }

    public Berserker(int id, String nombre, double fuerza, Espada arma) {
        super(id, nombre, fuerza);
        this.arma = arma;
    }

    //Setters & Getters
    public Espada getArma() {
        return arma;
    }

    public void setArma(Espada arma) {
        this.arma = arma;
    }

    //Metodo
    @Override
    public double ataqueBasico() {
        return super.ataqueBasico() * this.arma.getPoderAtaque();
    }

    @Override
    public String toString() {
        final DecimalFormat df = new DecimalFormat("0.00");
        if(this.arma!=null){
            return super.toString()+" y poder de ataque basico de "+df.format(this.ataqueBasico());
        } else {
            return super.toString()+" y no tiene arma.";
        }
    }


}
