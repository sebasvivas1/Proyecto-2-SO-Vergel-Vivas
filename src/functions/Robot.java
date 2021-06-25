package functions;

import java.util.concurrent.Semaphore;
import functions.Statistics;
import queues.Queue1;
import queues.Queue2;
import queues.Queue3;
import queues.ReparationQueue;
import queues.Pana;

public class Robot extends Thread{
    private Semaphore mutex;
    Statistics chances = new Statistics();
    private int time = 200;
    
    javax.swing.JTextPane robotBox;
    
    
    public void checkPanaQueue1(Queue1 queue1, ReparationQueue repQueue){
        try {
            Pana pAux = queue1.getpFirst();
            this.robotBox.setText(pAux.getDato());

            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        int result = chances.robotPanas();
        
        if(result <=2) {
            // El pana sale al mercado (se desencola)
            queue1.desencolar();
        }
        
        if(result >=3 && result <= 7) {
            // El pana se vuelve a encolar.
            Pana pAux = queue1.desencolar();
            queue1.enconlarDesdeOtraCola(pAux);
        }
        
        if(result == 8 || result == 9 ) {
            // Llevar al pana a la cola de reparaciones/mejoras
            Pana pAux = queue1.desencolar();
            pAux.setPrior("1");
            repQueue.enconlar(pAux);
            
        }
        this.robotBox.setText("");
    }
    
    public void checkPanaQueue2(Queue2 queue2, ReparationQueue repQueue){

        try {
            Pana pAux = queue2.getpFirst();
            this.robotBox.setText(pAux.getDato());
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        int result = chances.robotPanas();
        
        if(result <=2) {
            // El pana sale al mercado (se desencola)
            queue2.desencolar();
        }
        
        if(result >=3 && result <= 7) {
            // El pana se vuelve a encolar.
            Pana pAux = queue2.desencolar();
            queue2.enconlarDesdeOtraCola(pAux);
        }
        
        if(result == 8 || result == 9 ) {
            // Llevar al pana a la cola de reparaciones/mejoras
            Pana pAux = queue2.desencolar();
            pAux.setPrior("2");
            repQueue.enconlar(pAux);
            
        }
                this.robotBox.setText("");

    }  
    
    public void checkPanaQueue3(Queue3 queue3, ReparationQueue repQueue){

        try {
            Pana pAux = queue3.getpFirst();
            this.robotBox.setText(pAux.getDato());
            Thread.sleep(time);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        int result = chances.robotPanas();
        
        if(result <=2) {
            // El pana sale al mercado (se desencola)
            queue3.desencolar();
        }
        
        if(result >=3 && result <= 7) {
            // El pana se vuelve a encolar.
            Pana pAux = queue3.desencolar();
            queue3.enconlarDesdeOtraCola(pAux);
        }
        
        if(result == 8 || result == 9 ) {
            // Llevar al pana a la cola de reparaciones/mejoras
            Pana pAux = queue3.desencolar();
            pAux.setPrior("3");
            repQueue.enconlar(pAux);
            
        }
                this.robotBox.setText("");

    }  
    
    public void showRobot(javax.swing.JTextPane robotBox) {
        this.robotBox = robotBox;
        
    }
}
