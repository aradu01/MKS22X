public class MyDeque<Type> {

    private Type[] data;
    private int first;
    private int last;
    private int length;

    private static final INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyDeque() {
        data = (Type[]) new Object[INITIAL_CAPACITY];
	length = INITIAL_CAPACITY;
	first = length / 2;
	last = first;
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity) {
	data = (Type[]) new Object[initialCapacity];
	length = initialCapacity;
	first = length / 2;
	last = first;
    }

    public int size() {
	return length;
    }

    public void addFirst(Type head) {
	if (head == null) {
	    throw new NullPointerException();
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
	
	if (last == length) {
	    if (first == 0) {
		expand();
	    }

	    last += 1;
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
	MyDeque a = new MyDeque();

	System.out.println(a);
    }
    
}
