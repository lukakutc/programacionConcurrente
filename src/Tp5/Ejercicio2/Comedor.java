package Tp5.Ejercicio2;

import java.util.concurrent.Semaphore;

public class Comedor {
    //Recurso compartido
    //se inicializa en 2 porque hay 2 lugares
    Semaphore semLugares = new Semaphore(2);
    Semaphore semMozo = new Semaphore(0);
    Semaphore semCocinero = new Semaphore(0);

    public void llegaPersona(){
        try {
            semLugares.acquire();
            System.out.println("Llega un empleado  y se sienta. Ocupa un lugar");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void salePersona(){
        System.out.println("Sale un empleado del comedor y libera un lugar");
        semLugares.release();
    }

    
}
