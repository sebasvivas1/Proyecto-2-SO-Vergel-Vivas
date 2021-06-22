package functions;

import queues.Queue1;
import queues.Queue2;
import queues.Queue3;
import queues.ReparationQueue;
import functions.Statistics;
import functions.Robot;

import queues.Pana;

public class Admin {

    Statistics chances = new Statistics();

    Robot robot = new Robot();

    int revisados = 0;

    int contadorPana1 = 0;
    int contadorPana2 = 0;
    int contadorPana3 = 0;

    public void checkIfAllEmpty(Queue1 queue1, Queue2 queue2, Queue3 queue3, ReparationQueue repQueue, javax.swing.JTextPane robotBox) {

        robot.showRobot(robotBox);

        if (queue1.isEmpty() && queue2.isEmpty() && queue3.isEmpty()) {
            System.out.println("Las 3 colas estan vacias. Se procede a encolar un Pana aleatoriamente: ");
            int priority = chances.createPana();

            if (priority == 0) {
                queue1.encolar(contadorPana1, "1");
                System.out.println("Se ha encolado un pana en la lista de prioridad 1. ");

            }
            if (priority == 1) {
                queue2.encolar(contadorPana2, "2");
                System.out.println("Se ha encolado un pana en la lista de prioridad 2. ");
            }
            if (priority == 2) {
                queue3.encolar(contadorPana3, "3");
                System.out.println("Se ha encolado un pana en la lista de prioridad 3. ");
            }
        } else {
            System.out.println("La cola no se encuentra vacia.");
        }

        this.checkQueues(queue1, queue2, queue3, repQueue, robotBox);

    }

    public void checkQueues(Queue1 queue1, Queue2 queue2, Queue3 queue3, ReparationQueue repQueue, javax.swing.JTextPane robotBox) {

        if (!queue1.isEmpty()) {
            System.out.println("El robot va a revisar un Pana de la lista de prioridad 1.");
            revisados++;
            this.addCounter1(queue1);
            robot.checkPanaQueue1(queue1, repQueue);
            System.out.println("\n");
            System.out.println("Cola 1:");
            System.out.println("\n");
            queue1.showDato();
            System.out.println("\n");

        } else {

            if (!queue2.isEmpty()) {

                System.out.println("El robot va a revisar un Pana de la lista de prioridad 2 porque la lista de prioridad 1 está vacia.");
                revisados++;

                this.addCounter2(queue2);
                Pana pAux = queue2.getpFirst();

                if (pAux.getCounter() == 15) {

                    System.out.println("\n");
                    System.out.println("Cola 2:");
                    queue2.showDato();
                    System.out.println("\n");

                    System.out.println("\n");
                    System.out.println("Cola 1:");
                    queue1.showDato();
                    System.out.println("\n");

                    pAux.setCounter(0);
                    Pana pAux2 = queue2.desencolar();
                    queue1.enconlarDesdeOtraCola(pAux2);

                    System.out.println("\n");
                    System.out.println("Cola 2:");
                    queue2.showDato();
                    System.out.println("\n");

                    System.out.println("\n");
                    System.out.println("Cola 1:");
                    queue1.showDato();
                    System.out.println("\n");
                }

                robot.checkPanaQueue2(queue2, repQueue);

            } else if (queue2.isEmpty()) {

                if (!queue3.isEmpty()) {

                    System.out.println("El robot va a revisar un Pana de la lista de prioridad 3 porque la lista de prioridad 1 y 2 están vacías.");
                    revisados++;

                    this.addCounter3(queue3);
                    Pana pAux = queue3.getpFirst();

                    if (pAux.getCounter() == 15) {

                        System.out.println("Cola 3:");
                        System.out.println("\n");
                        queue3.showDato();
                        System.out.println("\n");
                        System.out.println("Cola 2:");
                        queue2.showDato();
                        System.out.println("\n");

                        pAux.setCounter(0);
                        Pana pAux2 = queue3.desencolar();
                        queue2.enconlarDesdeOtraCola(pAux2);

                        System.out.println("Cola 3:");
                        System.out.println("\n");
                        queue3.showDato();
                        System.out.println("\n");
                        System.out.println("Cola 2:");
                        queue2.showDato();
                        System.out.println("\n");
                    }

                    robot.checkPanaQueue3(queue3, repQueue);

                } else {
                    this.checkIfAllEmpty(queue1, queue2, queue3, repQueue, robotBox);
                }
            }

        }

        if (revisados == 2) {
            System.out.println("\n Se ha agregado un pana nuevo. \n");
            this.addPana(queue1, queue2, queue3);
            revisados = 0;
        }

        System.out.println("Se procede a revisar la cola de bloqueados...");

        if (!repQueue.isEmpty()) {
            System.out.println("La cola de bloqueados tiene elementos...");
            this.blockedQueue(repQueue);
        } else {
            System.out.println("La cola de bloqueados se encuentra vacia...");
        }

    }

    public void blockedQueue(ReparationQueue repQueue) {
        int result = chances.goesToReparation();
        if (result <= 44) {
            // El pana pasó la prueba y se mueve a la cola de listos para revision (cola correspondiente a su prioridad)
            System.out.println("El pana paso la prueba y se mueve a su lista correspondiente.");
        } else {
            // El pana se vuelve a encolar en la lista de bloqueados
            System.out.println("El pana no paso la prueba, vuelve a encolarse.");
            Pana pAux = repQueue.desencolar();
            repQueue.enconlar(pAux);

        }
    }

    public void addPana(Queue1 queue1, Queue2 queue2, Queue3 queue3) {
        boolean flag = chances.willCreatePana();
        if (flag) {
            int priorList = chances.createPana();
            if (priorList == 0) {

                // Se añade a la lista de prioridad 1.
                queue1.encolar(contadorPana1, "1");
                contadorPana1++;
            }
            if (priorList == 1) {

                // Se añade a la lista de prioridad 2.
                queue2.encolar(contadorPana2, "2");
                contadorPana2++;
            }

            if (priorList == 2) {

                // Se añade a la lista de prioridad 3.
                queue3.encolar(contadorPana3, "3");
                contadorPana3++;
            }
        }
    }

    public void addCounter1(Queue1 queue1) {
        Pana pAux = queue1.getpFirst();
        while (pAux != null) {
            pAux.addCounter();
            System.out.println("Panas revisados en cola 1: " + pAux.getCounter());
            pAux = pAux.getpNext();
        }
    }

    public void addCounter2(Queue2 queue2) {
        Pana pAux = queue2.getpFirst();
        while (pAux != null) {
            pAux.addCounter();
            System.out.println("Panas revisados en cola 2: " + pAux.getCounter());

            pAux = pAux.getpNext();
        }
    }

    public void addCounter3(Queue3 queue3) {
        Pana pAux = queue3.getpFirst();
        while (pAux != null) {
            pAux.addCounter();
            System.out.println("Panas revisados en cola 3: " + pAux.getCounter());

            pAux = pAux.getpNext();
        }
    }

}
