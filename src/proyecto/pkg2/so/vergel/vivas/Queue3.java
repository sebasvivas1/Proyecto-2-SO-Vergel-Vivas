package proyecto.pkg2.so.vergel.vivas;

public class Queue3 {
    Node beginning, end;
    int size;
    
    public Queue3() {
        beginning=end=null;
        size = 0;
    }
    
    public boolean isEmpty() {
        return beginning == null;
    }
    
    public void insert(int pana) {
        Node newNode = new Node(pana);
        if(isEmpty()) {
            beginning = newNode;
        } else {
            end.next = newNode;
        }
        end = newNode;
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
