package Tp3.Ejercicio7;

public class Turno {
    //valor sera a b o c, utilizamos string en vez de char porque para comparar char se usa metodo de string xD
    private String valor;

    public Turno(String elValor){
        valor = elValor;
    }

    public String getValor(){
        return valor;
    }

    public synchronized void setValor(String elValor){
        valor = elValor;
    }
}
