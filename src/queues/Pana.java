package queues;

public class Pana {
    private int id;
    private String prior;
    private String dato;
    private Pana pNext;
    
    public Pana(int id, String priority) {
        
        this.id = id;
        this.prior = priority;
        this.pNext = null;
        
        this.dato = id+priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
