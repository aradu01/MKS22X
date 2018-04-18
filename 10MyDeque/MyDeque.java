public class MyDeque<Type> {

    private Type[] data;
    private int start;
    private int last;

    private static final INITIAL_CAPACITY = 10;

    @SuppressWarnings("unchecked")
    public MyDeque() {
        data = (Type[]) new Object[INITIAL_CAPACITY];
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity) {
	data = (Type[]) new Object[initialCapacity];
    }

    public int size() {
	return ;
    }

    public void addFirst(Type head) {
	if (start == 0) {
	    if (last = 
