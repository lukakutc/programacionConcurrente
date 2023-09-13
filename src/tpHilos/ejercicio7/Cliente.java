package tpHilos.ejercicio7;

public class Cliente{
    private String nombre;
    private int[] carroCompra;

    public Cliente(String elNombre, int[] elCarroCompra){
        nombre = elNombre;
        carroCompra = elCarroCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public int[]  getCarroCompra(){
        return carroCompra;
    }

    //El run ya esta porque hereda de Thread
}

