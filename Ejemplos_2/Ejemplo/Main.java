package co.avilatek;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
	    final Semaphore semaphore = new Semaphore(1);
	    Hilo[] hilos = new Hilo[10];
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Hilo(semaphore);
        }
        for (Hilo h: hilos) {
            h.start();
        }

    }
}
