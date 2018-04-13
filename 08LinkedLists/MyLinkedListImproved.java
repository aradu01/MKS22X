import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedListImproved<Type extends Comparable<Type>> implements Iterable<Type> {

    private int length;
    private Node first;
    private Node last;
    
    public MyLinkedListImproved() {
        clear();
    }
    
    public String toString() {
        String result = "[";
        Node current = first;
        
        while (current != null) {
            if (current.getNext() == null) {
                result += current.getValue();
            }

            else {
                result += current.getValue() + ", ";
            }
	    
            current = current.getNext();
        }
        
        return result + "]";
    }

    public void clear() {  // Doesn't throw exceptions.
        first = null;
        last = null;
        length = 0;
    }
    
    public int size() {  // Doesn't throw exceptions.
        return length;
    }
    
    /* For Testing.
    public Node getFirst() {      
        return first;
    }
    
    public Node getLast() {
        return last;
    }
    */
    
    private Node getNode(int index) {
        int place = 0;
        Node current = first;

        while (place < index) {
            current = current.getNext();
            place++;
        }
	
        return current;
    }
    
    public Type get(int index) {  // Throws IndexOutOfBoundsException.
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }

        Node current = getNode(index);

        /*
        int place = 0;
        Node current = first;

        while (place < index) {
                current = current.getNext();
                place++;
        }
        */
        
        return current.getValue();
    }
    
    public Type set(int index, Type value) {  // Throws IndexOutOfBoundsException.
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }

        Node current = getNode(index);
        Type result = current.getValue();

	/*
        int place = 0;
        Node current = first;

        while (place < index) {
            current = current.getNext();
            place++;
        }
        */
	
        current.setValue(value);
        return result;
    }
    
    public int indexOf(Type value) {  // Doesn't throw exceptions.
        Node current = first;
        int index = 0;
        
        while (current != null) {
            if (current.getValue().equals(value)) {
                return index;
            }
            
            else {
                current = current.getNext();
                index++;
            }
        }
        
        return -1;
    }
    
    public boolean add(Type value) {  // Doesn't throw exceptions.
        /*
        Node before = first;
        
        while (before.getNext() != null) {
            before = before.getNext();
        }
        */  
	
        Node addend = new Node(value);

        if (length == 0) {
            first = addend;
            last = first;
        }

        else if (length == 1) {
            last = addend;
            first.setNext(last);
            last.setPrev(first);
        }

        else {
            last.setNext(addend);
            addend.setPrev(last);
            last = addend;
        }
        
        length++;

        return true;
    }
    
    public void add(int index, Type value) {  // Throws IndexOutOfBoundsException.
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException();
        }

        /*
        int place = 0;
            Node before = first;
            Node after = first;

            while (place < index - 1) {
                before = before.getNext();
                after = after.getNext();
                place++;
            }
        after = after.getNext();
        */

        Node additive = new Node(value);
	
        if (index == 0) {
            if (length == 0) {
                first = additive;
                last = first;
            }

            else {
                first.setPrev(additive);
                additive.setNext(first);
                first = additive;
            }
        }

        else if (index == length) {
            add(value);
	    length--;
        }

        else {
            Node before = getNode(index - 1);
            Node after = getNode(index);

            before.setNext(additive);
            additive.setPrev(before);

            additive.setNext(after);
            after.setPrev(additive);
        }

        length++;
    }
    
    public boolean remove(Type value) {  // Doesn't throw exceptions.
        int index = indexOf(value);
        
        if (index == -1) {
            return false;
        }
        
        else {
            remove(index);
            return true;
        }
    }
    
    public Type remove(int index) {  // Throws IndexOutOfBoundsException.
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException();
        }
        
        /*
        int place = 0;
        Node before = first;
        Node current = first;
        Node after = first;

        while (place < index - 1) {
            before = before.getNext();
            current = current.getNext();
            after = after.getNext();
            place++;
        }
        current = current.getNext();
        after = after.getNext().getNext();
        */
        
        Node deletion;
        
        if (length == 0) {
            return null;
        }
        
        else if (length == 1) {
            deletion = getNode(0);
            clear();
        }
        
        else if (index == 0) {
            deletion = first;
            first = first.getNext();
            
            deletion.setNext(null);
            first.setPrev(null);
        }
        
        else if (index == length - 1) {
            deletion = last;
            last = last.getPrev();
            
            deletion.setPrev(null);
            last.setNext(null);
        }
        
        else {
            Node before = getNode(index - 1);
            deletion = getNode(index);
            Node after = getNode(index + 1);

            before.setNext(after);
            after.setPrev(before);

            deletion.setPrev(null);
            deletion.setNext(null);
        }
        
        length--;
        
        return deletion.getValue();
        // return true;
    }

    // Below lies the private Node class.

    private class Node {

        private Type data;
        private Node prev;
        private Node next;

        public Node(Type value) {
            data = value;
        }

        public Node(Type value, Node before, Node after) {
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

        public Type getValue() {
            return data;
        }

        public void setValue(Type replacement) {
            data = replacement;
        }
    
    }

    // Below lies the private LinkedListIterator class.

    public Iterator<Type> iterator() {
	return new LinkedListIterator(first);
    }
    
    private class LinkedListIterator implements Iterator<Type> {
	
	private Node next;

	public LinkedListIterator(Node begin) {
	    next = begin;
	}

	public boolean hasNext() {
	    return next != null;

	    /*
	    if (next == null) {
		return false;
	    }

	    else {
		return true;
	    }
	    */
	}

	public Type next() {
	    if (hasNext()) {
		Node result = next;
		next = next.getNext();
		
		return result.getValue();
	    }

	    else {
		throw new NoSuchElementException();
	    }
	}
	
    }
    
}
