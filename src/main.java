import Modulos.*;
import Modulos.Armas.*;

import java.text.DecimalFormat;
import java.util.*;


public class main {
    static Scanner teclado = new Scanner(System.in);
    static List<Guerrero> ejercito=new ArrayList<>();
    static List<Arma> armeria=new ArrayList<>();
    public final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        cargarArmeria();
        cargarEjercito();
        equiparEjercito(ejercito,armeria);
        resultadoDeArmeria();

        Berserker reyArturo = new Berserker();
        Espada excalibur = new Espada();
        cargarArma(reyArturo,excalibur);
        Enemigo jefe = new Enemigo();
        matarEnemigo(reyArturo,jefe);

    }

    public static void cargarArma(Guerrero guerrero,Arma arma) {
        if (guerrero.getClass()==Berserker.class && arma.getClass()==Espada.class) {
            guerrero.setArma(arma);
        }else if (guerrero.getClass()==Arquero.class && arma.getClass()==Arco.class) {
            guerrero.setArma(arma);
        }else if (guerrero.getClass()==Mago.class && arma.getClass()==Baculo.class) {
            guerrero.setArma(arma);
        }else {
            System.out.println("Soy un "+guerrero.getClass().getSimpleName()+" y solo uso "+arma.getClass());
        }
    }

    public static List<Guerrero> cargarEjercito() throws InputMismatchException {
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
            } while (clase>=1 && clase<=3);
        } catch (InputMismatchException e) {
            System.out.println("Ingrese 1,2 o 3" + e.getMessage() + "\n");
        }
        System.out.print("El ejercito se compone de los siguientes guerreros:");
        Iterator it = ejercito.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        return ejercito;
    }

    public static List<Arma> cargarArmeria()throws InputMismatchException {
        int arma;
        String nombre = null;
        System.out.println("Seleccione el tipo de arma a agregar: 1-Espada 2-Arco 3-Baculo / Otro numero para dejar de cargar");
        try {
            arma = teclado.nextInt();
            while (arma >= 1 && arma <= 3) {
                teclado.nextLine();
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
            }
        } catch (InputMismatchException e) {
            System.out.println("Ingrese 1,2 o 3" + e.getMessage() + "\n");
        }
        System.out.print("La armeria se compone de las siguientes armas:"+ "\n");
        Iterator it = armeria.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return armeria;
    }

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

    public static void matarEnemigo(Guerrero guerrero, Enemigo enemy){
        double resultadoAtaque;
        if (guerrero.getClass()==Mago.class){
            resultadoAtaque = ((Mago) guerrero).ataqueMagico();
        } else {
            resultadoAtaque = guerrero.ataqueBasico();
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
    }

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
