package proyecto.pkg2.so.vergel.vivas;

public class Queue1 {
    Pana beginning;
    Pana end;
    int size;
    
    public Queue1() {
        beginning=end=null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return beginning == null;
    }
    
    public void insert(int pana) {
        Pana newPana = new Pana(pana);
        if(isEmpty()) {
            beginning = newPana;
        } else {
            end.next = newPana;
        }
        end = newPana;
        size++;
    }
    
    public int delete() {
        int aux = beginning.dato;
        beginning = beginning.next;
        size--;
        return aux;
    }
    
    public int firstPana(){
        return beginning.dato;
    }
    
    public int queueSize(){
        return size;
    }
}

