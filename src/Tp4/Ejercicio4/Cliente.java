package Tp4.Ejercicio4;

public class Cliente implements Runnable {
    private GestorImpresoras gestorImpresoras;

    public Cliente(GestorImpresoras gestorImpresoras){
        this.gestorImpresoras = gestorImpresoras;
    }
    public void run(){
        gestorImpresoras.imprimir();
    }
}
