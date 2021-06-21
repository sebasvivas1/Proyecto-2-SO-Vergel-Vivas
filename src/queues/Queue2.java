package queues;

public class Queue2 {
    private Pana pFirst;
    private Pana pLast;
    private int size;
    
    public Queue2() {
        this.pFirst = this.pLast = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.pFirst == null;
    }
    
    public void encolar(int id, String prior) {
        Pana newPana = new Pana(id, prior);
        if(isEmpty()) {
            this.pFirst = newPana;
        } else {
            this.pLast.setpNext(newPana);
        }
        this.pLast = newPana;
        size++;
    }
    
    public Pana desencolar() {
        Pana pAux = this.pFirst;
        this.pFirst = this.pFirst.getpNext();
        size--;
        pAux.setpNext(null);
        return pAux;
    }
    
    public void showDato(){
        Pana pAux = this.pFirst;
        while(pAux != null){
            System.out.println(pAux.getDato()); 
            pAux = pAux.getpNext();
        
        }
    }
    
    public Pana firstPana(){
        return this.pFirst;
    }
    
    public int queue1Size(){
        return size;
    }
}