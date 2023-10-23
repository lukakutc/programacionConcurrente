package Tp4.Ejercicio6;

public class Pasajero implements Runnable {
    private Taxi taxi;

    
    public Pasajero(Taxi taxi) {
        this.taxi = taxi;
    }

    public void run(){
        //Subirse al taxi (despertar al taxista)
        //ESPERAR a llegar a destino (adquirir s)
        //bajarse (liberar al taxista)
       taxi.subirPasajero();
       taxi.bajarPasajero();

    }
    
}
