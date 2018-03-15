public class Quick {
    
    private static void swap(int[] data, int first, int second) {
        int storage;
        
        storage = data[first];
        data[first] = data[second];
        data[second] = storage;
    }
    
    public static int partition(int[] data, int start, int end) {
        // Modified from in-class lesson.
        
        int result = (int) (Math.random() * (end - start)) + start;
        int partition = data[result];
        
        int low = start + 1;
        int high = end;
        
        swap(data, 0, result);
        
        while (low <= high) {
            if (data[low] < partition) {
                // System.out.println("LOW");
                low++;
            }

            else if (data[low] > partition) {
                swap(data, low, high);
                // System.out.println(low + " " + high);
                high--;
            }
            
            /* For Testing.
            String answer = "";
            for (int num: data) {
                answer += num + " ";
            }
            System.out.println(answer);
            */
        }
        
        swap(data, 0, high);

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
            throw new ArrayIndexOutOfBoundsException();
        }
        
        return helpSelect(data, k, 0, data.length - 1);   
    }

    private static int helpSelect(int[] data, int k, int start, int end) {
        int current = partition(data, start, end);
        
        /* For Testing.
        String answer = "";
        for (int num: data) {
            answer += num + " ";
        }
        System.out.println(answer);
        */
        
        if (start == end) {
            return data[start];
        }
        
        if (current == k) {
            return data[current];
        }

        if (current < k) {
            return helpSelect(data, k, current + 1, end);
        }

        if (current > k) {
            return helpSelect(data, k, start, current - 1);
        }

        return -999;
    }
    
    public static void quicksort(int[] array) {
        helpQuick(array, 0, array.length - 1);
    }
    
    private static void helpQuick(int[] array, int start, int end) {
        if (array.length >= 2) {
            int current = partition(array, start, end);
        
            helpQuick(array, start, current - 1);
            helpQuick(array, current + 1, end);
        }
    }

    public static void main(String[] args) {
        int[] b = new int[] {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};

        System.out.println("\n" + "----- Partition -----" + "\n");
        
        for (int i = 1; i < 10; i++) {
            System.out.println(partition(b, 0, 9));
            
            String answer = "";
            for (int num: b) {
                answer += num + " ";
            }
            System.out.println(answer);
        }
        
        System.out.println("\n" + "----- Quick Select -----" + "\n");

        for (int counter = 0; counter < b.length; counter++) {
            System.out.println("---");
            
            String response = "";
            for (int num: b) {
                response += num + " ";
            }
            System.out.println(response);
            
            System.out.println(counter);
            System.out.println(quickselect(b, counter));
        }
        
        System.out.println("\n" + "----- Quick Sort -----" + "\n");
        
        String result = "";
        for (int num: b) {
            result += num + " ";
        }
        System.out.println(result);
        
        quicksort(b);
        
        String product = "";
        for (int num: b) {
            product += num + " ";
        }
        System.out.println(product);
    }
    
}