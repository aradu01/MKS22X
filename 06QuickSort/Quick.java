public class Quick {
    
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
    
    public static int partition(int[] data, int start, int end) {        
        int result = (int) (Math.random() * (end - start)) + start;
        int partition = data[result];
        
        int low = start;
	    int middle = start + 1;
        int high = end;
        
        swap(data, 0, result);

	    // print(data);
        
        while (middle <= high) {
            // System.out.println("--- " + low + " " + middle + " " + high);
	    
            if (data[middle] < partition) {
                // System.out.println("LOW");
                swap(data, low, middle);
                low++;
                middle++;
            }

            else if (data[middle] > partition) {
                swap(data, middle, high);
                // System.out.println("HIGH");
                high--;
            }

            else {  // if (data[middle] == partition)
                // System.out.println("MIDDLE");
                middle++;
            }

            // print(data);
        }

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
        
        /* My Working Version.
        data[result] = data[end];
        data[end] = partition;
            
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
        */
	
        /* For Testing.
        String answer = "";
        for (int num: data) {
            answer += num + " ";
        }
        System.out.println(answer);
        */

        return high;
    }

    public static int quickselect(int[] data, int k) {
        if (k < 0 || k >= data.length) {
            throw new ArrayIndexOutOfBoundsException("Your index must be within the array.");
        }
        
        return helpSelect(data, k, 0, data.length - 1);   
    }

    private static int helpSelect(int[] data, int k, int start, int end) {
        int current = partition(data, start, end);
        System.out.println("Start: " + start + "  End: " + end);
        System.out.println("Partition at " + current);
        
        print(data);

        if (current < k) {
            System.out.println("RIGHT");
            return helpSelect(data, k, current + 1, end);
        }

        else if (current > k) {
            System.out.println("LEFT");
            return helpSelect(data, k, start, current - 1);
        }

        else {  // if (current == k)
            System.out.println("ANSWER");
            return data[current];
        }
    }
    
    public static void quicksort(int[] array) {
        helpQuick(array, 0, array.length - 1);
    }
    
    private static void helpQuick(int[] array, int start, int end) {
        if (array.length >= 2 && start < end) {
            if (start >= 0 && end < array.length) {
                // System.out.println(start + " " + end);
                int current = partition(array, start, end);
                
                if (start < array.length - 1) {
                    helpQuick(array, current + 1, end);
                }
                
                if (end > 0) {
                    helpQuick(array, start, current - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] b = new int[] {17, 61, 93, 67, 47, 93, 4, 12, 20, 4, 12, 44, 68};
        
        System.out.println("\n" + "----- Swap -----" + "\n");
        print(b);
        swap(b, 1, 4);
        print(b);

        System.out.println("\n" + "----- Partition -----" + "\n");
        
	    for (int i = 1; i < 10; i++) {
            System.out.println(partition(b, 0, 12));
            
            print(b);
            
            System.out.println("---");
            
            b = new int[] {17, 61, 93, 67, 47, 93, 4, 12, 20, 4, 12, 44, 68};
        }
	    
        System.out.println("\n" + "----- Quick Select -----" + "\n");

        for (int counter = 0; counter < b.length; counter++) {
            System.out.println("---");
            
            print(b);
            
            System.out.println(counter);
            System.out.println(quickselect(b, counter));
            
            b = new int[] {17, 61, 93, 67, 47, 93, 4, 12, 20, 4, 12, 44, 68};
        }
        
        System.out.println("\n" + "----- Quick Sort -----" + "\n");
        
        print(b);
        
        quicksort(b);
        
        print(b);
    }
    
}
