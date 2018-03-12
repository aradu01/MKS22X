public class Quick {

    public int partition(int[] array, int start, int end) {
	int result = (int) (Math.random() * array.length);

	int partition = array[result];
	array[result] = array[start];
	array[start] = partition;

	for (int a = 1; a < end; a++) {
	    
