package queues;

public class Queue2 {
    private Pana pFirst;
    private Pana pLast;
    private int size;
    javax.swing.JTextPane showQueue2;
    
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
    
    public void enconlarDesdeOtraCola(Pana rPana) { //RECIBE AL PANA PARA ENCOLARLO CUANDO VIENE DE OTRA COLA
        if (isEmpty()) {
            this.pFirst = rPana;
        } else {
            this.pLast.setpNext(rPana);
        }
        this.pLast = rPana;
        size++;
    }
    
    public Pana desencolar() {
        Pana pAux = this.pFirst;
        this.pFirst = this.pFirst.getpNext();
        size--;
        pAux.setpNext(null);
        return pAux;
    }
    
    public void showDato() {
        String queue = "";
        Pana pAux = this.pFirst;
        while (pAux != null) {
            queue += pAux.getDato() + "\n";
            pAux = pAux.getpNext();

        }
        this.showQueue2.setText(queue);
        System.out.println(queue);

    }
    
        public String showInfo() {
        String txt = "" ;
        if (!isEmpty()) {
            Pana temp = pFirst;
            while (temp != null) {
               txt +=temp.getDato()+"\n";
               temp = temp.getpNext();
            }
        } 
        else { txt = "       No hay juguetes en \n              esta cola"; }
        return txt;
    }
    
    public void showInterfaz(javax.swing.JTextPane showQueue2){
        this.showQueue2 = showQueue2;
    }

    
    public Pana firstPana(){
        return this.pFirst;
    }
    
    public int queue1Size(){
        return size;
    }

    public Pana getpFirst() {
        return pFirst;
    }

    public void setpFirst(Pana pFirst) {
        this.pFirst = pFirst;
    }

    public Pana getpLast() {
        return pLast;
    }

    public void setpLast(Pana pLast) {
        this.pLast = pLast;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
}