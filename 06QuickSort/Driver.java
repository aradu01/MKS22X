import java.util.Arrays;

public class Driver {

    private static void print(int[] data) {
        String result = "";
        
        for (int num: data) {
            result += num + " ";
        }
        
        System.out.println(result);
    }

    //Sort testing code
    private static final int INCREASE = 0;
    private static final int DECREASE = 1;
    private static final int STANDARD = 2;
    private static final int SMALL_RANGE = 3;
    private static final int EMPTY = 4;

    private static String name(int i) {
	if (i == 0) return "Increassing";
	if (i == 1) return "Decreassing";
	if (i == 2) return "Normal Random";
	if (i == 3) return "Random with Few Values";
	if (i == 4) return "size 0 array";
	return "Error stat array";

    }

    private static int create(int min, int max) {
	return min + (int) (Math.random() * (max-min));
    }

    private static int[] makeArray(int size, int type) {
	int[] ans = new int[size];

	if (type == STANDARD) {
	    for (int i = 0; i < size; i++) {
		ans[i] = create(-1000000, 1000000);
	    }
	}

	if (type == INCREASE) {
	    int current = -5 * size;
	    
	    for (int i = 0; i < size; i++) {
		ans[i] = create(current, current + 10);
		current += 10;
	    }
	}
	
	if (type == DECREASE) {
	    int current = 5 * size;
	    
	    for (int i = 0; i < size; i++) {
		ans[i] = create(current, current + 10);
		current -= 10;
	    }
	}
	
	if (type == SMALL_RANGE) {
	    for (int i = 0; i < size; i++) {
		ans[i] = create(-5, 5);
	    }
	}
	
	if (type == EMPTY) {
	    ans = new int[0];
	}
	
	return ans;
    }

    public static void main(String[]args){    
	int size = Integer.parseInt(args[0]);
	int type = Integer.parseInt(args[1]);

	int [] start = makeArray(size, type);
	int [] result = Arrays.copyOf(start, start.length);
	Arrays.sort(result);
    
	long startTime = System.currentTimeMillis();

	Quick.quicksort(start);
	
	long elapsedTime = System.currentTimeMillis() - startTime;
	if (Arrays.equals(start, result)) {
	    System.out.println("PASS Case " + name(type) + " array, size:" + size + " " + elapsedTime/1000.0 + "sec ");
	}

	else {
	    System.out.println("FAIL ! ERROR ! " + name(type) + " array, size:" + size + "  ERROR!");
	}
    }
    
}
