package Tp3.Ejercicio6;

public class Sumador extends Thread{
    //Este hilo sumara 10000 elementos del arreglo a partir de de la posicion posicion
    private int [] arreglo;
    private int posicion;
    private Resultado resultado;

    public Sumador(int [] arreglo, int posicion, Resultado resultado){
        this.arreglo = arreglo;
        this.posicion = posicion;
        this.resultado = resultado;
    }


    public void run(){
        int i;
        int ultimaPosicion = posicion + 10000;

        for(i=posicion;i<ultimaPosicion;i++){
            sumar(resultado, arreglo[i]);
        }
    }

    public void sumar(Resultado resultado, int elemento){
        resultado.sumar(elemento);
    }
}
 