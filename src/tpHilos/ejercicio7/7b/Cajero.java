package tpHilos.ejercicio7.b;

import tpHilos.ejercicio7.Cliente;

public class Cajero{
    private String nombre;


    public Cajero (String elNombre, Cliente elCliente){
        nombre = elNombre;  
    }

    public String getNombre(){
        return nombre;
    }


    public void procesarCompra(Cliente cliente, long timeStamp) {

        System.out.println("El cajero " + this.nombre + " COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "
                + cliente.getNombre() + " EN EL TIEMPO: " + (System.currentTimeMillis() - timeStamp) / 1000 +
                "seg");
        for (int i = 0; i < cliente.getCarroCompra().length; i++) {
            this.esperarXSegundos(cliente.getCarroCompra()[i]);
            System.out.println("Procesado el producto " + (i + 1) +
                    "->Tiempo: " + (System.currentTimeMillis() - timeStamp) /
                            1000
                    + "seg");
        }
        System.out.println(
                "El cajero " + this.nombre + " HA TERMINADO DE PROCESAR " + cliente.getNombre() + " EN EL TIEMPO: " +
                        (System.currentTimeMillis() - timeStamp) / 1000 + "seg");
    }



    public void esperarXSegundos(int segundos) {
        try {
            Thread.sleep(segundos * 1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
