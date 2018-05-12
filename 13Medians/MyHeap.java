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
        if (size == 0) {
            throw new IllegalStateException();
        }
        
        else {
            Type deletion = data[0];
            int position = 0;
            
            int first = 2 * position + 1;
            int second = 2 * position + 2;
            
            while (first < size || second < size) {
                if (minORmax) {
                    if (data[first].compareTo(data[second]) > 0) {
                        swap(position, first);
                        position = first;
                    }
                    
                    else {
                        swap(position, second);
                        position = second;
                    }
                }
                
                else {
                    if (data[first].compareTo(data[second]) < 0) {
                        swap(position, first);
                        position = first;
                    }
                    
                    else {
                        swap(position, second);
                        position = second;
                    }
                }
                
                first = 2 * position + 1;
                second = 2 * position + 2;
            }
            
            data[position] = null;
            size--;
            return deletion;
        }
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
    
}
