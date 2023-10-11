package Tp3.Ejercicio3;

public class Jaula {
    //Recurso compartido
    
    //Los metodos llevan syncronized porque solo un hamster puede estar haciendo una cosa.
    
    //constructor
    public Jaula(){

    }

    //plato comida
    public synchronized void plato (){
        System.out.println("El hamster "+Thread.currentThread().getName()+" esta comiendo del plato");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    
    }
    //rueda
    public synchronized void rueda(){
        System.out.println("El hamster "+Thread.currentThread().getName()+" esta corriendo en la rueda");
        try{
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //hamaca

    public synchronized void hamaca(){
        System.out.println("El hamster "+Thread.currentThread().getName()+" esta reposando en la hamaca");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
