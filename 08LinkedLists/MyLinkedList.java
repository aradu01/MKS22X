public class MyLinkedList {

    private int length;
    private Node first;
    private Node last;

    public MyLinkedList() {
    }
    
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

    private Node getNode(int index) {
	int place = 0;
	Node current = first;

	while (place < index) {
            current = current.getNext();
            place++;
        }

	return current;
    }
    
    public int get(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalStateException("Your index must be within the Linked List.");
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
    
    public void set(int index, int value) {
        if (index < 0 || index >= length) {
            throw new IllegalStateException("Your index must be within the Linked List.");
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
	
        current.setValue(value);
    }
    
    public int indexOf(int value) {
        Node current = first;
        int index = 0;
        
        while (current != null) {
            if (current.getValue() == value) {
                return index;
            }
            
            else {
                current = current.getNext();
                index++;
            }
        }
        
        return -1;
    }
    
    public boolean add(int value) {
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
	}
        
        length++;

	return true;
    }
    
    public void add(int index, int value) {
        if (index < 0 || index > length) {
            throw new IllegalStateException("Your index must be within the Linked List.");
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
    
    public int remove(int index) {
        if (index < 0 || index >= length) {
            throw new IllegalStateException("Your index must be within the Linked List.");
        }
        
        Node before = getNode(index - 1);
        Node current = getNode(index);
        Node after = getNode(index + 1);

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
        
        before.setNext(after);
        after.setPrev(before);
        
        current.setPrev(null);
        current.setNext(null);
        
        length--;
        
        return current.getValue();
    }
    
}
