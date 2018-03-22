public class Merge {

    private static void swap(int[] data, int first, int second) {
        int storage;
        
        storage = data[first];
        data[first] = data[second];
        data[second] = storage;
    }
    
    private static void print(int[] data) {
        String result = "";
        
        for (int num: data) {
            result += num + " ";
        }
        
        System.out.println(result);
    }
    
    private static void msort(int[] data, int[] temp, int start, int end) {
        if (start < 0 || end >= data.length || start > end) {
            throw new IllegalStateException();
        }
        
        int middle = (start + end) / 2;
	
	while (end - start > 1) {
	    msort(temp, data, start, middle);
	    msort(temp, data, middle + 1, end);
	}

	merge(data, temp, start, middle, end);
	
	/* Previous Code.
        for (int index = 0; index < data.length - 1; index += 2) {
            if (data[index] < data[index + 1]) {
                temp[index] = data[index];
                temp[index + 1] = data[index + 1];
            }
            
            else if (data[index] > data[index + 1]) {
                temp[index] = data[index + 1];
                temp[index + 1] = data[index];
            }
        }
	*/
    }

    private static void merge(int[] data, int[] temp, int low, int middle, int high) {
        if (low != high) {
	    print(data);
	    print(temp);
	    System.out.println("Low: " + low + " Middle: " + middle + " High: " + high);
	    
	    /* Turning into Selection Sort.
	    int lowest = 0;
	    int start = 0;

	    for (int element = 0; index < data.length; element++) {
		for (int index = start; index < data.length; index++) {
		    if 
	    */
	}
    }
    
    
    public static void mergesort(int[] data) {
        if (data.length >= 2) {
	    int[] temp = new int[data.length];

	    for (int element = 0; element < data.length; element++) {
		temp[element] = data[element];
	    }
	    
            msort(data, temp, 0, data.length - 1);
        }
    }

    public static void main(String[] args) {
        int[] b = new int[] {17, 61, 93, 67, 47, 93, 4, 12, 20, 4, 12, 44, 68};

	System.out.println("\n" + "----- Swap -----" + "\n");
        print(b);
        swap(b, 1, 4);
        print(b);
        System.out.println("\n" + "----- Merge Sort -----" + "\n");
        
	for (int i = 1; i < 10; i++) {            
            print(b);
            
            System.out.println("---");

	    mergesort(b);
            
            // b = new int[] {5, 5, 8, 5, 5, 6, 6, 8, 6, 5, 6, 6, 6, 6,5, 6, 8, 5, 8, 8, 5};
        }
    }	
    
}
