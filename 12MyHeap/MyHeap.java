public class MyHeap<Type extends Comparable<Type>> {

    private Type[] data;
    private int size;
    private boolean minORmax;

    @SuppressWarnings("unchecked")
    public MyHeap() {
	data = (Type[]) new Comparable[10];
    }
    
    @SuppressWarnings("unchecked")        // true entails a max heap.
    public MyHeap(boolean determinant) {  // false entails a min heap.
	minORmax = determinant;
	data = (Type[]) new Comparable[10];
    }

    public void add(Type addition) {
	int position;

	if (size == data.length) {
	    expand();
	}
	
	if (minORmax) {
	    
	    while (
	}
    }

    public Type remove() {
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
    
    public static void main(String[] args) {
	
    }
    
}
