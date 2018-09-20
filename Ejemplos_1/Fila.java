/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.avilatek;

/**
 *
 * @author Estudiantes
 */


public class Fila extends Thread{
    private int [][] mat1;
    private int [][] mat2;
    private int[][] res;
    private int i;
    private int cantidadColumnas;
    
    public Fila(int[][] res, int [][] mat1, int [][] mat2, int i, int cantidadColumnas) {
       this.res = res;
       this.mat1=mat1;
       this.mat2=mat2;
       this.i=i;
       this.cantidadColumnas=cantidadColumnas;
    }
    
    public void run()
    {
        for(int a=i; a<i+100; a++){
            for(int j=0; j<cantidadColumnas; j++){
                int acum=0;
                for(int x=0; x<cantidadColumnas; x++){
                    acum+=mat1[i][x]*mat2[x][j];
                }
                res[i][j]=acum;
            }
        }
    }
}
