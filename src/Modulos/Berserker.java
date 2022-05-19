package Modulos;

import Modulos.Armas.Arma;
import Modulos.Armas.Espada;

public class Berserker extends Guerrero{

    //Atributos
    private Espada espada;

    //Constructores
    public Berserker(int id, String nombre, double fuerza){
        super(id, nombre, fuerza);
    }

    public Berserker(int id, String nombre, double fuerza, Espada espada) {
        super(id, nombre, fuerza);
        this.espada = espada;
    }

    //Setters & Getters
    public Espada getEspada() {
        return espada;
    }

    public void setEspada(Espada espada) {
        this.espada = espada;
    }
}
