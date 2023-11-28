package Recuperatorio.Ejercicio1parcial;

import java.util.concurrent.Semaphore;

public class Almacen {
    //El otro recurso compartido
    private Semaphore semTransporte;
    private Semaphore semCajas;
    public Almacen(){
        semTransporte = new Semaphore(0);
        semCajas = new Semaphore(0);
    }

    public void almacenarCaja(){
        semCajas.release();
    }

}
