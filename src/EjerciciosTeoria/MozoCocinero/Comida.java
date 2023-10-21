package EjerciciosTeoria.MozoCocinero;

import java.util.concurrent.Semaphore;

public class Comida {
    // Recurso compartido
    // Un semaforo por cada interaccion requerida; Mozo informando pedido a cocinero
    // Cocinero informando pedido listo a mozo
    private Semaphore semPedido;
    private Semaphore semComidaLista;

    public Comida() {
        // Ambos semaforos se inicializan en 0 porque al principio no hay pedidos ni
        // comidas listas
        semPedido = new Semaphore(0);
        semComidaLista = new Semaphore(0);
    }

    public void pedirComida(){
        //a este metodo lo llama mozo
        semPedido.release(1); //0 pedidos a 1 pedido
    }
    public void cocinarPedido(){
        //A este metodo lo llama cocinero.
        semComidaLista.release(1); //0 comidas listas a 1
    }

    public void esperarPedido(){
        //A este metodo lo llama cocinero (Esperando por recibir el pedido para cocinar)
        try {
            semPedido.acquire(1); //De 1 pedido pendiente a 0 pedidos pendientes
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void entregarComida(){
        //La comida ya la cocino el cocinero y el mozo la entrega
        try {
            semComidaLista.acquire(1); //De 1 comida lista a 0 comidas litas
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}    