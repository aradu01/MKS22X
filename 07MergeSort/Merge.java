public class Merge {
    
    private static void print(int[] data) {
        String result = "";
        
        for (int num: data) {
            result += num + " ";
        }
        
        System.out.println(result);
    }
    
    private static void msort(int[] data, int[] temp, int start, int end) {
        int middle = (start + end) / 2;
	
	if (end > start) {
	    msort(temp, data, start, middle);
	    msort(temp, data, middle + 1, end);
	    
	    merge(data, temp, start, middle, middle + 1, end, start);
	}
		
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

    private static void merge(int[] data, int[] temp, int low, int middle, int quartile, int high, int counter) {
	if (low <= middle && quartile <= high) {
	    if (temp[low] < temp[quartile]) {
		data[counter] = temp[low];
		merge(data, temp, low + 1, middle, quartile, high, counter + 1);
	    }

	    else {  // if (temp[low] >= temp[quartile])
		data[counter] = temp[quartile];
		merge(data, temp, low, middle, quartile + 1, high, counter + 1);
	    }
	}

	else if (low <= middle) {
	    data[counter] = temp[low];
	    merge(data, temp, low + 1, middle, quartile, high, counter + 1);
	}

	else if (quartile <= high) {
	    data[counter] = temp[quartile];
	    merge(data, temp, low, middle, quartile + 1, high, counter + 1);
	}
	
	/* For Testing.
	print(data);
	print(temp);
	System.out.println("Low: " + low + " Middle: " + middle + " High: " + high);
	*/
  
	/* Turning into Selection Sort.
	   int lowest = 0;
	   int start = 0;

	   for (int element = 0; index < data.length; element++) {
	   for (int index = start; index < data.length; index++) {
	   if 
	*/
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

    /* For Testing.
    public static void main(String[] args) {
        int[] b = new int[] {17, 61, 93, 67, 47, 93, 4, 12, 20, 4, 12, 44, 68};
	int[] c = new int[] {8, 23, 7, 2, 568, 48, 2, 468, 347, 2, 37, 1};
	
        System.out.println("\n" + "----- Merge Sort -----" + "\n");

	print(b);
	mergesort(b);
	print(b);
	System.out.println("---");

	print(c);
	mergesort(c);
	print(c);

	int[] a = new int[1000];
	
	for (int i = 0; i < a.length; i++) {
	    a[i] = (int) (Math.random() * 1000000);
	}

	mergesort(a);

	for (int x = 0; x < a.length - 1; x++) {
	    if (a[x] > a[x + 1]) {
		System.out.println("FAILED");
	    }
	}

	print(a);
    }
    */
    
}
