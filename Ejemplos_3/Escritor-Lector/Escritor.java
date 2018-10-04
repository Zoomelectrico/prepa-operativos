package co.avilatek;

import java.util.concurrent.Semaphore;

public class Escritor extends Thread {

    private Semaphore raceSemaphore, readers, writers;
    private int[] contadores;

    public Escritor(Semaphore raceSemaphore, Semaphore readers, Semaphore writers, int[] contadores) {
        this.raceSemaphore = raceSemaphore;
        this.readers = readers;
        this.writers = writers;
        this.contadores = contadores;
    }

    @Override
    public void run() {
        while(true) {
            try {
                raceSemaphore.acquire();
                contadores[2]++;
                if (contadores[2] == 1) {
                    readers.acquire();
                }
                raceSemaphore.release();
                writers.acquire();
                // Escribir
                System.out.println("Escribiendo...");
                contadores[0]++;
                Thread.sleep(1500);
                writers.release();
                raceSemaphore.acquire();
                contadores[2]--;
                if(contadores[2] == 0) {
                    readers.release();
                }
                raceSemaphore.release();
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}