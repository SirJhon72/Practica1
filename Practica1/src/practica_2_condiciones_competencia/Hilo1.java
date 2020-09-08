
package practica_2_condiciones_competencia;

import javax.swing.JTextArea;


public class Hilo1 extends Thread implements Runnable{
    private JTextArea Lienzo;
    private boolean Pause;
    private boolean Stop;
   
    //Constructor 
    public Hilo1(JTextArea Lienzo){
        this.Lienzo = Lienzo;
        this.Pause = false;
        this.Stop = false;
    }
    
    public void run(){
      
        try{
            while(true){ //Se cuenta hasta 1000
                Lienzo.append( (int)(Math.random()*100) + "\n");
                sleep(500);
                              
                //<-- Segmento para Synchronized
                synchronized (this){
                    while(Pause == true){
                        wait(); // <--- Con esto Pausamos el hilo
                    }
                }    
                
                if(Stop == true){ //Detenemos el hilo
                    break;
                }
            
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
            
    
    
    //pausar el hilo 
    synchronized void pausarHilo(){
        Pause = true; //<-- Cambiamos nuestro boleano para poder pausar el hilo 
        Stop = false;
        notify();        
    }
    
    //detener hilo
    synchronized void detenerHilo(){
        Stop = true;
    }
    
    //Reanudar hilo
    synchronized void reanudaarHilo(){
        Pause = false;
        notify();
        System.out.println("Llegue a reanudar al hilo");
    }
    
}


