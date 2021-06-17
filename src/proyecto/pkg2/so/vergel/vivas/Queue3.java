package proyecto.pkg2.so.vergel.vivas;

public class Queue3 {
    Pana beginning;
    Pana end;
    int size;
    
    public Queue3() {
        beginning=end=null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return beginning == null;
    }
    
    public void insert(int id, int prior) {
        Pana newPana = new Pana(id, prior);
        if(isEmpty()) {
            beginning = newPana;
        } else {
            end.next = newPana;
        }
        end = newPana;
        size++;
    }
    
    public int delete() {
        int aux = beginning.int;
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
