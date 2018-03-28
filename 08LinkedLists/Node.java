public class Node {

    private int data;
    private Node prev;
    private Node next;

    public Node(int value) {
	data = value;
    }

    public Node(int value, Node before, Node after) {
	data = value;

	prev = before;
	next = after;
    }
    
    public String toString() {
        return data + "";
    }
    
    public Node getNext() {
        return next;
    }
    
    public void setNext(Node replacement) {
        next = replacement;
    }
    
    public Node getPrev() {
        return prev;
    }
    
    public void setPrev(Node replacement) {
        prev = replacement;
    }
    
    public int getValue() {
        return data;
    }
    
    public void setValue(int replacement) {
        data = replacement;
    }
    
}
