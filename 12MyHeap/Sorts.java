public class Sorts {
    
    private static void swap(int[] data, int first, int second) {
        int storage;
        
        storage = data[first];
        data[first] = data[second];
        data[second] = storage;
    }
    
    private static void print(int[] data) {
        String result = "";
        
        for (int num: data) {
            result += num + ", ";
        }
        
        System.out.println(result);
    }
    
    private static int findLargest(int[] data) {
        int champion = 0;
        
        for (int index = 0; index < data.length; index++) {
            if (data[index] > data[champion]) {
                champion = index;
            }
        }
        
        return champion;
    }

    private static int parent(int index) {
	return (index - 1) / 2;
    }
    
    private static int firstChild(int index) {
	return 2 * index + 1;
    }

    private static int secondChild(int index) {
	return 2 * index + 2;
    }
    
    public static void heapify(int[] data) {
        swap(data, 0, findLargest(data));
	border--;
	int current;

	/*
        for (int index = 0; index < data.length; index++) {
            if ((index - 1) / 2 >= 0 && data[index] > data[(index - 1) / 2]) {
                // print(data);
                swap(data, (index - 1) / 2, index);
                index = (index - 1) / 2;
            }
        }
	*/

	for (int index = data.length - 1; index >= 0; index--) {
	    if (parent(index) >= 0 && data[index] > data[parent(index)]) {
		swap(data, parent(index), index);
	    }
		
	    current = index;
	    while (firstChild(current) < border && data[current] < data[firstChild(current)] || 
		    secondChild(current) < border && data[current] < data[secondChild(current)]) {
	        if (data[current] < firstChild(current) && data[current] < secondChild(current)) {
	    	    if (data[firstChild(current)] > data[secondChild(current)]) {
		        swap(data, current, firstChild(current));
			current = firstChild(current);
		    }

		    else {
			swap(data, current, secondChild(current));
			current = secondChild(current);
		    }
		}

		else if (data[current] < data[firstChild(current)]) {
		    swap(data, current, firstChild(current));
		    current = firstChild(current);
		}

		else if (data[current] < data[secondChild(current)]) {
		    swap(data, current, secondChild(current));
		    current = secondChild(current);
		}
	    }
	}
    }

    public static void heapsort(int[] data) {
	heapify(data);
	int border = data.length;
	
	for (int index = 0; index < border; index++) {
	    swap(data, index, data.length - 1);
	    border--;

	}
    }
    
    public static void main(String[] args) {
        int[] a = new int[10];
        
        for (int index = 0; index < a.length; index++) {
            a[index] = (int) (Math.random() * 100);
        }
        
        print(a);
        heapify(a);
        print(a);
    }
}
