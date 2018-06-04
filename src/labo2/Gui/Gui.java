/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labo2.Gui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import labo2.Thread.AnimalThread;


/**
 *
 * @author LN710Q
 */
public class Gui extends JFrame{
    
    private JLabel [] labels;
    
    private JButton inicio;
    public static JButton Reiniciar;
    private String [] nombres = {"canguro", "tortuga","dragon"};
    
    public Gui(){
    super("Carrera de animales");
            initialComponents();
    }
    
    public void initialComponents(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    
    labels = new JLabel[3];
    inicio = new JButton("Inicio");
    Reiniciar = new JButton("Reiniciar");
    Container container = getContentPane();
    
    for(int i=0; i< 3 ;i++){
    labels[i]=new JLabel();
    labels[i].setIcon(new ImageIcon(getClass().getResource(nombres[i]+".gif")));
    labels[i].setBounds(10,(i*220)+10,200,200);
    container.add(labels[i]);
    }
    inicio.setBounds(10,0,100,30);
    Reiniciar.setBounds(300, 0, 100, 30);
    container.add(inicio);
    container.add(Reiniciar);

    inicio.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            AnimalThread canguro = new AnimalThread("canguro",510, labels[0],labels[0].getX(),labels[0].getY());
            AnimalThread tortuga = new AnimalThread("tortuga",510, labels[1],labels[1].getX(),labels[1].getY());
            AnimalThread dragon = new AnimalThread("dragon",510, labels[2],labels[2].getX(),labels[2].getY());
            canguro.start();
            tortuga.start();
            dragon.start();
            Reiniciar.setVisible(false);
        }
    });
    
    Reiniciar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Reiniciar.setVisible(false);
             labels[0].setBounds(10,0,200,200);
             labels[1].setBounds(10,230,200,200);
             labels[2].setBounds(10,450,200,200);
            
            
            
        }
    });
   
    
    setSize(700,650);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable(){
        @Override
        public void run(){
         new Gui().setVisible(true);
        }
        });
    }
}
