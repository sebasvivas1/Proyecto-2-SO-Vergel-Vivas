package functions;

import queues.Queue1;
import queues.Queue2;
import queues.Queue3;
import functions.Statistics;

import java.util.concurrent.Semaphore;

public class Admin {

    private Semaphore mutex;

    Statistics chances = new Statistics();

    public void checkIfAllEmpty(Queue1 queue1, Queue2 queue2, Queue3 queue3) {

        if (queue1.isEmpty() && queue2.isEmpty() && queue3.isEmpty()) {
            System.out.println("Las 3 colas estan vacias. Se procede a encolar un Pana aleatoriamente: ");
            int priority = chances.createPana();

            if (priority == 0) {
                queue1.encolar(0, "1");
                System.out.println("Se ha encolado un pana en la lista de prioridad 1. ");
                queue1.showDato();
            }
            if (priority == 1) {
                queue2.encolar(0, "2");
                System.out.println("Se ha encolado un pana en la lista de prioridad 2. ");
                queue2.showDato();
            }
            if (priority == 2) {
                queue3.encolar(0, "3");
                System.out.println("Se ha encolado un pana en la lista de prioridad 3. ");
                queue3.showDato();
            }
        } else {
            System.out.println("La cola no se encuentra vacia.");
        }

        this.checkQueues(queue1, queue2, queue3);

    }

    public void checkQueues(Queue1 queue1, Queue2 queue2, Queue3 queue3) {

        if (!queue1.isEmpty()) {
            System.out.println("El robot va a revisar un Pana de la lista de prioridad 1.");

        } else {

            if (!queue2.isEmpty()) {

                System.out.println("El robot va a revisar un Pana de la lista de prioridad 2 porque la lista de prioridad 1 está vacia.");

            } else if (queue2.isEmpty()) {

                if (!queue3.isEmpty()) {

                    System.out.println("El robot va a revisar un Pana de la lista de prioridad 3 porque la lista de prioridad 1 y 2 están vacías.");

                } else {
                    this.checkIfAllEmpty(queue1, queue2, queue3);
                }
            }

        }

    }

    public void blockedQueue() {
        int result = chances.goesToReparation();
        if (result <= 44) {
            // El pana pasó la prueba y se mueve a la cola de listos para revision (cola correspondiente a su prioridad)
            System.out.println("El pana paso la prueba y se mueve a su lista correspondiente.");
        } else {
            // El pana se vuelve a encolar en la lista de bloqueados
            System.out.println("El pana no paso la prueba, vuelve a encolarse.");
        }
    }

    public void addPana(Queue1 queue1, Queue2 queue2, Queue3 queue3) {
        boolean flag = chances.willCreatePana();
        if (flag) {
            int priorList = chances.createPana();
            if (priorList == 0) {
                int contadorPana1 = 1;

                // Se añade a la lista de prioridad 1.
                queue1.encolar(contadorPana1, "1");
                contadorPana1++;
            }
            if (priorList == 1) {
                int contadorPana2 = 2;
                // Se añade a la lista de prioridad 2.
                queue2.encolar(contadorPana2, "2");
                contadorPana2++;
            }

            if (priorList == 2) {
                int contadorPana3 = 3;
                // Se añade a la lista de prioridad 3.
                queue3.encolar(contadorPana3, "3");
                contadorPana3++;
            }
        }
    }

}
