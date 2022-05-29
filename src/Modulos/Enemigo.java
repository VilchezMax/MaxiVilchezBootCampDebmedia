package Modulos;

public class Enemigo {
    //Atributos--------------------------
    private int vida;

    //Constructor-----------------------
    public Enemigo(){
        this.vida = (int) (Math.random()*10);
    }
    public Enemigo(int vida) {
        this.vida = vida;
    }

    //Setter & getter---------------------
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

}
