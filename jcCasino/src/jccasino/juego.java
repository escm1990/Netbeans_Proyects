package jccasino;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
import java.util.Timer;
import java.util.TimerTask;

public class juego extends javax.swing.JLabel {
    
    private Timer tiempo ;
    private TimerTask task;
    private int speed = 50;//velocidad de la animacion
    private int frame=1;
    boolean run = false;    
    
    public juego(){
        //el tamaño de la imagen el mismo del jlabel
        this.setSize(129,129);
        setimage(frame);
    }
    
  
  //coloca una imagen en el objeto jlabel
  public void setimage(int n){        
        this.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/pic_" + n + ".jpg"))); 
  }
    
  //para la animacion  
  public void startAnimation() {    
           run=true;
           tiempo = new Timer();
           task = new TimerTask() {               
               public void run() {
                   //se obtiene un numero aleatorio
                   frame = numero_aleatorio(5,1);
                   //se cambia la imagen
                   setimage(frame);                   
               }
           };
           //se inicia la animacion
           System.out.println("Se inicia la animacion");                                             
           tiempo.schedule(task,0,speed); 
    }
    //detiene la animacion
     public void stopAnimation() {        
        tiempo.cancel();
        task.cancel();
        run=false;
        System.out.println("La animacion fue detenida");                                             
    }
     
     //retorna un nuemro aleatorio entre un rango dado
     private int numero_aleatorio(int max, int min){     
         return min + (int)(Math.random() * ((max - min) + 1));         
     }
}
