package Tp4.Ejercicio8;

import java.util.concurrent.Semaphore;

public class Linea {
    // Recurso compartido, un controlador tiene dos lineas
    private Semaphore semProducto = new Semaphore(5);
    private String nombre;

    public Linea(String nombre) {
        this.nombre = nombre;
    }

    public void ensamblar() {
        try {
            semProducto.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("El producto " + Thread.currentThread().getName() + " esta ensamblando en la linea " + nombre);
        System.out.println("Quedan " + semProducto.availablePermits() + " espacios disponibles en linea "+nombre);
        try {
            Thread.sleep(3500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void productoTerminado(){
        System.out.println("El producto "+Thread.currentThread().getName()+" esta completamente ensamblado. Sale de la linea "+nombre);
        System.out.println("Espacios disponible en linea "+nombre+": "+semProducto.availablePermits()+1);
        semProducto.release();
        
    }
}
