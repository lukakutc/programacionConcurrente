package EjerciciosTeoria.BarberoMonitor;

public class SillonMonitor {
    // Recurso compartido sync wait notify!!!
    // Y variables de condicion para saber cuando seguir esperando! isi

    // Barbero: espera al cliente, le corta el pelo y le avisa cuando termino
    // Cliente: despierta al barbero, le pide el corte, espera que el barbero le
    // diga cuando termino y se va
    // Y deberia haber una sincronizacion mas, que es que cuando un cliente ya se
    // esta cortando el pelo, el nuevo cliente debe esperar
    // Entonces:
    boolean clienteLlegado;
    boolean corteRealizado;
    boolean lugarLibre;

    public SillonMonitor() {
        this.clienteLlegado = false;
        this.corteRealizado = false;
        this.lugarLibre = true;
    }

    public synchronized void esperarCliente() {
        // Mientras cliente no haya llegado seguimos esperando
        while (!clienteLlegado) {
            System.out.println("Barbero esperando por cliente. . .");
            try {
                wait();
            } catch (InterruptedException e) {
            }
            // Cuando ya llego el cliente
        }
        System.out.println("Barbero atiende al cliente y empieza a cortarle el pelo");
    }

    public synchronized void terminarCorte() {
        System.out.println("Barbero termina el corte de pelo. Le dice al cliente que se puede ir");
        corteRealizado = true;
        notify();
    }

    public synchronized void esperarCorteTerminado() {
        while (!corteRealizado) {
            System.out.println("El cliente esta esperando que el barbero le diga que termino de cortarle");
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        // Cuando ya se termino el corte
        System.out.println("El cliente le paga al barbero y se va de la barberia");
        // Ahora que ya termino el ciclo no hay cliente ni corte
        clienteLlegado = false;
        corteRealizado = false;
        lugarLibre = true;
    }

    public synchronized void llegaCliente() {
        System.out.println("Llega el cliente a la barberia");
        lugarLibre = false;
        clienteLlegado = true;
        notify();
    }

    //Esta bien asi pero faltaria cambiar los mensajes y hacer 2 metodos mas
}
