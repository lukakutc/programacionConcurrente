package Tp4.Ejercicio5;

import java.util.concurrent.Semaphore;

public class Impresora {
    private String nombre;
    private String tipo;
    private Semaphore sem = new Semaphore(1);

    public Impresora(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean imprimir(String tipoImpresion) {
        boolean seImprimio = false;
        if (tipoImpresion.equals(tipo) || tipoImpresion.equals("C")) {
            // Si la empresora es de tipo requerido
            if (sem.tryAcquire()) {
                // Y no estaba en uso por otro hilo
                // se imprime
                System.out.println("El cliente " + Thread.currentThread().getName() + " esta imprimiendo en impresora "
                        + nombre + " de tipo " + tipo);
                seImprimio = true;
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sem.release();
            }
        }
        return seImprimio;
    }
}
