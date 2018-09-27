package co.avilatek;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Cajera {

    static void shuffleArray(Cliente[] ar)  {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)  {
            int index = rnd.nextInt(i + 1);
            Cliente a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    public static void main(String[] args) {
        final int[] contador = new int[] {10};
	    final Semaphore semaforo = new Semaphore(1) ;
	    Cliente[] hillos = new Cliente[10];
	    for (int i = 0; i < 10; i++) {
            hillos[i] = new Cliente(semaforo, i, contador);
	    }
	    shuffleArray(hillos);
	    for(Cliente c: hillos) {
	        c.start();
        }

    }
}
