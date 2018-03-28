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
    
}       
