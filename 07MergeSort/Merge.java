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

	merge(data, temp, start, middle, high);
    }
	
	/*
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

    private static void merge(int[] data, int[] temp, int start, int middle, int high) {
	
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
    
}
