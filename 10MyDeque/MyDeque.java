import java.util.NoSuchElementException;

public class MyDeque<Type> {

    private Type[] data;
    private int first;
    private int last;
    private int length;

    private static final int INITIAL_CAPACITY = 10;

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

	else if (initialCapacity == 0) {
	    data = (Type[]) new Object[INITIAL_CAPACITY];
	    first = INITIAL_CAPACITY / 2;
	    last = first;
	}

	else {
	    data = (Type[]) new Object[initialCapacity];
	    // first = -1;
	    first = initialCapacity / 2;
	    last = first;
	}
    }

    public String toString() {
        String result = "[";

        if (length == 0) {
            return result + "]";
        }

        else if (first <= last) {
            for (int index = first; index <= last; index++) {
		result += data[index] + ", ";
            }
        }

        else {
            for (int index = first; index < data.length; index++) {
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
        
        if (data[first] == null) {
            first++;
	    // System.out.println(first);
        }

        if (first == 0) {
            if (last == data.length - 1) {
                // System.out.println("HERE");
                expand();
            }

            first = data.length - 1;
            data[first] = head;
	    // System.out.println(first + " " + data[first]);
        }

        else {
            if (first - last == 1) {
                expand();
            }

            first--;
            data[first] = head;
        }

        length++;
    }

    public void addLast(Type tail) {
        if (tail == null) {
            throw new NullPointerException();
        }

        if (data[last] == null) {
            last--;
        }

        if (last == data.length - 1) {
            if (first == 0) {
                expand();
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

            last++;
            data[last] = tail;
        }

        length++;
    }
	
    public Type removeFirst() {
        if (length == 0) {
            throw new NoSuchElementException();
        }

        /*
        data[index] = null;

        if (index == first) {
            if (first == length - 1) {
                first = 0;
            }

            else {
                first++;
            }
        */

        Type deletion = data[first];
        data[first] = null;

        if (first == data.length - 1) {
            first = 0;
        }

        else {
            first++;
        }

        length--;
        return deletion;
    }
    
    public Type removeLast() {
        if (length == 0) {
            throw new NoSuchElementException();
        }

        Type deletion = data[last];
        data[last] = null;

        if (last == 0) {
            last = data.length - 1;
        }

        else {
            last--;
        }

        length--;
        return deletion;
    }
    
    public Type getFirst() {
        if (length == 0) {
            throw new NoSuchElementException();
        }

        return data[first];
    }
    
    public Type getLast() {
        if (length == 0) {
            throw new NoSuchElementException();
        }

        return data[last];
    }
    
    @SuppressWarnings("unchecked")
    private void expand() {
        Type[] previous = data;
	// System.out.println(data.length);
	
        data = (Type[]) new Object[data.length * 2];
	// System.out.println(length);
	// System.out.println(data.length);

        if (first < last) {
            for (int index = first; index <= last; index++) {
                data[index] = previous[index];
            }
        }

        else if (last < first) {
            for (int index = 0; index <= last; index++) {
                data[index] = previous[index];
            }

            for (int index = first; index < previous.length; index++) {
                data[index + length] = previous[index];
            }

            first += length;
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

        for (int element = 0; element < 15; element++) {
            a.addFirst(new Integer(element));
            System.out.println(a);
        }

        System.out.println();
        System.out.println("---------- addLast ----------");

        for (int element = 15; element < 30; element++) {
            a.addLast(new Integer(element));
            System.out.println(a);
        }

        MyDeque<Integer> b = new MyDeque<>();

        System.out.println();
        System.out.println("---------- addFirst & addLast ----------");

        for (int element = 0; element < 15; element++) {
            if (element % 2 == 0) {
                b.addFirst(new Integer(element));
            }

            else {
                b.addLast(new Integer(element));
            }

            System.out.println(b);
        }

        System.out.println();
        System.out.println("---------- removeFirst ----------");

	System.out.println(a);
        System.out.println(a.removeFirst());
        System.out.println(a);

        System.out.println();
        System.out.println("---------- removeLast ----------");

	System.out.println(b);
        System.out.println(b.removeLast());
        System.out.println(b);

        System.out.println();
        System.out.println("---------- getFirst ----------");

        System.out.println(a);
        System.out.println(a.getFirst());

        System.out.println(b);
        System.out.println(b.getFirst());

        System.out.println();
        System.out.println("---------- getLast ----------");

        System.out.println(a);
        System.out.println(a.getLast());

        System.out.println(b);
        System.out.println(b.getLast());
    }
    
}
