package Tp4.Ejercicio8;

public class Producto implements Runnable {
    private ControladorProduccion controlador;
    private String tipo;
    public Producto(ControladorProduccion controlador){
        this.controlador = controlador;
    }

    
    public Producto(ControladorProduccion controlador, String tipo) {
        this.controlador = controlador;
        this.tipo = tipo;
    }


    public void run(){
        if(tipo.equals("M")){
            controlador.llegaMecanico();
        }else if (tipo.equals("E")){
            controlador.llegaElectrico();
        }
    }
    
}
