public class Quick {
    
    public static int partition(int[] data, int start, int end) {
        // Set local variables first.
        
        int result = (int) (Math.random() * (end - start)) + start;
        int partition = data[result];
        
        int low = start;
        int high = end;
	int storage;
                
        data[result] = data[end];
        data[end] = partition;

	/* Slower Code.
	for (int index = start + 1; index <= end / 2; index++) {
	    if (data[index] < partition) {
		storage = data[low];
		data[low] = data[index];
		data[index] = storage;
		low++;
	    }

	    if (data[index] > partition) {
		storage = data[high];
		data[high] = data[index];
		data[index] = storage;
		high--;
	    }
	}

	data[start] = data[high];
	data[high] = partition;
	*/	

        /* Previous Attempt.
        int element = data[start];
        int storage = 0;

    	while (low <= high) {
            String response = "";
            for (int num: data) {
                response += num + " ";
            }
            System.out.println(response);
            
            if (element < partition) {
                storage = data[low];
                data[low] = element;
                low++;
            }
            
            else if (element > partition) {
                storage = data[high];
                data[high] = element;
                high--;
            }
            
            else {
                storage = data[middle];
                data[middle] = element;
                middle++;
            }
            
            element = storage;
        }
        */
        
        /* Second Attempt.
        for (int index = start + 1; index <= end; index++) {
            if (data[index] < partition) {
                storage = data[low];
                data[low] = data[index];
                data[index] = storage;
                low++;
            }
            
            if (data[index] > partition) {
                storage = data[high];
                data[index] = data[index];
                data[index] = storage;
                high--;
            }
        }
                
        if (data[low] < partition) {
            data[start] = data[low];
            data[low] = partition;
        }
        
        else if (data[high] > partition) {
            data[end] = data[high];
            data[high] = partition;
        }
        */
	
        for (int index = start; index < end; index++) {
            if (data[index] < partition) {
                storage = data[index];
                data[index] = data[low];
                data[low] = storage;
                low++;
            }
        }

	data[end] = data[low];
        data[low] = partition;
	
        /* For Testing.
        String answer = "";
        for (int num: data) {
            answer += num + " ";
        }
        System.out.println(answer);
        */
	
        return low;
    }

    public static int quickselect(int[] data, int k) {
	return help(data, k, 0, data.length - 1);   
    }

    private static int help(int[] data, int k, int start, int end) {
	int current = partition(data, start, end);

	String answer = "";
        for (int num: data) {
            answer += num + " ";
        }
	
        System.out.println(answer);
	
	if (current == k) {
	    return current;
	}

	if (current < k) {
	    return help(data, k, k + 1, end);
	}

	if (current > k) {
	    return help(data, k, start, k - 1);
	}
	
	return -999;
    }

    public static void main(String[] args) {
        int[] b = new int[] {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};

	/*
	System.out.println("\n" + "----- Partition -----" + "\n");
        
        for (int i = 1; i < 10; i++) {
            System.out.println(partition(b, 0, 9));
            String answer = "";
            
            for (int num: b) {
                answer += num + " ";
            }
            
            System.out.println(answer);
        }
	*/

	System.out.println("\n" + "----- Quick Select -----" + "\n");

	for (int counter = 0; counter < b.length; counter++) {
	    quickselect(b, counter);
	    System.out.println(b);
	}
    }
    
}
