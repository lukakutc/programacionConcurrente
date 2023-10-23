package Tp4.Ejercicio6;

import java.util.concurrent.Semaphore;

public class Taxi {
    // Esto es un problema de tipo rendez vous pues el taxista depende del pasajero
    // y el pasajero del taxista
    // para lograr el funcionamiento

    // Los semaforos van en el recurso compartido
    // semLlegadaDestino es para que el taxista le comunique al pasajero cuando
    // llego
    // semTaxista es para que el pasajero despierte al taxi cuando se sube
    private Semaphore semLlegadaDestino = new Semaphore(0);
    private Semaphore semTaxista = new Semaphore(0);

    public void esperarPasajero() {
        try {
            semTaxista.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Se desperto el taxista");
    }

    public void llegarDestino(){
        System.out.println("Se llego a destino");
        semLlegadaDestino.release();
        
    }

    public void subirPasajero(){
        System.out.println("Se subio un pasajero");
        semTaxista.release();
    }
    public void bajarPasajero(){
        try {
            semLlegadaDestino.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Se bajo el pasajero");
    }
    

}