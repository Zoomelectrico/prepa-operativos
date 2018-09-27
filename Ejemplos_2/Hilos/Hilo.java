package co.avilatek;

public class Hilo extends Thread {
    public Hilo()
    {

    }

    @Override
    public void run() {
        System.out.println("Hola soy un Thread. ID: " + this.getId() + ", estado: " + this.getState().name());
    }

}
