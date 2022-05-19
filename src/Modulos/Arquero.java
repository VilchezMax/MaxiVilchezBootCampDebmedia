package Modulos;

import Modulos.Armas.Arco;

public class Arquero extends Guerrero{
    //Atributos
    private Arco arco;

    //Constructores
    public Arquero(int id, String nombre, double fuerza){
        super(id, nombre, fuerza);
    }

    public Arquero(int id, String nombre, double fuerza, Arco arco) {
        super(id, nombre, fuerza);
        this.arco = arco;
    }

    //Setters & Getters
    public Arco getArco() {
        return arco;
    }

    public void setArco(Arco arco) {
        this.arco = arco;
    }
}
