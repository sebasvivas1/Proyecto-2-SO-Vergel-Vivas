package functions;

import java.util.concurrent.Semaphore;
import functions.Statistics;

public class Robot extends Thread{
    private Semaphore mutex;
    Statistics chances = new Statistics();
    
    
    public void checkPana(){
        System.out.println("Se está revisando el pana...");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        int result = chances.robotPanas();
        
        if(result <=2) {
            // El pana sale al mercaod (se desencola)
            System.out.println("El pana sale al mercado");
            
        }
        
        if(result >=3 && result <= 7) {
            // El pana se vuelve a encolar.
            System.out.println("El pana se vuelve a encolar");
        }
        
        if(result == 8 || result == 9 ) {
            // Llevar al pana a la cola de reparaciones/mejoras
            System.out.println("El pana necesita reparaciones o mejoras.");
        }
    }
    
    
    
    
    
}
