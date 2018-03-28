public class MyLinkedList {

    private int length;
    private Node first;
    private Node last;
    
    public String toString() {
        String result = "[";
        Node current = first;
        
        while (current != null) {
            result += current.getValue() + ", ";
            current = current.getNext();
        }
        
        return result + "]";
    }
    
    public int size() {
        return length;
    }
    
    public int get(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalStateException("Your index must be within the Linked List.");
        }
        
        int place = 0;
        Node current = first;
        
        while (place < index) {
            current = current.getNext();
            place++;
        }
        
        return current.getValue();
    }
    
    public void set(int index, int value) {
        if (index < 0 || index >= length) {
            throw new IllegalStateException("Your index must be within the Linked List.");
        }
        
        int place = 0;
        Node current = first;
        
        while (place < index) {
            current = current.getNext();
            place++;
        }
        
        current.setValue(value);
    }
    
    public void add(int index, int value) {
        if (index < 0 || index >= length) {
            throw new IllegalStateException("Your index must be within the Linked List.");
        }
        
        int place = 0;
        Node before = first;
        Node after = first;
        
        while (place < index - 1) {
            before = before.getNext();
            after = after.getNext();
            place++;
        }
        after = after.getNext();
        
        Node addend = new Node();
        addend.setValue(value);
        
        before.setNext(addend);
        addend.setPrev(before);
        
        addend.setNext(after);
        after.setPrev(addend);
    }
    
}
