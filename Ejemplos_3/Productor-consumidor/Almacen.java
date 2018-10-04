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
public class Almacen {
    int[] vec;
    int tam;
    
    public Almacen(int tam){
        this.tam=tam;
        vec = new int[tam];
    }

    public int getTam() {
        return tam;
    }

    public int getVec(int i) {
        return vec[i];
    }

    public void setVec(int i, int val) {
        this.vec[i] = val;
    }
    
    public void imprimir(){
        for(int i=0; i<tam; i++){
            System.out.print(vec[i]+" ");
        }
        System.out.println("");
    }
    
    
}
