package proyecto.pkg2.so.vergel.vivas;

import queues.Queue1;
import gui.Interfaz;
import gui.main;
import queues.Pana;
import queues.Queue2;
import queues.Queue3;
import queues.ReparationQueue;

public class Proyecto2SOVergelVivas {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //main main = new main();
        
        //main.run();
        
        
        //Interfaz interfaz = new Interfaz();
        //interfaz.setVisible(true);
        
        Queue1 cola1 = new Queue1();
        Queue2 cola2 = new Queue2();
        Queue3 cola3 = new Queue3();
        ReparationQueue rep = new ReparationQueue();
        
        cola1.encolar(0, "1");
        cola1.encolar(1, "1");
        cola1.encolar(2, "1");
        
        cola2.encolar(3, "2");
        cola2.encolar(4, "2");
        cola2.encolar(5, "2");
        
        cola3.encolar(6, "3");
        cola3.encolar(7, "3");
        cola3.encolar(8, "3");
        
        System.out.println("INICIALMENTE");
        System.out.println("Cola 1:");
        cola1.showDato();
        System.out.println("");
        System.out.println("Cola 2:");
        cola2.showDato();
        System.out.println("");
        System.out.println("Cola 3:");
        cola3.showDato();
        System.out.println("");
        
        Pana aCola3 = cola3.desencolar();
        Pana bCola3 = cola3.desencolar();
        Pana aCola2 = cola2.desencolar();
        
        cola2.enconlarDesdeOtraCola(aCola3);
        cola2.enconlarDesdeOtraCola(bCola3);
        cola1.enconlarDesdeOtraCola(aCola2);
        
        System.out.println("");
        System.out.println("CAMBIOS");
        System.out.println("Cola 1:");
        cola1.showDato();
        System.out.println("");
        System.out.println("Cola 2:");
        cola2.showDato();
        System.out.println("");
        System.out.println("Cola 3:");
        cola3.showDato();
        System.out.println("");
        
        
        
        
        
        
    }
    
}