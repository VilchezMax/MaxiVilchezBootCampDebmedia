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

        Guerrero thor = new Berserker();
        thor.setNombre("Thor");
        Espada mjolnir = new Espada(99,"Mjolnir",9999.99);
        cargarArma(thor,mjolnir);
        Enemigo jefe = new Enemigo();
        matarEnemigo(thor,jefe);

    }

    public static void cargarArma(Guerrero guerrero,Arma arma) {

        if (guerrero.getClass()==Berserker.class){
            if(arma.getClass()==Espada.class) {
                guerrero.setArma(arma);
            } else {
                System.out.println("Soy un "+guerrero.getClass().getSimpleName()+" y solo uso Espada");
            }
        } else if (guerrero.getClass()==Arquero.class){
            if(arma.getClass()==Arco.class) {
                guerrero.setArma(arma);
            } else {
                System.out.println("Soy un "+guerrero.getClass().getSimpleName()+" y solo uso Arco");
            }
        } else if (guerrero.getClass()==Mago.class){
            if(arma.getClass()==Baculo.class){
                guerrero.setArma(arma);
            } else {
            System.out.println("Soy un "+guerrero.getClass().getSimpleName()+" y solo uso Arco");
            }
        }
        System.out.println(guerrero.getClass().getSimpleName()+" "+guerrero.getNombre()+" recibio "+arma.toString());
    }

    public static void cargarEjercito() throws InputMismatchException {
        int clase;
        String nombre = null;
        System.out.println("Seleccione la clase del guerrero a agregar: 1-Berserker 2-Arquero 3-Mago / Otro numero para dejar de cargar");
        try {
            clase = teclado.nextInt();
            do {

                System.out.println("Como se llama?");
                try {
                    teclado.nextLine();
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
        System.out.print("El ejercito se compone de los siguientes guerreros:"+ "\n");
        for(Guerrero guerrero:ejercito){
            System.out.println(guerrero.toString());
        }
        System.out.println("------------------- o -------------------");
    }

    public static List<Arma> cargarArmeria()throws InputMismatchException {
        int arma;
        String nombre;
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
                System.out.println("Seleccione el tipo de arma a agregar: 1-Espada 2-Arco 3-Baculo / Otro numero para dejar de cargar");
                arma = teclado.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Ingrese 1,2 o 3" + e.getMessage() + "\n");
        }
        System.out.print("La armeria se compone de las siguientes armas:"+ "\n");
        for (Arma arma1 : armeria){
            System.out.println(arma1.toString());
        }
        System.out.println("------------------- o -------------------");

        return armeria;
    }

    public static void equiparEjercito(List<Guerrero> ejercito, List<Arma> armeria) {
        System.out.println("Equipando ejercito..."+"\n"+"---o---");
        LinkedList<Espada> espadas = new LinkedList<>();
        LinkedList<Arco> arcos = new LinkedList<>();
        LinkedList<Baculo> baculos = new LinkedList<>();

        for (Arma arma : armeria){
            if (arma instanceof Espada) {
                espadas.addLast((Espada) arma);
            } else if (arma instanceof Arco){
                arcos.addLast((Arco) arma);
            } else if (arma instanceof Baculo){
                baculos.addLast((Baculo) arma);
            }
        }

        for (Guerrero guerrero: ejercito){
            Arma nueva;
            if (guerrero.getClass() == Berserker.class && !espadas.isEmpty()){
                nueva=espadas.getLast();
                Espada nuevaArma= new Espada(nueva.getId(),nueva.getNombre(),nueva.getPoderAtaque());
                ((Berserker)guerrero).setArma(nuevaArma);
                System.out.println(guerrero.getClass().getSimpleName()+" "+guerrero.getNombre()+" recibio:"+"\n"+
                        nuevaArma.getClass().getSimpleName()+ " "+nuevaArma.getNombre()+"\n"+"---o---");
                armeria.remove((espadas.pollLast()));

            } else if (guerrero.getClass() == Arquero.class && !arcos.isEmpty()){
                nueva=arcos.getLast();
                Arco nuevaArma= new Arco(nueva.getId(),nueva.getNombre(),nueva.getPoderAtaque());
                ((Arquero) guerrero).setArma(nuevaArma);
                System.out.println(guerrero.getClass().getSimpleName()+" "+guerrero.getNombre()+" recibio:"+"\n"+
                        nuevaArma.getClass().getSimpleName()+ " "+nuevaArma.getNombre()+"\n"+"---o---");
                armeria.remove((arcos.pollLast()));

            } else if (guerrero.getClass() == Mago.class && !baculos.isEmpty()){
                nueva=baculos.getLast();
                Baculo nuevaArma= new Baculo(nueva.getId(),nueva.getNombre(),nueva.getPoderAtaque());
                ((Mago)guerrero).setArma(nuevaArma);
                System.out.println(guerrero.getClass().getSimpleName()+" "+guerrero.getNombre()+" recibio :"+"\n"+
                        nuevaArma.getClass().getSimpleName()+ " "+nuevaArma.getNombre()+"\n"+"---o---");
                armeria.remove((baculos.pollLast()));
            }
        }
        System.out.println("Ejercito equipado."+"\n"+"------------------------------------------------");

    }

    public static void matarEnemigo(Guerrero guerrero, Enemigo enemy){
        double resultadoAtaque;
        System.out.println("--------------- o ---------------"+"\n" +
                guerrero.getClass().getSimpleName()+" "+guerrero.getNombre()+" ataco a "+enemy.getClass().getSimpleName());
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
            System.out.println("El enemigo murio!" +"\n"+ "--------------- o ---------------" );
        }else {
            System.out.println("EL enemigo quedo con "+(enemy.getVida() - resultadoAtaque)+" puntos de vida." );
        }
    }

    public static void resultadoDeArmeria(){
        System.out.println( "-----------------------------------------------------------"+"\n"+
                            "Total de armas sin equipar: " + armeria.size());
        System.out.println("-----------------------------------------------------------" + "\n" +
                "Guerreros sin equipar: ");
        boolean ninguno=true;
        for(Guerrero guerrero:ejercito){
            if(guerrero.getArma() == null){
                System.out.println(guerrero.toString());
                ninguno=false;
            }
        }

        if(ninguno){
            System.out.println("0. Todos los guerreros obtuvieron armas");
        }
    }

}
