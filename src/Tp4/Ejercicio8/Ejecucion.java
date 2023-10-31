package Tp4.Ejercicio8;

public class Ejecucion {
    public static void main(String[] args) {
        //Creamos un controlador
        ControladorProduccion controlador = new ControladorProduccion();
        //Creamos 10 productos mecanicos y 12 electricos
        Thread productos[] = new Thread[22];
        int i;
        for(i=0;i<9;i++){
            productos[i] = new Thread(new Producto(controlador,"M"),"Producto mecanico "+i);
        }
        for(i=9;i<22;i++){
            productos[i] = new Thread(new Producto(controlador,"E"),"Producto electrico "+(i-9));
        }

        //Iniciamos todos los productos
        for(i=0;i<22;i++){
            productos[i].start();
        }
    }
}
