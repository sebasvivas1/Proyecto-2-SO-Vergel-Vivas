/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functions;
import java.util.Random;

public class Statistics {
    Random rand = new Random();
    
    public int robotPanas(){
        int upperbound = 10;
        int random_int = rand.nextInt(upperbound);
        if(random_int <=2) {
            System.out.println("El pana sale al mercado, numero obtenido: " + random_int);
        }
        if(random_int >=3 && random_int <= 7) {
            System.out.println("El pana vuelve a encolarse, numero obtenido: " + random_int);
        }
        if(random_int == 8 || random_int == 9){
            System.out.println("El pana requiere mejora, numero obtenido: " + random_int);
        }
        
        return random_int;
    }
    
    public int goesToReparation(){
        int upperbound = 100;
        
        int random_int = rand.nextInt(upperbound);
        
        if(random_int <= 44){
            System.out.println("El pana necesita reparacion o mejoras, numero obtenido: " +random_int);
        } else  {
            System.out.println("El pana paso la prueba, numero obtenido: " + random_int);
        }
        
        return random_int;
        
    }
    
    public boolean willCreatePana(){
        int upperbound = 10;
        int random_int = rand.nextInt(upperbound);
        
        return random_int <=7;
    }
    
    public int createPana(){
        int upperbound = 3;
        
        int random_int = rand.nextInt(upperbound);
        
        if(random_int == 0) {
            System.out.println("El pana va a prioridad 1");
        }
        if(random_int == 1) {
            System.out.println("El pana va a prioridad 2");
        }
        if(random_int ==2) {
            System.out.println("El panaa va a prioridad 3.");
        }
        return random_int;
    }
}