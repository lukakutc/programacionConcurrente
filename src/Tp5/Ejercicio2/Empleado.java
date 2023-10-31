package Tp5.Ejercicio2;

public class Empleado implements Runnable {
    //Un empleado puede comer, tomar, o tomar y comer
    //vamos a usar aleatorios para elegir que hace el empleado
    private GestorComedor gestor;

    public Empleado(GestorComedor gestor){
        this.gestor = gestor; 
    }

    
    public void sentarse(){

    }
    public void comer(){
        
    }
    public void tomar(){

    }
    public void tomarYComer(){

    }
    public void run(){}
}
