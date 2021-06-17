package proyecto.pkg2.so.vergel.vivas;

public class Queue2 {
    Pana beginning;
    Pana end;
    int size;
    
    public Queue2() {
        beginning=end=null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return beginning == null;
    }
    
    public void insert(String id, String prior) {
        Pana newPana = new Pana(id, prior);
        if(isEmpty()) {
            beginning = newPana;
        } else {
            end.next = newPana;
        }
        end = newPana;
        size++;
    }
    
    public String delete() {
        String aux = beginning.id;
        beginning = beginning.next;
        size--;
        return aux;
    }
    
    public String firstPana(){
        return beginning.id;
    }
    
    public int queueSize(){
        return size;
    }

    
}
