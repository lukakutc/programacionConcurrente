package Tp3.Ejercicio3;

public class Hamster implements Runnable {
    //recurso compartido
    private Jaula jaula;

    //constructor
    public Hamster(Jaula jaula){
        this.jaula = jaula;
    }
    
    public void correr(){
        jaula.rueda();
    }
    
    public void comer(){
        jaula.plato();
    }
    
    public void descansar(){
        jaula.hamaca();
    }

    public void run(){
        correr();
        comer();
        descansar();
    }
}
