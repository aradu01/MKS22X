public class RunningMedian {
    
    private MyHeap<Double> maxHeap;
    private MyHeap<Double> minHeap;
    
    public RunningMedian() {
        maxHeap = new MyHeap<Double>(true);
        minHeap = new MyHeap<Double>(false);
    }

    public String toString() {
        String result = "Max Heap: ";

        result += maxHeap.toString() + "\n";
        result += "Min Heap: ";
        result += minHeap.toString();

        return result;
    }
    
    public void add(Double addition) {
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            maxHeap.add(addition);
        }

        else if (maxHeap.size() == 1 && minHeap.size() == 0) {
            if (addition < maxHeap.peek()) {
                minHeap.add(maxHeap.remove());
                
                maxHeap.add(addition);
            }
            
            else {
                minHeap.add(addition);
            }
        }
        
        else if (addition < minHeap.peek()) {
            maxHeap.add(addition);
        }
        
        else if (addition > maxHeap.peek()) {
            minHeap.add(addition);
        }

        /* Previous Attempt.
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(addition);
        }
        
        else {
            maxHeap.add(addition);
        }
        */

        /* Previous Attempt.
        while (maxHeap.size() - minHeap.size() > 1) {
            // System.out.println("HERE ADD.");

            minHeap.add(maxHeap.remove());
        }

        while (minHeap.size() - maxHeap.size() > 1) {
            // System.out.println("THERE ADD.");

            maxHeap.add(minHeap.remove());
        }
        */

        while (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(maxHeap.remove());
            }

            else {
                maxHeap.add(minHeap.remove());
            }
        }
    }
    
    public double getMedian() {
        if (maxHeap.size() == 0 && minHeap.size() == 0) {
            throw new IllegalStateException("You need to add values.");
        }
        
        else if (maxHeap.size() == 1 && minHeap.size() == 0) {
            return maxHeap.peek();
        }
        
        else if (minHeap.size() == 1 && maxHeap.size() == 0) {
            // System.out.println("HERE GETMEDIAN.");
            
            return minHeap.peek();
        }
        
        else {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2;
            }
            
            else if (maxHeap.size() > minHeap.size()) {
                // System.out.println("THERE GETMEDIAN.");
                
                return maxHeap.peek();
            }
            
            else {
                return minHeap.peek();
            }
        }
    }

    public int size() {
        return maxHeap.size() + minHeap.size();
    }
    
    /* Slower Version.
    private double[] data;
    private int size;
    
    private static final int CAPACITY = 10;
    
    public RunningMedian() {
        data = new double[CAPACITY];
    }
    
    public String toString() {
        String result = "";
        
        if (size == 0) {
            return "[]";
        }
        
        else {
            for (int index = 0; index < size; index++) {
                result += data[index] + ", ";
            }
            
            return "[" + result.substring(0, result.length() - 2) + "]";
        }
    }
    
    public void add(Double addition) {
        if (size == data.length) {
            extend();
        }
        
        data[size] = addition;
        size++;
    }
    
    private void extend() {
        double[] temporary = data;
        data = new double[temporary.length * 2];
        
        for (int index = 0; index < temporary.length; index++) {
            data[index] = temporary[index];
        }
    }
    
    public Double getMedian() {
        if (size % 2 == 0) {
            // int first = size / 2 - 1;
            // int second = size / 2;
            
            double first = quickselect(data, size / 2 - 1, 0, size - 1);
            double second = quickselect(data, size / 2, 0, size - 1);

            return (first + second) / 2;
        }
        
        else {
            // int middle = size / 2;

            double middle = quickselect(data, size / 2, 0, size - 1);
          	// System.out.println(size / 2);

            return middle;
        }
    }

    private static void swap(double[] data, int first, int second) {
        double storage;
        
        storage = data[first];
        data[first] = data[second];
        data[second] = storage;
    }
    
    private static double[] partition(double[] data, int start, int end) {        
        int result = (int) (Math.random() * (end - start)) + start;
        double partition = data[result];
        int low = start;
        int middle = start + 1;
        int high = end;

        double[] answer = new double[2];  
        swap(data, start, result);
        
        while (middle <= high) {  
            if (data[middle] < partition) {
                swap(data, low, middle);
                low++;
                middle++;
            }

            else if (data[middle] > partition) {
                swap(data, middle, high);
                high--;
            }

            else {
                middle++;
            }
        }
        
        answer[0] = low;
        answer[1] = high;
        return answer;
    }
    
    private static double quickselect(double[] data, int k, int start, int end) {
        if (k < 0 || k >= data.length) {
            throw new ArrayIndexOutOfBoundsException("Your index must be within the array.");
        }

        if (data.length == 0) {
           throw new IllegalStateException("Your array must contain elements.");
        }
        
        return helpSelect(data, k, start, end);
    }
    
    private static double helpSelect(double[] data, int k, int start, int end) {
        if (data.length == 1) {
           return data[0];
        }
        
        double[] current = partition(data, start, end);
        
        if (current[0] <= k && k <= current[1]) {
            return data[(int) current[0]];
        }
        
        else if (current[1] < k) {
            return helpSelect(data, k, (int) current[1] + 1, end);
        }

        else if (current[0] > k) {
            return helpSelect(data, k, start, (int) current[0] - 1);
        }

        else {
            return helpSelect(data, k, start, end);
        }
    }
    
    public int size() {
        return size;
    }
    */
    
    /* For Testing.
    public static void main(String[] args) {
        RunningMedian a = new RunningMedian();
        RunningMedian b = new RunningMedian();
      	RunningMedian c = new RunningMedian();
        
        System.out.println("----- add & size -----");
      
        for (double number = 0.0; number < 10.0; number++) {
            a.add(number);
        }
      
      	System.out.println(a);
        System.out.println("Size: " + a.size());
      	
        for (int time = 0; time < 100; time++) {
          	b.add((int) (Math.random() * 10000) / 100.0);
        }
              
      
      	System.out.println(b);
        System.out.println("Size: " + b.size());
      	
      	for (double num = 12345; num > 1; num /= 10) {
        	c.add(num);
        }
      	
      	System.out.println(c);
      	System.out.println("Size: " + c.size());
      
      	System.out.println();
      	System.out.println("----- getMedian -----");
      	
      	System.out.println(a);
      	System.out.println("Median: " + a.getMedian());
      	
      	System.out.println(b);
      	System.out.println("Median: " + b.getMedian());
      
      	System.out.println(c);
      	System.out.println("Median: " + c.getMedian());
    }
    */
    
}