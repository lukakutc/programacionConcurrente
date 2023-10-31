package Tp5.ejercicio3por2;

import java.util.concurrent.Semaphore;

public class Comedor {
    // Los animales entran comen y se van.
    // Para entrar requiere que su especie sea a la que le toca. Le tocan un rato a
    // cada uno y esto se puede medir con semaforos
    // se me ocurre que podemos tener dos semaforos genericos para los gatos y los
    // perros, que cuando uno se agote el otro se recargue completamente
    // Por lo que por ejemlpo comen los 6 gatos, y ahora liberamos 6 permisos de
    // perros
    // Es por ahi
    private Semaphore semGatos = new Semaphore(0);
    private Semaphore semPerros = new Semaphore(0);
    private Semaphore semPlatos = new Semaphore(2);
    // Ahora, quien entra primero es condicion de carrera, como hacemos para ese
    // primer caso?
    // con un mutex para ver quien tula entra primero
    private Semaphore mutex = new Semaphore(1);
    private boolean primerTurno = true;
    // Contador para que cuando se agoten los permisos se liberen los otros
    int contador = 0;

    public void entrarAnimal(String tipo) {
        // Esto es para ver que animal entra primero (el primero que llegue)
        try {
            mutex.acquire();
            if (primerTurno) {
                if (tipo.equals("Gato")) {
                    semGatos.release(4);
                } else if (tipo.equals("Perro")) {
                    semPerros.release(4);
                }
                primerTurno = false;
            }
            mutex.release();
        } catch (InterruptedException e) {
        }

        if (tipo.equals("Perro")) {
            try {
                semPerros.acquire(1);
            } catch (InterruptedException e) {
            }
        } else if (tipo.equals("Gato")) {
            try {
                semGatos.acquire(1);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Un " + tipo + " esta preparado para entrar");
        try {
            semPlatos.acquire();
        } catch (InterruptedException e) {
        }
        System.out.println("Entra un " + tipo);
    }

    public void saleAnimal(String tipo) {
        System.out.println("Sale un " + tipo);
        semPlatos.release();
        try {
            mutex.acquire();
            contador++;
            if (contador == 4) {
                // si contador = la cantidad de perros o gatos que pueden comer seguidos
                // Cambiamos de turno (liberamos los semaforos de la otra especie)
                if (tipo.equals("Perro")) {
                    semGatos.release(4);
                } else {
                    semPerros.release(4);
                }
                contador = 0;
            }
            mutex.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
}
