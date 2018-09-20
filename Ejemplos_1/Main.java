package co.avilatek;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    static int tam=1000;
    static int [][] mat1=new int[tam][tam];
    static int [][] mat2=new int[tam][tam];
    static int [][] res =new int[tam][tam];
    static Fila[] hilos= new Fila[10];
    static int numeroHilos=10;
    public static Scanner leer=new Scanner(System.in);

    public static void multiplicacionSecuencialDeMatrices(){

        for(int i=0; i<tam; i++){
            for(int j=0; j<tam; j++){
                int acum=0;
                for(int x=0; x<tam; x++){
                    acum+=mat1[i][x]*mat2[x][j];
                }
                res[i][j]=acum;
            }
        }
    }

    public static void multiplicacionParalelaDeMatrices(){

        for(int i=0; i<numeroHilos; i++){
            hilos[i]=new Fila(res, mat1, mat2, i*(tam/numeroHilos), tam);
        }
        for(int i=0; i<numeroHilos; i++){
            hilos[i].start();
        }

        for(int i=0; i<numeroHilos; i++){
            try {
                hilos[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(co.avilatek.Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void imprimirResultado(){
        for (int i=0; i<tam; i++){
            for(int j=0; j<tam; j++){
                System.out.print(res[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int resp;
        long inicio;
        long fin;
        for (int i=0; i<tam; i++){
            for (int j=0; j<tam; j++){
                mat1[i][j]=1;
                mat2[i][j]=2;
            }
        }
        OUTER:
        while (true) {
            System.out.println("Este programa tiene como objetivo comparar "
                    + "la ejecución de código secuencial con el de código paralelo.\n"
                    + "Para ello se permite multiplicar dos matrices 1000*1000 de"
                    + " ambas formas. Seleccione qué desea hacer:\n"
                    + "1)Multiplicar de forma secuencial.\n"
                    + "2)Multiplicar de forma paralela.\n"
                    + "3)Imprimir último resultado\n"
                    + "4)Salir.");
            resp=leer.nextInt();
            switch (resp) {
                case 1:
                    inicio=System.nanoTime();
                    multiplicacionSecuencialDeMatrices();
                    fin=System.nanoTime();
                    System.out.println("Tiempo de cálculo: "+(fin-inicio)+" nanosegundos");
                    break;
                case 2:
                    inicio=System.nanoTime();
                    multiplicacionParalelaDeMatrices();
                    fin=System.nanoTime();
                    System.out.println("Tiempo de cálculo: "+(fin-inicio)+" nanosegundos");
                    break;
                case 3:
                    imprimirResultado();
                    break;
                default:
                    break OUTER;
            }
        }
    }

}

