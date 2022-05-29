package Interfaces;

public interface IUtilidades {
    public static int idRandom(){
        return (int) (Math.random()*1000);
    }
    public static double fuerzaRandom(){ return Math.random()*10;}
}
