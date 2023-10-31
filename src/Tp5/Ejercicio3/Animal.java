package Tp5.Ejercicio3;

public class Animal implements Runnable{
    private Comedero comedero;
    private String tipo;

    public Animal(Comedero comedero, String tipo){
        this.comedero = comedero;
        this.tipo = tipo;
    }

    public void comiendo(){
        System.out.println("El "+tipo+" esta comiendo");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("El "+tipo+ " termina de comer");
    }
    public void run(){
        comedero.comer(tipo);
        comiendo();
        comedero.terminaComer(tipo);
    }
    
}
