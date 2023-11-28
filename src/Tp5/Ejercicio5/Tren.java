package Tp5.Ejercicio5;

public class Tren {
    //El tren viaja  cuando le indiquen que viaje. corta
    //Es un objeto pasivo que solo se activa cuando el ControlTren le indica

    public void viajar(){
        System.out.println("El tren esta viajando!!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
