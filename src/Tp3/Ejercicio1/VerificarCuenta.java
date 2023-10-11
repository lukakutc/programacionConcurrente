package Tp3.Ejercicio1;

public class VerificarCuenta implements Runnable {
    //creamos una nueva cuenta de banco
    private CuentaBanco cb = new CuentaBanco();

    //Metodo para retirar dinero de la cuenta
    private synchronized void HacerRetiro(int cantidad) throws InterruptedException {
        //Si el balance de la cuenta es mayor o igual que la cantidad a retirar de la cuenta se realiza el retiro
        if (cb.getBalance() >= cantidad) {
            //mensaje para informar que hilo esta haciendo un retiro de la cuenta cb propiamente creada por el hilo (raro)
            System.out.println(Thread.currentThread().getName() + "está realizando un retiro de: " + cantidad + ".");
            Thread.sleep(1000);
            //Se retira el dinero de la cuenta con un metodo de la clase CuentaBancaria
            cb.retiroBancario(cantidad);
            System.out.println(Thread.currentThread().getName() + ": Retiro realizado.");
            System.out.println(Thread.currentThread().getName() + ": Los fondos son de: " + cb.getBalance());
        } else
        //Sino hay dinero no se retira
        {
            System.out.println(
                    "No hay suficiente dinero en la cuenta para realizar el retiro Sr."
                            + Thread.currentThread().getName());
            System.out.println("Su saldo actual es de" +
                    cb.getBalance());
            Thread.sleep(1000);
        }
    } // de hacer retiro

    //Metodo run de toda clase Runnable/Thread 
    public void run() {
        //El metodo intenta retirar 3 veces una cantidad de 10. Si el balance queda en negativo lo escribe
        //(seguramente esto sea algo que haya que corregir porque una cuenta no puede estar en negativo)
        for (int i = 0; i <= 3; i++) {

            try {
                this.HacerRetiro(10);
                if (cb.getBalance() < 0) {
                    System.out.println("La cuenta está en negativo.");
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}