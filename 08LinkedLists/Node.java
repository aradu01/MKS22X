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
    
    public void setNext(Node replacement) {
        next = replacement;
    }
    
    public Node getPrev() {
        return this.prev;
    }
    
    public Node setPrev(Node replacement) {
        prev = replacement;
    }
    
    public int getValue() {
        return this.data;
    }
    
    public void setValue(int replacement) {
        data = replacement;
    }
    
}
