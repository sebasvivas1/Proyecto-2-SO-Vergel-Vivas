/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;

import java.util.Random;

public class Statistics {

    Random rand = new Random();

    public int robotPanas() {
        int upperbound = 10;
        int random_int = rand.nextInt(upperbound);
        return random_int;
    }

    public int goesToReparation() {
        int upperbound = 100;

        int random_int = rand.nextInt(upperbound);
        return random_int;

    }

    public boolean willCreatePana() {
        int upperbound = 10;
        int random_int = rand.nextInt(upperbound);

        return random_int <= 7;
    }

    public int createPana() {
        int upperbound = 30;

        int random_int = rand.nextInt(upperbound);

        if (random_int <=10 ) {
            System.out.println("El pana va a prioridad 1");
        }
        if (random_int <=20 && random_int > 10) {
            System.out.println("El pana va a prioridad 2");
        }
        if (random_int <=30 && random_int > 20) {
            System.out.println("El pana va a prioridad 3.");
        }
        return random_int;
    }
}
