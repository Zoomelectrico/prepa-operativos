package co.avilatek;

import java.util.concurrent.Semaphore;

public class Cliente extends Thread {
    public Semaphore semaforo;
    private int articulos;
    private int[] cont;

    Cliente(Semaphore s, int a, int[] c) {
        semaforo = s;
        articulos = a;
        cont = c;
    }

    @Override
    public void run() {
        //try {
            System.out.println("Hola soy el Hilo " + this.getId());
            // MUTEX
            //semaforo.acquire();
            System.out.println("=== Seccion critica " + this.getId());
            if (this.getId() % 2 == 0) {
                cont[0]++;
            } else {
                cont[0]--;
            }
            System.out.println("====== contador: " + cont[0]);
            //semaforo.release();

        //}  catch (InterruptedException ex) {
           // System.out.println(ex.getMessage());
        //}
    }


}
