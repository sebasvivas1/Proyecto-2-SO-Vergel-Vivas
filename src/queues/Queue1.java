package queues;

public class Queue1 {
    private Pana pFirst;
    private Pana pLast;
    private int size;
    
    public Queue1() {
        this.pFirst = this.pLast = null;
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.pFirst == null;
    }
    
    public void encolar(String id, String prior) {
        Pana newPana = new Pana(id, prior);
        if(isEmpty()) {
            this.pFirst = newPana;
        } else {
            this.pLast.setpNext(newPana);
        }
        this.pLast = newPana;
        size++;
    }
    
    public void desencolar() {
        Pana pAux = this.pFirst;
        this.pFirst = this.pFirst.getpNext();
        //Enviar a pAux a otra cola instanciado la otra cola en esta clase
        size--;
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

