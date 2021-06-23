package gui;

import queues.Queue1;
import queues.Queue2;
import queues.Queue3;
import queues.ReparationQueue;
import functions.Statistics;
import functions.Admin;
import functions.Robot;

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

    Statistics chances = new Statistics();
    Admin admin = new Admin();

    public void initSimulation(javax.swing.JTextPane robotBox, javax.swing.JTextPane showQueue1,javax.swing.JTextPane showQueue2, javax.swing.JTextPane showQueue3, javax.swing.JTextPane repairsQueue) {
        this.robotBox = robotBox;
        this.showQueue1 = showQueue1;
        this.showQueue2 = showQueue2;
        this.showQueue3 = showQueue3;
        this.repairsQueue = repairsQueue;
        
        this.queue1.showInterfaz(this.showQueue1);
        this.queue2.showInterfaz(this.showQueue2);
        this.queue3.showInterfaz(this.showQueue3);
        
        
       
        while (true) {
            
            admin.checkQueues(queue1, queue2, queue3, repQueue, this.robotBox, this.showQueue1, this.showQueue2, this.showQueue3, this.repairsQueue);
        }
    }

}
