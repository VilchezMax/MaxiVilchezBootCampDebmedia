import Modulos.*;
import Modulos.Armas.*;

import java.util.*;


public class main {
    static Scanner teclado = new Scanner(System.in);
    static List<Guerrero> ejercito=new ArrayList<>();
    static List<Arma> armeria=new ArrayList<>();

    public static void main(String[] args) {
        cargarArmeria();
    }

    public static void cargarArma(Guerrero warrior,Arma weapon) {
        if (warrior.getClass()==Berserker.class && weapon.getClass()==Espada.class) {
            warrior.setArma(weapon);
        }else if (warrior.getClass()==Arquero.class && weapon.getClass()==Arco.class) {
            warrior.setArma(weapon);
        }else if (warrior.getClass()==Mago.class && weapon.getClass()==Baculo.class) {
            warrior.setArma(weapon);
        }else {
            System.out.println("Soy un "+warrior.getClass()+" y solo uso "+weapon.getClass());
        }
    } //TODO aunque se podria mejorar el input, quizas un try catch

    public static void cargarEjercito() throws InputMismatchException{
        int clase;
        String nombre = null;
        System.out.println("Seleccione la clase del guerrero a agregar: 1-Berserker 2-Arquero 3-Mago / Otro numero para dejar de cargar");
        try {
            clase = teclado.nextInt();
            do {

                System.out.println("Como se llama?");
                try {
                    nombre=teclado.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Ingrese un nombre "+e.getMessage());
                }
                switch (clase) {
                case 1:
                    Berserker nuevoBerserker = new Berserker();
                    nuevoBerserker.setNombre(nombre); //  El unico parametro ingresado es nombre porque se utilizo
                    ejercito.add(nuevoBerserker);     //  el constructor que genera valores aleatorios de ID y Fuerza
                    break;
                case 2: //Arquero
                    Arquero nuevoArquero = new Arquero();
                    nuevoArquero.setNombre(nombre);
                    ejercito.add(nuevoArquero);
                    break;
                case 3: //Mago
                    Mago nuevoMago = new Mago();
                    nuevoMago.setNombre(nombre);
                    ejercito.add(nuevoMago);
                    break;
                default:
                    break;
                }
                System.out.println("Seleccione la clase del guerrero a agregar: 1-Berserker 2-Arquero 3-Mago / Otro numero para dejar de cargar");
                clase = teclado.nextInt();
            } while (clase>=1 || clase<=3);
        } catch (InputMismatchException e) {
            System.out.println("Ingrese 1,2 o 3" + e.getMessage() + "\n");
        }
        System.out.print("El ejercito se compone de los siguientes guerreros:");
        Iterator it = ejercito.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    } // DONE

    public static void cargarArmeria() {
        int arma;
        String nombre = null;
        System.out.println("Seleccione el tipo de arma a agregar: 1-Espada 2-Arco 3-Baculo / Otro numero para dejar de cargar");
        try {
            arma = teclado.nextInt();
            do {
                System.out.println("Como se llama el arma?");
                nombre = teclado.nextLine();
                switch (arma) {
                    case 1:
                        Espada nuevaEspada = new Espada();
                        nuevaEspada.setNombre(nombre); //  El unico parametro ingresado es nombre porque se utilizo
                        armeria.add(nuevaEspada);     //  el constructor que genera valores aleatorios de ID y Fuerza
                        break;
                    case 2: //Arquero
                        Arco nuevoArco = new Arco();
                        nuevoArco.setNombre(nombre);
                        armeria.add(nuevoArco);
                        break;
                    case 3: //Mago
                        Baculo nuevoBaculo = new Baculo();
                        nuevoBaculo.setNombre(nombre);
                        armeria.add(nuevoBaculo);
                        break;
                    default:
                        break;
                }
                System.out.println("Seleccioneel tipo de arma a agregar: 1-Espada 2-Arco 3-Baculo / Otro numero para dejar de cargar");
                arma = teclado.nextInt();
            } while (arma >= 1 || arma <= 3);
        } catch (InputMismatchException e) {
            System.out.println("Ingrese 1,2 o 3" + e.getMessage() + "\n");
        }
        System.out.print("La armeria se compone de las siguientes armas:");
        Iterator it = armeria.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    } //TODO ESTA MAL, DE "COMO SE LLAMA" SALTA A NUEVA OPCION.

    public static void equiparEjercito(List<Guerrero> ejercito, List<Arma> armeria){
        for (Guerrero guerrero:ejercito){
            while (!armeria.isEmpty()){
                if(guerrero.getClass()==Berserker.class && armeria.contains(Espada.class)){
                    guerrero.setArma(armeria.get(armeria.indexOf(Espada.class)));
                    armeria.remove(armeria.indexOf(Espada.class));
                } else if (guerrero.getClass()==Arquero.class && armeria.contains(Arco.class)){
                    guerrero.setArma(armeria.get(armeria.indexOf(Arco.class)));
                    armeria.remove(armeria.indexOf(Arco.class));
                } else if (guerrero.getClass()==Mago.class && armeria.contains(Baculo.class)){
                    guerrero.setArma(armeria.get(armeria.indexOf(Baculo.class)));
                    armeria.remove(armeria.indexOf(Baculo.class));
                }
            }
        }
    }

    public static void matarEnemigo(Guerrero warrior, Enemigo enemy){
        double resultadoAtaque;
        if (warrior.getClass()==Mago.class){
            resultadoAtaque = ((Mago) warrior).ataqueMagico();
        } else {
            resultadoAtaque = warrior.ataqueBasico();
        }
        if (enemy.getVida() - resultadoAtaque<=0) {
            enemy.setVida(0);
            System.out.println(" _______    ___   .___________.    ___       __       __  .___________.____    ____ \n" +
                    "|   ____|  /   \\  |           |   /   \\     |  |     |  | |           |\\   \\  /   / \n" +
                    "|  |__    /  ^  \\ `---|  |----`  /  ^  \\    |  |     |  | `---|  |----` \\   \\/   /  \n" +
                    "|   __|  /  /_\\  \\    |  |      /  /_\\  \\   |  |     |  |     |  |       \\_    _/   \n" +
                    "|  |    /  _____  \\   |  |     /  _____  \\  |  `----.|  |     |  |         |  |     \n" +
                    "|__|   /__/     \\__\\  |__|    /__/     \\__\\ |_______||__|     |__|         |__|     \n" +
                    "                                                                                    ");
            System.out.println("El enemigo murio!");
        }else {
            System.out.println("EL enemigo quedo con "+(enemy.getVida() - resultadoAtaque)+" puntos de vida." );
        }
    }// DONE

    public static void resultadoDeArmeria(){
        System.out.println( "-----------------------------------------------------------"+"\n"+
                            armeria.size()+" armas no fueron equipadas.");
        System.out.println("-----------------------------------------------------------"+"\n"+
                            "Los siguientes guerreros no obtuvieron armas: ");
        for(Guerrero guerrero:ejercito){
            if(guerrero.getArma()!=null){
                System.out.println(guerrero.toString());
            }
        }
    }

}
