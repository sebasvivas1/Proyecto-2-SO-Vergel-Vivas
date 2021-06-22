package queues;

public class ReparationQueue {

    private Pana pFirst;
    private Pana pLast;
    private int size;

    public ReparationQueue() {
        this.pFirst = this.pLast = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.pFirst == null;
    }

    public void enconlar(Pana rPana) { //RECIBE AL PANA PARA ENCOLARLO
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
        Pana pAux = this.pFirst;
        while (pAux != null) {
            System.out.println(pAux.getDato());
            pAux = pAux.getpNext();

        }
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
