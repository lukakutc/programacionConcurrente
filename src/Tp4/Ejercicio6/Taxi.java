package Tp4.Ejercicio6;

import java.util.concurrent.Semaphore;

public class Taxi {
    //Esto es un problema de tipo rendez vous pues el taxista depende del pasajero y el pasajero del taxista
    //para lograr el funcionamiento

    //Los semaforos van en el recurso compartido
    //Un semaforo indica
    private Semaphore semTaxiLibre = new Semaphore(1);
    private Semaphore semTaxiDestino = new Semaphore(0);
    
    public void subirPasajero(){
        semTaxiLibre.release();
        System.out.println("Se subio un pasajero al taxi");
        System.out.println("....Viajando....");
        try {
            Thread.sleep(4000);
            System.out.println("El pasajero llego a destino. Taxista esperando");
            semTaxiDestino.acquire();
            esperarPasajero();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    public void esperarPasajero(){
        try {
            semTaxiLibre.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
