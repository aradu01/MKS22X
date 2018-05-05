public class RunningMedian {
    
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
            for (double element: data) {
                result += element + ", ";
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
            int first = size / 2;
            int second = size / 2 + 1;
        }
        
        else {
            int middle = size / 2 + 1;
        }
    }
    
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        RunningMedian a = new RunningMedian();
        
        System.out.println("----- add -----");
        for (double number = 0.0; number < 10.0; number++) {
            a.add(number);
        }
        
        System.out.println(a);
        System.out.println(a.size());
    }
    
}
