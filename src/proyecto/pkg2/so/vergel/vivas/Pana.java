package proyecto.pkg2.so.vergel.vivas;

public class Pana {
    String id;
    String prior;
    String dato;
    Pana next;
    
    public Pana(String i, String priority) {
        
        id = i;
        prior = priority;
        next = null;
        
        dato = id+priority;
    }
}
