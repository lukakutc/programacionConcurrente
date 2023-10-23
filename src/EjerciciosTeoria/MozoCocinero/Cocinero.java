package EjerciciosTeoria.MozoCocinero;

public class Cocinero implements Runnable {
    private Comida comida;

    public Cocinero(Comida comida) {
        this.comida = comida;
    }

    public void cocinarPedido(){
         System.out.println("El cocinero esta cocinando el pedido");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            // ESPERAR pedido
            // cocinar pedido
            // entregar pedido a mozo

            comida.esperarPedido();
            cocinarPedido();
            comida.pedidoCocinado();
            // Cuando se espera el pedido( se intenta adquirir el permiso )
            // y no hay permisos disponible, el hilo se bloquea hasta que haya permisos
            // disponibles.
        }
    }
}
