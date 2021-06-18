package queues;

public class Pana {
    private String id;
    private String prior;
    private String dato;
    private Pana pNext;
    
    public Pana(String id, String priority) {
        
        this.id = id;
        this.prior = priority;
        this.pNext = null;
        
        this.dato = id+priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrior() {
        return prior;
    }

    public void setPrior(String prior) {
        this.prior = prior;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public Pana getpNext() {
        return pNext;
    }

    public void setpNext(Pana next) {
        this.pNext = next;
    }
    
    
}
