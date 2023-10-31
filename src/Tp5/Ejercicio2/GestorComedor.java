package Tp5.Ejercicio2;

public class GestorComedor {
    //Utilizamos una clase gestor comedor porque el comedor es el recurso compartido
    //Por lo tanto Comedor no tiene acceso al cocienro y al mozo

    private Comedor comedor;
    private Mozo mozo;
    private Cocinero cocinero;

    public GestorComedor(Comedor comedor, Mozo mozo, Cocinero cocinero) {
        this.comedor = comedor;
        this.mozo = mozo;
        this.cocinero = cocinero;
    }

    public void sentarEmpleado(){
        comedor.llegaPersona();
        
    }
    public void salirEmpleado(){

    }

    public void tomar(){

    }
    public void comer(){

    }

}
