package Modulos;

import Modulos.Armas.Arco;
import Modulos.Armas.Arma;

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
        return super.ataqueBasico() * this.arma.getPoderAtaque();
    }

    @Override
    public String toString() {
        if(this.arma!=null){
            return super.toString()+" y poder de ataque basico de "+this.ataqueBasico();
        } else {
            return super.toString();
        }
    }

}
