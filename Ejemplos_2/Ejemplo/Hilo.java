package co.avilatek;

import java.util.concurrent.Semaphore;

public class Hilo extends Thread {

    private Semaphore semaphore;

    public Hilo(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        System.out.println("Hola soy el proceso: " + this.getId());
        // Pendejadas antes de la Seccion Critica
        try {
            // Permisos Ingresar Seccion Critica
            semaphore.acquire();
            // Seccion Critica
            //CODIGO YUKKKKK
            Thread.sleep((long) (Math.random() * 1000));
            System.out.println("+=== Estoy en mi seccion critica: " + this.getId());
            semaphore.release();
            // Final Seccion Critica
        } catch(InterruptedException ex ) {
            System.out.println(ex.getMessage());
        }
        // Seguir pajita del codigo

    }
}
