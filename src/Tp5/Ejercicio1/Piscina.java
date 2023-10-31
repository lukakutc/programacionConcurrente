package Tp5.Ejercicio1;

import java.util.concurrent.Semaphore;

public class Piscina {
    //Recurso compartido
    //semCapacidad es el semafor que indica cuantos lugares libres hay en la piscina
    Semaphore semCapacidad = new Semaphore(10);
    //En este caso la capacidad de las piscina es de 10 personas

    public void entraPersona(){
        
        try {
            semCapacidad.acquire();
            System.out.println("Entra una persona a la piscina");
        } catch (InterruptedException e) {
        }
        
    }
    public void salePersona(){
        System.out.println("Sale una persona de la piscina");
        semCapacidad.release();
    }
}
