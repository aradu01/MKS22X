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
    
    public static void heapsort(int[] data) {
        swap(data, 0, findLargest(data));
        
        for (int index = 0; index < data.length; index++) {
            if ((index - 1) / 2 >= 0 && data[index] > data[(index - 1) / 2]) {
                // print(data);
                swap(data, (index - 1) / 2, index);
                index = (index - 1) / 2;
            }
        }
    }
    
    public static void main(String[] args) {
        int[] a = new int[10];
        
        for (int index = 0; index < a.length; index++) {
            a[index] = (int) (Math.random() * 100);
        }
        
        print(a);
        heapsort(a);
        print(a);
    }
}