
package co.avilatek;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Productor extends Thread{
    Almacen a;
    private Semaphore sP;
    private Semaphore sC;
    private Semaphore sE;
    private Semaphore sI;
    private int apuntP;
    private int val;

    public Productor(Almacen a, Semaphore sP, Semaphore sC, Semaphore sE, int apuntP, int val, Semaphore sI) {
        this.a = a;
        this.sP = sP;
        this.sC = sC;
        this.sE = sE;
        this.apuntP=apuntP;
        this.val=val;
        this.sI=sI;
    }
    
    @Override
    public void run(){
        while(true){
        try {
            sP.acquire();
            sE.acquire();
            a.setVec(apuntP, val);
            apuntP=(apuntP+1)%a.getTam();
            sC.release();
            sE.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
        }
            try {
                sI.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.a.imprimir();
            sI.release();
        }
    }

}
