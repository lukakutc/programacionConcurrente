package Tp3.Ejercicio2;

public class Energia {
    private int valor = 10;
    
    public Energia(){}

    public void drenar(int cantADrenar){
        valor = valor - cantADrenar;
    }

    public void curar(int cantACurar){
        valor = valor + cantACurar;
    }

    public int getValor(){
        return valor;
    }
}
