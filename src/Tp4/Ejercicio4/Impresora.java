package Tp4.Ejercicio4;

import java.util.concurrent.Semaphore;

public class Impresora {
    // Creamos un semaforo
    Semaphore sem = new Semaphore(1);
    String nombre;

    // Constructor
    public Impresora(String nombre) {
        this.nombre = nombre;
    }

    // Operacion de imprimir, aca utilizamos el semaforo supongo
    // Retorna booleano segun si se pudo o no imprimir
    public boolean imprimir() {
        boolean seImprimio = false;
        if (sem.tryAcquire()) {
            // Si hay permisos libres, adquirimos uno y simulamos la operacion de impresion.
            System.out.println(
                    "El cliente " + Thread.currentThread().getName() + " esta imprimiendo con la impresora " + nombre);
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // luego de simular la operacion de impresion liberamos un permiso del semaforo.
            sem.release();
            seImprimio = true;
        }
        return seImprimio;
    }

    public String getNombre() {
        return nombre;
    }

}
