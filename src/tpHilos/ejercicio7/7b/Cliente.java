package tpHilos.ejercicio7.b;

public class Cliente extends Thread{
    
    private int[] carroCompra;
    private Cajero cajero;
    
    public Cliente(String elNombre, int[] elCarroCompra, Cajero elCajero){
        super(elNombre);
        carroCompra = elCarroCompra;
        cajero = elCajero;
    }

    public int[]  getCarroCompra(){
        return carroCompra;
    }

    public void run(){
        long initialTime = System.currentTimeMillis();
        cajero.procesarCompra(this, initialTime);
    }
    //El run ya esta porque hereda de Thread
}

