/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo2.Thread;

import javax.swing.JLabel;
import labo2.Gui.Gui;
import sun.reflect.generics.visitor.Reifier;

/**
 *
 * @author LN710Q
 */
public class AnimalThread extends Thread{
    private String nombre;
    public static int limite;
    private JLabel animal;
    private int x;
    private int y;

    public AnimalThread(String nombre, int limite, JLabel animal, int x, int y) {
        this.nombre = nombre;
        this.limite = limite;
        this.animal = animal;
        this.x = x;
        this.y = y;
    }
    
    public void run(){
    for(int i=x; i<=this.limite; i+=10)
    {
        System.out.println(this.nombre + "avanza");
        this.animal.setLocation(i,y);
        try{
            if(limite == 510){
            
            }
            sleep(100);
        }catch(InterruptedException e) {
        e.printStackTrace();
        }
    
    
    }
    System.out.println(this.nombre + " a llegado a la meta");
       labo2.Gui.Gui.Reiniciar.setVisible(true);
    yield();
    }
}
