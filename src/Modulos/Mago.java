package Modulos;


import Modulos.Armas.Baculo;

public class Mago extends Guerrero {
    //Atributo
    private Baculo baculo;

    //Constructores
    public Mago(int id, String nombre, double fuerza){
        super(id, nombre, fuerza);
    }

    public Mago(int id, String nombre, double fuerza, Baculo baculo) {
        super(id, nombre, fuerza);
        this.baculo = baculo;
    }

    //Setters & Getters
    public Baculo getBaculo() {
        return baculo;
    }

    public void setBaculo(Baculo baculo) {
        this.baculo = baculo;
    }

    //Metodos
    public double ataqueMagico(){
        return getFuerza() * baculo.poderAtaque;
    }

}
