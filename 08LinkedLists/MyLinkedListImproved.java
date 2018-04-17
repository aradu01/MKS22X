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
    
    public int max() {
        if (length == 0) {
            return -1;
        }
        
        else {
            int index = 0;
            int counter = 0;
            Node current = first;
            
            while (current != null) {
                if (current.getValue().compareTo(get(index)) > 0) {
                    index = counter;
                }
                
                current = current.getNext();
                counter++;
            }
            
            return index;
        }
    }
    
    public int min() {
        if (length == 0) {
            return -1;
        }
        
        else {
            int index = 0;
            int counter = 0;
            Node current = first;
            
            while (current != null) {
                if (current.getValue().compareTo(get(index)) < 0) {
                    index = counter;
                }
                
                current = current.getNext();
                counter++;
            }
            
            return index;
        }
    }
    
    public void extend(MyLinkedListImproved<Type> other) {
        if (other.size() != 0) {
            if (this.size() == 0) {
                first = other.getNode(0);
                last = other.getNode(other.size() - 1);
                length = other.size();
            }
            
            else {
                last.setNext(other.getNode(0));
                other.getNode(0).setPrev(last);
                last = other.getNode(other.size() - 1);
                length += other.size();
            }
            
            other.clear();
        }
    }
    
    /* For Testing.
    public static void main(String[] args) {
        System.out.println("---------- Minimum and Maximum ----------");
        
        MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
        
        for (int i = 1; i < 11; i++) {
            a.add(new Integer(i));
        }
        
        System.out.println(a);
        System.out.println("Minimum: " + a.get(a.min()));
        System.out.println("Maximum: " + a.get(a.max()));
        
        System.out.println();
        System.out.println("---------- Extend ----------");
        
        MyLinkedListImproved<Integer> b = new MyLinkedListImproved<>();
        
        for (int j = 51; j < 61; j++) {
            b.add(new Integer(j));
        }
        
        System.out.println("First: " + a);
        System.out.println("Second: " + b);
        
        a.extend(b);
        
        System.out.println("First: " + a);
        System.out.println("Second: " + b);
        
        System.out.println();
        System.out.println("---------- Iterator ----------");
        
        MyLinkedListImproved<Integer> c = new MyLinkedListImproved<>();
        
        System.out.println("A: " + b);
        System.out.println("C: " + c);
        
        for (Integer element: a) {
            c.add(element);
        }
        
        System.out.println("C: " + c);
    }
    */

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