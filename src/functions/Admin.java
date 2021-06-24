package functions;

import queues.Queue1;
import queues.Queue2;
import queues.Queue3;
import queues.ReparationQueue;
import functions.Statistics;
import functions.Robot;
import gui.Interfaz;

import queues.Pana;

public class Admin {

    Statistics chances = new Statistics();

    Robot robot = new Robot();

    int revisados = 0;

    int contadorPana = 100;

    javax.swing.JTextPane robotBox;
    javax.swing.JTextPane repairsQueue;

    public void showInterface(
            javax.swing.JTextPane robotBox, javax.swing.JTextPane repairsQueue) {
        this.robotBox = robotBox;
        this.repairsQueue = repairsQueue;
    }

    public void checkIfAllEmpty(Queue1 queue1, Queue2 queue2, Queue3 queue3, ReparationQueue repQueue) {

        if (queue1.isEmpty() && queue2.isEmpty() && queue3.isEmpty()) {
            int priority = chances.createPana();

            if (priority <= 10) {
                queue1.encolar(contadorPana, "1");
                Interfaz.queue1.setText(queue1.showInfo());

            }
            if (priority <= 20 && priority > 10) {
                queue2.encolar(contadorPana, "2");
                Interfaz.queue2.setText(queue2.showInfo());

            }
            if (priority <= 30 && priority > 20) {
                queue3.encolar(contadorPana, "3");
                Interfaz.queue3.setText(queue3.showInfo());

            }
        } else {
        }

        this.checkQueues(queue1, queue2, queue3, repQueue);

    }

    public void checkQueues(Queue1 queue1, Queue2 queue2, Queue3 queue3, ReparationQueue repQueue) {

        robot.showRobot(this.robotBox);
        this.showData(queue1, queue2, queue3, repQueue);
        if (!queue1.isEmpty()) {
            revisados++;
            robot.checkPanaQueue1(queue1, repQueue);
            queue1.showDato();
        } else {

            if (!queue2.isEmpty()) {

                revisados++;

                this.addCounter2(queue2, queue1);
                robot.checkPanaQueue2(queue2, repQueue);
                queue2.showDato();
            } else if (queue2.isEmpty()) {

                if (!queue3.isEmpty()) {

                    revisados++;

                    this.addCounter3(queue3, queue2);
                    Pana pAux = queue3.getpFirst();

                    if (pAux.getCounter() == 15) {

                        pAux.setCounter(0);
                        Pana pAux2 = queue3.desencolar();
                        queue2.enconlarDesdeOtraCola(pAux2);

                    }

                    robot.checkPanaQueue3(queue3, repQueue);
                    queue3.showDato();
                } else {
                    this.checkIfAllEmpty(queue1, queue2, queue3, repQueue);
                }
            }

        }

        if (revisados == 2) {
            this.addPana(queue1, queue2, queue3);
            revisados = 0;

        }

        if (!repQueue.isEmpty()) {
            this.blockedQueue(repQueue, queue1, queue2, queue3);
        } else {
        }

    }

    public void blockedQueue(ReparationQueue repQueue, Queue1 queue1, Queue2 queue2, Queue3 queue3) {
        repQueue.showDato();
        int result = chances.goesToReparation();

        if (result <= 44) {
            // El pana pasó la prueba y se mueve a la cola de listos para revision (cola correspondiente a su prioridad)
            Pana pAux = repQueue.desencolar();
            String pPrior = pAux.getPrior();
            if (pPrior.equals("1")) {
                queue1.enconlarDesdeOtraCola(pAux);
            }
            if (pPrior.equals("2")) {
                queue2.enconlarDesdeOtraCola(pAux);

            }
            if (pPrior.equals("3")) {
                queue3.enconlarDesdeOtraCola(pAux);

            }
        } else {
            // El pana se vuelve a encolar en la lista de bloqueados
            Pana pAux = repQueue.desencolar();
            repQueue.enconlar(pAux);

        }
        this.showData(queue1, queue2, queue3, repQueue);
    }

    public void addPana(Queue1 queue1, Queue2 queue2, Queue3 queue3) {
        boolean flag = chances.willCreatePana();
        if (flag) {
            int priorList = chances.createPana();
            if (priorList <= 10) {

                // Se añade a la lista de prioridad 1.
                queue1.encolar(contadorPana, "1");
                Interfaz.queue1.setText(queue1.showInfo());
                contadorPana++;
            }
            if (priorList <= 20 && priorList > 10) {

                // Se añade a la lista de prioridad 2.
                queue2.encolar(contadorPana, "2");
                Interfaz.queue2.setText(queue2.showInfo());

                contadorPana++;
            }

            if (priorList <= 30 && priorList > 20) {

                // Se añade a la lista de prioridad 3.
                queue3.encolar(contadorPana, "3");
                Interfaz.queue3.setText(queue3.showInfo());

                contadorPana++;
            }
        }
        
    }

    public void addCounter2(Queue2 queue2, Queue1 queue1) {
        Pana pAux = queue2.desencolar();
        queue2.enconlarDesdeOtraCola(pAux);
        while (pAux != queue2.getpFirst()) {
            Pana pAddCounter = queue2.getpFirst();
            pAddCounter.addCounter();

            if (pAddCounter.getCounter() == 15) {
                pAddCounter.setCounter(0);
                queue1.enconlarDesdeOtraCola(pAddCounter);
                queue2.desencolar();
            } else {

                Pana pReQueue = queue2.desencolar();
                queue2.enconlarDesdeOtraCola(pReQueue);
            }
        }
    }

    public void addCounter3(Queue3 queue3, Queue2 queue2) {
        Pana pAux = queue3.desencolar();
        queue3.enconlarDesdeOtraCola(pAux);
        while (pAux != queue3.getpFirst()) {
            Pana pAddCounter = queue3.getpFirst();
            pAddCounter.addCounter();

            if (pAddCounter.getCounter() == 15) {

                pAddCounter.setCounter(0);
                queue2.enconlarDesdeOtraCola(pAddCounter);
                queue3.desencolar();
            } else {

                Pana pReQueue = queue3.desencolar();
                queue3.enconlarDesdeOtraCola(pReQueue);
            }
        }
    }

    public void showData(Queue1 queue1, Queue2 queue2, Queue3 queue3, ReparationQueue repQueue) {
        Interfaz.queue1.setText(queue1.showInfo());
        Interfaz.queue2.setText(queue2.showInfo());
        Interfaz.queue3.setText(queue3.showInfo());
        Interfaz.repairsQueue.setText(repQueue.showInfo());

    }

}
