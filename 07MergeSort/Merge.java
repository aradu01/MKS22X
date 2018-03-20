public class Merge {
    
    private static void divide(int[] data, int start, int end) {
        if (start < 0 || end >= data.length || start > end) {
            throw new IllegalStateException();
        }
        
        int division = (start + end) / 2;
        int[] storage = new int[data.length];
        
        for (int index = 0; index < data.length - 1; index += 2) {
            if (data[index] < data[index + 1]) {
                storage[index] = data[index];
                storage[index + 1] = data[index + 1];
            }
            
            else if (data[index] > data[index + 1]) {
                storage[index] = data[index + 1];
                storage[index + 1] = data[index];
            }
        }
    }
    
    public static void mergesort(int[] data) {
        if (data.length >= 2) {
            divide(data);
        }
    }
    
}