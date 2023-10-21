package EjerciciosTeoria.MozoCocinero;

public class Cocinero implements Runnable{
    private Comida comida;

    public Cocinero(Comida comida){
        this.comida = comida;
    }
    
    public void esperarPedido(){
        
        comida.esperarPedido();
        System.out.println("Cocinero recibe pedido de mozo, a preparar la comida!!");
    }
    
    public void cocinarPedido(){
        comida.cocinarPedido();
        System.out.println("El cocinero esta cocinando la comida");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    public void run(){
        while(true){
            esperarPedido();
            cocinarPedido();
            //Cuando se espera el pedido( se intenta adquirir el permiso )
            //y no hay permisos disponible, el hilo se bloquea hasta que haya permisos disponibles.
        }
    }
}
