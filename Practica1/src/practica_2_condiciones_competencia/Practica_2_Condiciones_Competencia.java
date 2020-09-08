package practica_2_condiciones_competencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Practica_2_Condiciones_Competencia extends JFrame{
    private JButton bRun, bPausa, bStop, bReanudar;
    private JLabel Hilo1, Hilo2;
    private JTextArea areaHilo1, areaHilo2;
    private JScrollPane jspHilo1, jpsHilo2;

    public Practica_2_Condiciones_Competencia(){
        this.setSize(500,500);
        this.setTitle("Condiciones de competencia");
        misComponentes();
        
       
    }
    
    private void misComponentes(){
        bRun = new JButton("Run");
        bPausa = new JButton("Pausa");
        bStop = new JButton("Stop");
        bReanudar = new JButton("Reanudar");
       
        areaHilo1 = new JTextArea();
        areaHilo2 = new JTextArea();
       
        Hilo1 = new JLabel("Hilo 1");
        Hilo2 = new JLabel("Hilo 2");
       
        jspHilo1 = new JScrollPane(areaHilo1);
        jpsHilo2 = new JScrollPane(areaHilo2);
       
        setLayout(null);
        bRun.setBounds(10,100,100,25);
        bPausa.setBounds(10,150,100,25);
        bStop.setBounds(10,200,100,25);
        bReanudar.setBounds(10,250,100,25);
        
       
        Hilo1.setBounds(150,10,100,25);
        Hilo2.setBounds(250,10,100,25);
       
        jspHilo1.setBounds(150,50,100,300);
        jpsHilo2.setBounds(250,50,100,300);
       
        add(bRun);
        add(bPausa);
        add(bStop);
        add(bReanudar);
        add(Hilo1);
        add(Hilo2);
        add(jspHilo1);
        add(jpsHilo2);
        //Declaramos los hilos 
        Hilo1 h1 = new Hilo1(areaHilo1);
        Hilo2 h2 = new Hilo2(areaHilo2);
       
       
       
       //Boton de correr
        bRun.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
                h1.start();
                h2.start();
           }
       
       
        });
       
        //Boton de pausa
        bPausa.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               h1.pausarHilo();
               h2.pausarHilo();
               
           }
       
        });
       
        //Detener hilo 
        bStop.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae) {
                h1.detenerHilo();
                h2.detenerHilo();
            }
        });
        
        //Reanudar Hilo
        bReanudar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                h1.reanudaarHilo();
                h2.reanudaarHilo();
            }
        });
    }
    
    public static void main(String[] args) {
        Practica_2_Condiciones_Competencia fr = new Practica_2_Condiciones_Competencia();
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
    }
    
}
