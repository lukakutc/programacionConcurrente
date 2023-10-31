package Tp5.Ejercicio3devuelta;

import java.util.concurrent.Semaphore;

public class Comedor {
    Semaphore especie = new Semaphore(6);
    Semaphore platos = new Semaphore(3);
    Semaphore mutex = new Semaphore(1);
    int contador = 0;
    String turno = "";

    public void entrarComedor(String tipo) {
        // Primero adquirimos el de especie
        try {
            mutex.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (turno.isEmpty()) {
            turno = tipo;
            System.out.println("ENTRAN "+turno+"s");
        }
        if (turno.equals(tipo)) {
            try {
                especie.acquire();
                System.out.println("Un " + tipo + " esta ESPERANDO para entrar en el comedero");
                contador++;
                if (contador == 6) {
                    especie.release(6);
                    contador = 0;
                    if (turno.equals("Perro")) {
                        turno = "Gato";
                        System.out.println("Ahora entran "+turno+"s");
                    } else {
                        turno = "Perro";
                        System.out.println("Ahora entran "+turno+"s");
                    }
                }
                mutex.release();

                platos.acquire();
                System.out.println("Un " + tipo + " ENTRA al comedero.");
            } catch (InterruptedException e) {
            }
        }
    }

    public void salirComedor(String tipo) {
        System.out.println("Un " + tipo + " SALE del comedor");
        platos.release();

    }

}
