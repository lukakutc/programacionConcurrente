package Tpo1;

public class Dato{

    private int valor;
    
    public synchronized void contar(){
           valor = ++valor;
    }
    
    public int obtenerValor(){
           return valor;
    }
    
    }
