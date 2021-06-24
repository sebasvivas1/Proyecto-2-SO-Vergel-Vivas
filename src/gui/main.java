package gui;

import queues.Queue1;
import queues.Queue2;
import queues.Queue3;
import queues.ReparationQueue;
import functions.Statistics;
import functions.Admin;
import functions.Robot;
import queues.Pana;

public class main {
    
    javax.swing.JTextPane robotBox;
    javax.swing.JTextPane showQueue1;
    javax.swing.JTextPane showQueue2;
    javax.swing.JTextPane showQueue3;
    javax.swing.JTextPane repairsQueue;
    
    Queue1 queue1 = new Queue1();
    Queue2 queue2 = new Queue2();
    Queue3 queue3 = new Queue3();
    ReparationQueue repQueue = new ReparationQueue();

    Admin admin = new Admin();
    
    Pana xd = new Pana(1, "1");
    Pana xd1 = new Pana(2, "1");
    Pana xd2= new Pana(3, "1");
    Pana xd3 = new Pana(4, "1");
    Pana xd4 = new Pana(5, "1");

    public void initSimulation(javax.swing.JTextPane robotBox, javax.swing.JTextPane showQueue1,javax.swing.JTextPane showQueue2, javax.swing.JTextPane showQueue3, javax.swing.JTextPane repairsQueue) {
        this.robotBox = robotBox;
        this.showQueue1 = showQueue1;
        this.showQueue2 = showQueue2;
        this.showQueue3 = showQueue3;
        this.repairsQueue = repairsQueue;
        
        this.queue1.showInterfaz(this.showQueue1);
        this.queue2.showInterfaz(this.showQueue2);
        this.queue3.showInterfaz(this.showQueue3);
        
        //this.queue1.enconlarDesdeOtraCola(xd);
        //this.queue1.enconlarDesdeOtraCola(xd1);
        //this.queue1.enconlarDesdeOtraCola(xd2);
        //this.queue1.enconlarDesdeOtraCola(xd3);
        //this.queue1.showDato();
        
        admin.showInterface(this.robotBox, this.showQueue1, this.showQueue2, this.showQueue3, this.repairsQueue);
        
        this.running();
    }
    
    public void running(){
       // while(true){
      admin.checkQueues(queue1, queue2, queue3, repQueue);
        //}
        
            //this.initSimulation(robotBox, showQueue1, showQueue2, showQueue3, repairsQueue);
    }

}
