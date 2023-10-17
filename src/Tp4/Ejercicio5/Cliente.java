package Tp4.Ejercicio5;


public class Cliente implements Runnable {
    //Si usamos runnable podemos usar el nombre del constructor de hilo
    private String tipoImpresion;
    private GestorImpresoras gestorImpresoras;

    public Cliente(String tipoImpresion, GestorImpresoras gestorImpresoras){
        this.tipoImpresion = tipoImpresion;
        this.gestorImpresoras = gestorImpresoras;
    }

    public String getTipoImpresion(){
        return tipoImpresion;
    }

    public void imprimir(){
        System.out.println(Thread.currentThread().getName()+" va a imprimir un archivo de tipo "+tipoImpresion);
        gestorImpresoras.imprimir(tipoImpresion);
    }

    public void run(){
        imprimir();
    }
}
