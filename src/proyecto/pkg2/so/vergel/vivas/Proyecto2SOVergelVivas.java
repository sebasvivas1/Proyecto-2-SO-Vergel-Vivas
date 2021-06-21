package proyecto.pkg2.so.vergel.vivas;

import queues.Queue1;
import gui.Interfaz;
import gui.main;
import queues.Pana;
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
        
        Queue1 cola = new Queue1();
        ReparationQueue rep = new ReparationQueue();
        
        cola.encolar(0, "1");
        cola.encolar(2, "2");
        cola.encolar(3, "3");
        
        System.out.println("Cola 1 tiene:");
        cola.showDato();
        System.out.println("");
        System.out.println("Ahora cola 1 tiene: ");
        
        Pana pAux = cola.desencolar();
        cola.showDato();
        
        System.out.println("");
        System.out.println("La cola de reparaciones tiene: ");
        rep.enconlar(pAux);
        rep.showDato();
        
    
        
        
        
        
    }
    
}