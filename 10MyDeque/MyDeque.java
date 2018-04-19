public class MyDeque<Type> {

    private Type[] data;
    private int first;
    private int last;
    private int length;

    private static final INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyDeque() {
        data = (Type[]) new Object[INITIAL_CAPACITY];
	// first = -1;
	first = INITIAL_CAPACITY / 2;
	last = first;
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity) {
	if (initialCapacity < 0) {
	    throw new IllegalArgumentException();
	}
	
	data = (Type[]) new Object[initialCapacity];
	// first = -1;
	first = initialCapacity / 2;
	last = first;
    }

    public String toString() {
	String result = "[";
	
	if (first == last) {
	    return result + "]";
	}
	
	else if (first < last) {
	    for (int index = first; index <= last; index++) {
		result += data[index] + ", ";
	    }
	}
	
	else {
	    for (int index = first; index < length; index++) {
		result += data[index] + ", ";
	    }
	    
	    for (int index = 0; index <= last; index++) {
		result += data[index] + ", ";
	    }
	}
	
	result = result.substring(0, result.length() - 2) + "]";
	return result;
    }

    public int size() {
	return length;
    }

    public void addFirst(Type head) {
	if (head == null) {
	    throw new NullPointerException();
	}
	
	/*
	if (first == -1) {
	    if (last == -1) {
		first = length / 2;
	    }
	
	    else {
		if (last - length < 0) {
		    first = length + (last - length)
		}
	    }
	}
	*/
	
	if (first == null) {
	    first += 1;
	}
	
	if (first == 0) {
	    if (last == length) {
		expand();
	    }
	    
	    first = length - 1;
	    data[first] = head;
	}
	
	else {
	    if (first - last == 1) {
		expand();
	    }
	    
	    first -= 1;
	    data[first] = head;
	}

	length++;
    }

    public void addLast(Type tail) {
	if (tail == null) {
	    throw new NullPointerException();
	}
	
	if (last == null) {
	    last -= 1;
	}
	
	if (last == length) {
	    if (first == 0) {
		expand();
		length += 1;
	    }
	    
	    else {
	    	last = 0;
	    }
	    
	    data[last] = tail;
	}

	else {
	    if (first - last == 1) {
		expand();
	    }
	    
	    last += 1;
	    data[last] = tail;
	}

	length++;
    }
    
    @SuppressWarnings("unchecked")
    private void expand() {
	Type[] previous = data;
	data = (Type[]) new Object[length * 2];
	length *= 2;

	if (first < last) {
	    for (int index = first; index <= back; index++) {
		data[index] = previous[index];
	    }
	}

	else if (last < first) {
	    for (int index = last; index >= 0; index--) {
		data[index] = previous[index];
	    }

	    for (int index = first; index < length; index++) {
		data[index] = previous[index];
	    }

	    first += size();
	}

	else {
	    throw new IllegalStateException();
	}
    }

    public static void main(String[] args) {
	MyDeque<Integer> a = new MyDeque<>();
	System.out.println(a);
	
	System.out.println();
	System.out.println("---------- addFirst ----------");
	
	for (int element = 0; element < 10; element++) {
	    data.addFirst(new Integer(element));
	    System.out.println(a);
	}
	
	System.out.println();
	System.out.println("---------- addLast ----------");
	
	for (int element = 10; element < 20; element++) {
	    data.addLast(new Integer(element));
	    System.out.println(a);
	}
	
	MyDeque<Integer> b = new MyDeque<>();
	
	System.out.println();
	System.out.println("---------- addFirst & addLast ----------");
	
	for (int element = 0; element < 10; element ++) {
	    if (element % 2 == 0) {
		data.addFirst(new Integer(element));
	    }
	
	    else {
		data.addLast(new Integer(element));
	    }
	    
	    System.out.println(data);
	}
    }
    
}
