package co.avilatek;

public class Main {

    public static void main(String[] args) {
        Hilo hilo = new Hilo();
        hilo.start();
        Runnable run = new Runnable();
        Thread runThread = new Thread(run);
        runThread.start();
    }
}
