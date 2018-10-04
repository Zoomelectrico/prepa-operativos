package co.avilatek;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        System.out.println("====================Inicio del Programa====================");
	    int[] contadores = new int[]{0,0,0};
        Semaphore
                raceSemaphoreReaders = new Semaphore(1),
                raceSemaphoreWriters1 = new Semaphore(1),
                raceSemaphoreWriters2 = new Semaphore(1),
                readers = new Semaphore(1),
                writers = new Semaphore(1);

        Escritor e = new Escritor(raceSemaphoreWriters1, readers, writers, contadores);
        Lector[] lectors = new Lector[3];

        try {
            for (int i = 0; i < lectors.length; i++) {
                lectors[i] = new Lector(raceSemaphoreReaders, readers, writers, raceSemaphoreWriters2, contadores);
                lectors[i].start();
            }
            Thread.sleep(1000);
            e.start();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
