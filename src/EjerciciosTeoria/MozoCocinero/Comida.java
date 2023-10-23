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
    //cocinero
    //ESPERAR pedido
    //cocinar pedido
    //entregar pedido a mozo
    
    public void esperarPedido(){
        
        try {
            semPedido.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        System.out.println("El cocinero recibe el pedido del mozo");
    }

    public void cocinarPedido(){
        System.out.println("El cocinero esta cocinando el pedido");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void pedidoCocinado(){
        System.out.println("El cocinero termino de cocinar el pedido");
        semComidaLista.release();
    }

    //Mozo
    //Generar pedido
    //pedir al cocinero
    //ESPERAR comida hecha de mozo

    public void generarPedido(){
        System.out.println("El cliente le esta pidiendo al mozo");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void pedirComida(){
        System.out.println("El mozo le pide al cocinero");
        semPedido.release();
    }
    public void entregarACliente(){
        
        try {
            semComidaLista.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("El mozo le entrega la comida lista al cliente");
    }

}    