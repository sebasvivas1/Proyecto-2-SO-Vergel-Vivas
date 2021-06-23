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

    int contadorPana = 100;

    public void checkIfAllEmpty(Queue1 queue1, Queue2 queue2, Queue3 queue3, ReparationQueue repQueue, javax.swing.JTextPane robotBox) {

        robot.showRobot(robotBox);

        if (queue1.isEmpty() && queue2.isEmpty() && queue3.isEmpty()) {
            System.out.println("Las 3 colas estan vacias. Se procede a encolar un Pana aleatoriamente: ");
            int priority = chances.createPana();

            if (priority <= 10) {
                queue1.encolar(contadorPana, "1");
                System.out.println("Se ha encolado un pana en la lista de prioridad 1. ");

            }
            if (priority <= 20 && priority > 10) {
                queue2.encolar(contadorPana, "2");
                System.out.println("Se ha encolado un pana en la lista de prioridad 2. ");
            }
            if (priority <= 30 && priority > 20) {
                queue3.encolar(contadorPana, "3");
                System.out.println("Se ha encolado un pana en la lista de prioridad 3. ");
            }
        } else {
            System.out.println("La cola no se encuentra vacia.");
        }

        System.out.println("\n");
        System.out.println("Cola 1:");
        System.out.println("\n");
        queue1.showDato();
        System.out.println("\n");
        System.out.println("Cola 2:");
        System.out.println("\n");
        queue2.showDato();
        System.out.println("\n");

        System.out.println("Cola 3:");
        System.out.println("\n");
        queue3.showDato();
        System.out.println("\n");

        System.out.println("Cola Reparacion:");
        System.out.println("\n");
        repQueue.showDato();
        System.out.println("\n");

        this.checkQueues(queue1, queue2, queue3, repQueue, robotBox);

    }

    public void checkQueues(Queue1 queue1, Queue2 queue2, Queue3 queue3, ReparationQueue repQueue, javax.swing.JTextPane robotBox) {

        if (!queue1.isEmpty()) {
            System.out.println("El robot va a revisar un Pana de la lista de prioridad 1.");
            revisados++;
            robot.checkPanaQueue1(queue1, repQueue);
            System.out.println("\n");
            System.out.println("Cola 1:");
            System.out.println("\n");
            queue1.showDato();
            System.out.println("\n");
            System.out.println("Cola 2:");
            System.out.println("\n");
            queue2.showDato();
            System.out.println("\n");

            System.out.println("Cola 3:");
            System.out.println("\n");
            queue3.showDato();
            System.out.println("\n");

            System.out.println("Cola Reparacion:");
            System.out.println("\n");
            repQueue.showDato();
            System.out.println("\n");

        } else {

            if (!queue2.isEmpty()) {

                System.out.println("El robot va a revisar un Pana de la lista de prioridad 2 porque la lista de prioridad 1 está vacia.");
                revisados++;

                this.addCounter2(queue2, queue1);
//                Pana pAux = queue2.getpFirst();
//
//                if (pAux.getCounter() == 15) {
//
                    System.out.println("\n");
                    System.out.println("Cola 1:");
                    System.out.println("\n");
                    queue1.showDato();
                    System.out.println("\n");
                    System.out.println("Cola 2:");
                    System.out.println("\n");
                    queue2.showDato();
                    System.out.println("\n");

                    System.out.println("Cola 3:");
                    System.out.println("\n");
                    queue3.showDato();
                    System.out.println("\n");

                    System.out.println("Cola Reparacion:");
                    System.out.println("\n");
                    repQueue.showDato();
                    System.out.println("\n");
//
//                    pAux.setCounter(0);
//                    Pana pAux2 = queue2.desencolar();
//                    queue1.enconlarDesdeOtraCola(pAux2);
//
                    System.out.println("\n");
                    System.out.println("Cola 1:");
                    System.out.println("\n");
                    queue1.showDato();
                    System.out.println("\n");
                    System.out.println("Cola 2:");
                    System.out.println("\n");
                    queue2.showDato();
                    System.out.println("\n");

                    System.out.println("Cola 3:");
                    System.out.println("\n");
                    queue3.showDato();
                    System.out.println("\n");

                    System.out.println("Cola Reparacion:");
                    System.out.println("\n");
                    repQueue.showDato();
                    System.out.println("\n");
//
//                }

                robot.checkPanaQueue2(queue2, repQueue);

            } else if (queue2.isEmpty()) {

                if (!queue3.isEmpty()) {

                    System.out.println("El robot va a revisar un Pana de la lista de prioridad 3 porque la lista de prioridad 1 y 2 están vacías.");
                    revisados++;

                    this.addCounter3(queue3, queue2);
                    Pana pAux = queue3.getpFirst();

                    if (pAux.getCounter() == 15) {

                        System.out.println("\n");
                        System.out.println("Cola 1:");
                        System.out.println("\n");
                        queue1.showDato();
                        System.out.println("\n");
                        System.out.println("Cola 2:");
                        System.out.println("\n");
                        queue2.showDato();
                        System.out.println("\n");

                        System.out.println("Cola 3:");
                        System.out.println("\n");
                        queue3.showDato();
                        System.out.println("\n");

                        System.out.println("Cola Reparacion:");
                        System.out.println("\n");
                        repQueue.showDato();
                        System.out.println("\n");

                        pAux.setCounter(0);
                        Pana pAux2 = queue3.desencolar();
                        queue2.enconlarDesdeOtraCola(pAux2);

                        System.out.println("\n");
                        System.out.println("Cola 1:");
                        System.out.println("\n");
                        queue1.showDato();
                        System.out.println("\n");
                        System.out.println("Cola 2:");
                        System.out.println("\n");
                        queue2.showDato();
                        System.out.println("\n");

                        System.out.println("Cola 3:");
                        System.out.println("\n");
                        queue3.showDato();
                        System.out.println("\n");

                        System.out.println("Cola Reparacion:");
                        System.out.println("\n");
                        repQueue.showDato();
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

            System.out.println("\n");
            System.out.println("Cola 1:");
            System.out.println("\n");
            queue1.showDato();
            System.out.println("\n");
            System.out.println("Cola 2:");
            System.out.println("\n");
            queue2.showDato();
            System.out.println("\n");

            System.out.println("Cola 3:");
            System.out.println("\n");
            queue3.showDato();
            System.out.println("\n");

            System.out.println("Cola Reparacion:");
            System.out.println("\n");
            repQueue.showDato();
            System.out.println("\n");
        }

        System.out.println("Se procede a revisar la cola de bloqueados...");

        if (!repQueue.isEmpty()) {
            System.out.println("La cola de bloqueados tiene elementos...");
            this.blockedQueue(repQueue, queue1, queue2, queue3);
        } else {
            System.out.println("La cola de bloqueados se encuentra vacia...");
        }

    }

    public void blockedQueue(ReparationQueue repQueue, Queue1 queue1, Queue2 queue2, Queue3 queue3) {
        int result = chances.goesToReparation();

        System.out.println("\n");
        System.out.println("Cola 1:");
        System.out.println("\n");
        queue1.showDato();
        System.out.println("\n");
        System.out.println("Cola 2:");
        System.out.println("\n");
        queue2.showDato();
        System.out.println("\n");

        System.out.println("Cola 3:");
        System.out.println("\n");
        queue3.showDato();
        System.out.println("\n");

        System.out.println("Cola Reparacion:");
        System.out.println("\n");
        repQueue.showDato();
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("Cola 1:");
        System.out.println("\n");
        queue1.showDato();
        System.out.println("\n");
        System.out.println("Cola 2:");
        System.out.println("\n");
        queue2.showDato();
        System.out.println("\n");

        System.out.println("Cola 3:");
        System.out.println("\n");
        queue3.showDato();
        System.out.println("\n");

        System.out.println("Cola Reparacion:");
        System.out.println("\n");
        repQueue.showDato();
        System.out.println("\n");

        if (result <= 44) {
            // El pana pasó la prueba y se mueve a la cola de listos para revision (cola correspondiente a su prioridad)
            System.out.println("El pana paso la prueba y se mueve a su lista correspondiente.");
            Pana pAux = repQueue.desencolar();
            String pPrior = pAux.getPrior();
            if (pPrior.equals("1")) {
                queue1.enconlarDesdeOtraCola(pAux);
                System.out.println("El pana: " + pAux.getDato() + " se movio a la lista de prioridad 1");
            }
            if (pPrior.equals("2")) {
                queue2.enconlarDesdeOtraCola(pAux);
                System.out.println("El pana: " + pAux.getDato() + " se movio a la lista de prioridad 2");

            }
            if (pPrior.equals("3")) {
                queue3.enconlarDesdeOtraCola(pAux);
                System.out.println("El pana: " + pAux.getDato() + " se movio a la lista de prioridad 3");

            }
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
            if (priorList <= 10) {

                // Se añade a la lista de prioridad 1.
                queue1.encolar(contadorPana, "1");
                contadorPana++;
            }
            if (priorList <= 20 && priorList > 10) {

                // Se añade a la lista de prioridad 2.
                queue2.encolar(contadorPana, "2");
                contadorPana++;
            }

            if (priorList <= 30 && priorList > 20) {

                // Se añade a la lista de prioridad 3.
                queue3.encolar(contadorPana, "3");
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
            
            if(pAddCounter.getCounter() == 15) {
                System.out.println("\nEl pana: " + pAddCounter.getDato() + "tiene el contador = " + pAddCounter.getCounter() + " y fue trasladado a la cola de prioridad 1.\n");
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
            
            if(pAddCounter.getCounter() == 15) {
                                System.out.println("\nEl pana: " + pAddCounter.getDato() + "tiene el contador = " + pAddCounter.getCounter() + " y fue trasladado a la cola de prioridad 2.\n");

                pAddCounter.setCounter(0);
                queue2.enconlarDesdeOtraCola(pAddCounter);
                queue3.desencolar();
            } else {
            
            Pana pReQueue = queue3.desencolar();
            queue3.enconlarDesdeOtraCola(pReQueue);
            }
        }
    }

}
