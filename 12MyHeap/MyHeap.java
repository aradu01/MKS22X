public class MyHeap<Type extends Comparable<Type>> {

    private Type[] data;
    private int size;
    private boolean minORmax;
    
    private static final int CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyHeap() {
        data = (Type[]) new Comparable[CAPACITY];
        minORmax = true;
    }
    
    @SuppressWarnings("unchecked")        // true entails a max heap.
    public MyHeap(boolean determinant) {  // false entails a min heap.
        minORmax = determinant;
        data = (Type[]) new Comparable[CAPACITY];
    }
    
    public String toString() {
        String result = "[";
        
        if (size == 0) {
            return "[]";
        }
        
        for (int index = 0; index < size; index++) {
            result += data[index] + ", ";
        }
        
        return result.substring(0, result.length() - 2) + "]";
    }

    public void add(Type addition) {
        int position = size;

        if (size == data.length) {
            expand();
        }
        
        data[size] = addition;
        size++;

        if (minORmax) {
            while ((position - 1) / 2 >= 0 && data[position].compareTo(data[(position - 1) / 2]) > 0) {
                swap((position - 1) / 2, position);
                position = (position - 1) / 2;
            }
        }
        
        else {
            while ((position - 1) / 2 >= 0 && data[position].compareTo(data[(position - 1) / 2]) < 0) {
                swap((position - 1) / 2, position);
                position = (position - 1) / 2;
            }
        }
    }

    public Type remove() {
        return null;
    }

    public Type peek() {
        return data[0];
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    private void expand() {
        Type[] temporary = data;

        data = (Type[]) new Comparable[data.length * 2];

        for (int index = 0; index < temporary.length; index++) {
            data[index] = temporary[index];
        }
    }
    
    private void swap(int first, int second) {
        Type storage = data[first];
        
        data[first] = data[second];
        data[second] = storage;
    }
    
    public static void main(String[] args) {
        System.out.println("----- toString -----");
        
        MyHeap<Integer> a = new MyHeap<>(true);
        System.out.println(a);
        
        System.out.println();
        System.out.println("----- add -----");
        
        for (int number = 0; number < 15; number++) {
            a.add(new Integer(number));
        }
        
        System.out.println(a);
    }
    
}