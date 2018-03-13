public class Quick {
    
    public int partition(int[] data, int start, int end) {
        // Set local variables first.
        
        int result = (int) (Math.random() * (end - start)) + start;
        int partition = data[result];
        
        int low = start;
        int high = end;
        
        // Place the partition value first.
        
        data[result] = data[end];
        data[end] = partition;

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
        
        int storage;
        
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
        
        /* For Testing.
        String answer = "";
        for (int num: data) {
            answer += num + " ";
        }
        System.out.println(answer);
        */
        
        // Put partition value back in place.
        
        data[end] = data[low];
        data[low] = partition;
        
        return partition;
    }
    
    /* For Testing.
    public static void main(String[] args) {
        Quick a = new Quick();
        int[] b = new int[] {17, 61, 67, 47, 93, 12, 20, 4, 44, 68};
        
        for (int i = 1; i < 10; i++) {
            System.out.println(a.partition(b, 0, 9));
            String answer = "";
            
            for (int num: b) {
                answer += num + " ";
            }
            
            System.out.println(answer);
        }
    }
    */
    
}