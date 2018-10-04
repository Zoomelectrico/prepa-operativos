package co.avilatek;

import java.util.concurrent.Semaphore;

public class Lector extends Thread {

    private Semaphore raceSemaphore, readers, writers, raceSemaphore2;
    private int[] contadores;

    public Lector(Semaphore raceSemaphore, Semaphore readers, Semaphore writers, Semaphore raceSemaphore2, int[] contadores) {
        this.raceSemaphore = raceSemaphore;
        this.readers = readers;
        this.writers = writers;
        this.raceSemaphore2 = raceSemaphore2;
        this.contadores = contadores;
    }

    @Override
    public void run() {
        while (true) {
            try {
                raceSemaphore2.acquire();
                readers.acquire();
                raceSemaphore.acquire();
                contadores[1]++;
                if(contadores[1] == 1) {
                    writers.acquire();
                }
                raceSemaphore.release();
                readers.release();
                raceSemaphore2.release();
                // Leer
                Thread.sleep(500);
                System.out.println("Lector: " + this.getId() + ", valor: " + contadores[0]);
                raceSemaphore.acquire();
                contadores[1]--;
                if (contadores[1] == 0) {
                    writers.release();
                }
                raceSemaphore.release();
            } catch (InterruptedException ex ) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
