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

    private static int parent(int index) {
	   return (index - 1) / 2;
    }
    
    private static int firstChild(int index) {
	   return 2 * index + 1;
    }

    private static int secondChild(int index) {
	   return 2 * index + 2;
    }
    
    public static void heapify(int[] data) {
        swap(data, 0, findLargest(data));

	/*
    for (int index = 0; index < data.length; index++) {
        if ((index - 1) / 2 >= 0 && data[index] > data[(index - 1) / 2]) {
            // print(data);
            swap(data, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }
	*/

        for (int index = data.length - 1; index >= 0; index--) {
            if (parent(index) >= 0 && data[index] > data[parent(index)]) {
              swap(data, parent(index), index);
            }
        }
    }

    public static void heapsort(int[] data) {
        heapify(data);
	
        /* First Attempt.
        int border = data.length;
        int current;

        for (int index = 0; index < border; index++) {
            print(data);
            swap(data, index, data.length - 1);
            border--;

                current = index;

                while (firstChild(current) < border && data[current] < data[firstChild(current)] || 
                    secondChild(current) < border && data[current] < data[secondChild(current)]) {
                if (data[current] < data[firstChild(current)] && data[current] < data[secondChild(current)]) {
                        if (data[firstChild(current)] > data[secondChild(current)]) {
                            swap(data, current, firstChild(current));
                            current = firstChild(current);
                        }

                        else {
                            swap(data, current, secondChild(current));
                            current = secondChild(current);
                        }
                    }

                    else if (data[current] < data[firstChild(current)]) {
                        swap(data, current, firstChild(current));
                        current = firstChild(current);
                    }

                    else if (data[current] < data[secondChild(current)]) {
                        swap(data, current, secondChild(current));
                        current = secondChild(current);
                    }
                }
            }
        */

        /* Second Attempt.
        int border = data.length;
            int current;

            for (int index = 0; index < border; index++) {
                print(data);

                current = index;
                swap(data, current, border - 1);

                while (firstChild(current) < border || secondChild(current) < border) {
                    if (data[current] > data[firstChild(current)] && data[current] > data[secondChild(current)]) {
                        break;
                    }

                    else if (data[firstChild(current)] > data[secondChild(current)]) {
                        swap(data, current, firstChild(current));
                        current = firstChild(current);
                    }

                    else if (data[secondChild(current)] > data[firstChild(current)]) {
                        swap(data, current, secondChild(current));
                        current = secondChild(current);
                    }
                }

                border--;
            }
        */

        /* Third Attempt.
        int current;
            int border = data.length;

            for (int index = 0; index < data.length; index++) {
                current = index;
                swap(data, current, border - 1);

                while (firstChild(current) < border || secondChild(current) < border) {
                    if (data[current] < data[firstChild(current)] || data[current] < data[secondChild(current)]) {
                    if (data[firstChild(current)] > data[secondChild(current)]) {
                        swap(data, current, firstChild(current));
                        current = firstChild(current);
                    }

                    else {
                        swap(data, current, secondChild(current));
                        current = secondChild(current);
                    }
                }
                }

                border--;
            }
        */
	
        for (int border = data.length - 1; border > 0; border--) {
            swap(data, 0, border);
            sortHelper(data, 0, border - 1);
        }
    }
    
    private static void sortHelper(int[] data, int start, int end) {
        int largest = start;
        
        for (int index = start; index <= end; index++) {
            if (data[index] > data[largest]) {
                largest = index;
            }
        }
        
        for (int index = end; index >= start; index--) {
            if (parent(index) >= 0 && data[index] > data[parent(index)]) {
                swap(data, parent(index), index);
            }
        }
    }
    
    /* For Testing.
    public static void main(String[] args) {
        int[] a = new int[1000];
        
        for (int index = 0; index < a.length; index++) {
            a[index] = (int) (Math.random() * 10000);
        }
        
        print(a);
        heapsort(a);
        print(a);
    }
    */
	
}