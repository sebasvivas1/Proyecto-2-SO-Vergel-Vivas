package gui;

import queues.Queue1;
import queues.Queue2;
import queues.Queue3;
import functions.Statistics;
import functions.Admin;
import functions.Robot;

public class main {

    Queue1 queue1 = new Queue1();
    Queue2 queue2 = new Queue2();
    Queue3 queue3 = new Queue3();
    Statistics chances = new Statistics();
    Admin admin = new Admin();

    public void run() {
        
        admin.checkQueues(queue1, queue2, queue3);

    }

}
