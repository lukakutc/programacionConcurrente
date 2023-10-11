package Tp3.Ejercicio6;

public class Resultado {
    private int valor=0;

    public Resultado(){}
    
    public synchronized void sumar(int elValor){
        valor = valor + elValor;
    }

    public int getValor(){
        return valor;
    }
}
