package Modulos;


import Modulos.Armas.Baculo;

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
    public double ataqueMagico(){
        return super.ataqueBasico() * this.arma.getPoderAtaque();
    }

    @Override
    public String toString() {
        if(this.arma!=null){
            return super.toString()+" y poder de ataque magico de "+this.ataqueMagico();
        } else {
            return super.toString();
        }
    }

}
