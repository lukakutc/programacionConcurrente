package Tp4.Ejercicio8;

public class ControladorProduccion {
    //Controlador de los recursos compartidos, que son las dos lineas de ensamblaje
    Linea lineaOeste = new Linea("Oeste");
    Linea lineaNorte = new Linea("Norte");

    public void llegaMecanico(){
        System.out.println("El producto "+ Thread.currentThread().getName()+" intenta entrar en la linea Oeste");
        lineaOeste.ensamblar();
        lineaOeste.productoTerminado();
    }
    public void llegaElectrico(){
        System.out.println("El producto "+ Thread.currentThread().getName()+" intenta entrar en la linea Norte");
        lineaNorte.ensamblar();
        lineaNorte.productoTerminado();
    }

}
