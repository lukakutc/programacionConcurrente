package Tp4.Ejercicio7;

public class Empleado implements Runnable {
    //Hilo
    private Confiteria confiteria;

    public Empleado(Confiteria confiteria) {
        this.confiteria = confiteria;
    }

    public void sentarse(){
        confiteria.sentarse();
        System.out.println("El empleado "+Thread.currentThread().getName()+" se sienta en la mesa");   
    }
    public void pedirAlMozo(){
        System.out.println("El empleado "+Thread.currentThread().getName()+" le pide al mozo");
        confiteria.pedirAlMozo();
    }
    public void comer(){
        confiteria.comer();
        System.out.println("El empleado "+Thread.currentThread().getName()+" esta comiendo");
    }
    public void irse(){
        System.out.println("El empleado "+Thread.currentThread().getName()+" deja el lugar");
        confiteria.irse();
    } 
 
    public void run(){
        sentarse();
        pedirAlMozo();
        comer();
        irse();
             
    }
    
}
