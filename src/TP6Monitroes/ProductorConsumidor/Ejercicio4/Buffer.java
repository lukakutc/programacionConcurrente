package TP6Monitroes.ProductorConsumidor.Ejercicio4;

public class Buffer {
    // Recurso compartido
    // Operaciones sincronizadas añadir y quitar
    // buffer limitado en este caso
    private int capacidad;
    // cantProductos es la cantidad de productos que hay en el buffer
    private int cantProductos, ultimoElemento;
    private boolean bufferLleno, bufferVacio;
    private Object[] estructura;

    public Buffer(int capacidad) {
        this.capacidad = capacidad;
        cantProductos = 0;
        bufferLleno = false;
        bufferVacio = true;
        estructura = new Object[capacidad];
    }

    public synchronized void añadir(String producto) {
        // Si el buffer no esta lleno, añadimos el producto despues del ultimo (ahora el
        // nuevo producto es el ultimo)
        if (!bufferLleno) {
            cantProductos++;
            System.out.println("El " + producto + " se añadio en la posicion " + cantProductos + " del buffer. ");
            estructura[cantProductos-1] = producto;

            // Si con el nuevo elemento se lleno la capacidad actualizamos la variable
            // bufferLleno
            if (cantProductos == capacidad){
                bufferLleno = true;
            }
            if(cantProductos>0){
                bufferVacio = false;
            }
        }

        notify();
    }

    public synchronized void quitar() {
        // Todo lo que se produce tiene que ser consumido por lo tanto while true.

        while (bufferVacio) {
            System.out.println("Buffer vacio. se espera que se añadan nuevos elementos para poder quitar");
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        System.out.println("Se quito el elemento que estaba en " + cantProductos);
        cantProductos--;
        if (cantProductos < capacidad) {
            bufferLleno = false;
        }
        if (cantProductos == 0) {
            bufferVacio = true;
        }

    }
}
