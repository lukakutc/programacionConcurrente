package Tp4.Ejercicio5;

public class Ejecucion {
    public static void main(String[] args) {
        //Creamos un arreglo de impresoras
        Impresora imp1 = new Impresora("#1", "A");
        Impresora imp2 = new Impresora("#2", "B");
        Impresora imp3 = new Impresora("#3","A");
        Impresora imp4 = new Impresora("#4","B");
        Impresora imp5 = new Impresora("#5","B");
        Impresora impresoras[] = {imp1,imp2,imp3,imp4,imp5};

        //Creamos un gestor de impresoras
        GestorImpresoras gestorImpresoras = new GestorImpresoras(impresoras);

        //Creamos 10 clientes de tipo de impresion random (a o b) y los almacenaremos en un arreglo
        Thread clientes[] = new Thread[10];
        String tipoCliente;
        double num;
        int i=0;
        for(i=0;i<10;i++){
            num = Math.random();
            if(num<0.3333333){
                tipoCliente = "A";
            }else if(num<0.6666666){
                tipoCliente = "B";
            }else{
                tipoCliente = "C";
            }
            clientes[i] = new Thread(new Cliente(tipoCliente, gestorImpresoras),"Cliente"+i);
        }
        //iniciamos los hilos
        for(i=0;i<10;i++){
            clientes[i].start();
        }

    }
}
