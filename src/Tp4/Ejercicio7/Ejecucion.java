package Tp4.Ejercicio7;

public class Ejecucion {
    public static void main(String[] args) {
        //Creamos una confiteria
        Confiteria confiteria = new Confiteria();
        //Creamos un mozo
        Thread mozo = new Thread(new Mozo(confiteria));
        //Creamos empleados 
        int i;
        Thread empleados[] = new Thread[7];
        for(i=0;i<7;i++){
            empleados[i] = new Thread(new Empleado(confiteria),"empleado "+i);
        }
        //Iniciamos el mozo y los empleados
        mozo.start();
        for(i=0;i<7;i++){
            empleados[i].start();
        }
    }
}
