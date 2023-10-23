package Tp4.Ejercicio6;

public class Taxista implements Runnable {
    private Taxi taxi;

    
    public Taxista(Taxi taxi) {
        this.taxi = taxi;
    }
   
    public void viajar(){
        System.out.println("El taxi esta en camino a destino, taxista conduciendo");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void run(){
        //Esperar pasajero
        //Viajar (sleep)
        //Llegar 
        taxi.esperarPasajero();
        viajar();
        taxi.llegarDestino();
    }
}
