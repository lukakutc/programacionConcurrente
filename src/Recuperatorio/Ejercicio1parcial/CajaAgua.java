package Recuperatorio.Ejercicio1parcial;

import java.util.concurrent.Semaphore;

public class CajaAgua {
    //Recurso compartido para los embotelladores de agua y el empaquetador
    private int cantBotellas;
    private Semaphore mutex;
    private Semaphore empaquetador;

    public CajaAgua(){
        cantBotellas = 10;
        mutex = new Semaphore(1);
        empaquetador = new Semaphore(1);
    }
    public void ponerAgua(){
        try {
            mutex.acquire();
            //Se cololca una botella de agua en la caja
            cantBotellas--;
            if(cantBotellas==0){

            }

            mutex.release();
        } catch (InterruptedException e) {}
        
    }


}
