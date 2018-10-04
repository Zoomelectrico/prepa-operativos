/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.avilatek;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Estudiantes
 */
public class ProductoresConsumidores {
    
    private Almacen alm;
    private Semaphore semaProductores;
    private Semaphore semaConsumidores;
    private Semaphore semaExclusividad;
    private Semaphore semaImpresion;
    private int apuntP;
    private int apuntC;
    private Productor p;
    private Productor c;

    public ProductoresConsumidores() {
            int x=5;
          alm=new Almacen(x); 
          semaProductores=new Semaphore(x);
          semaConsumidores=new Semaphore(0);
          semaExclusividad=new Semaphore(1);
          semaImpresion=new Semaphore(1);
          apuntP=0;
          apuntC=0;
          p=new Productor(alm, semaProductores, semaConsumidores, semaExclusividad, apuntP, 1, semaImpresion);
          c=new Productor(alm,semaConsumidores, semaProductores, semaExclusividad, apuntC, 0, semaImpresion);
    }

   
    public static void main(String[] args) {
       ProductoresConsumidores a= new ProductoresConsumidores();
       a.c.start();
       a.p.start();
    }
    
}
