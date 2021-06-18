package proyecto.pkg2.so.vergel.vivas;

import queues.Queue1;

public class Proyecto2SOVergelVivas {
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Queue1 prior1 = new Queue1();
        
        prior1.encolar("1", "1");
        prior1.encolar("2", "2");
        prior1.encolar("3", "3");
        prior1.encolar("1", "3");
        
        System.out.println("tamaño de la cola: "+prior1.queue1Size());
        System.out.println("");
        prior1.showDato();
        System.out.println("");
        
        prior1.desencolar();
        System.out.println("tamaño de la cola: "+prior1.queue1Size());
        System.out.println("");
        prior1.showDato();
        System.out.println("");
        
        prior1.encolar("5", "5");
        System.out.println("tamaño de la cola: "+prior1.queue1Size());
        System.out.println("");
        prior1.showDato();
    }
    
}