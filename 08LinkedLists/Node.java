public class Node {

    private int data;
    private Node prev;
    private Node next;
    
    public String toString() {
        return this.data;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public Node getPrev() {
        return this.prev;
    }
    
    public int getValue() {
        return this.data;
    }
    
}
