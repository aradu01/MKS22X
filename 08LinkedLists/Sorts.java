public class Sorts {

    public static void radixsort(MyLinkedListImproved<Integer> data) {
	// First, find the largest magnitude.
	int magnitude = 0;

	for (element: data) {
	    if (element > 0) {
		double power = Math.log10(element);
	    
		if (power < magnitude) {
		    magnitude = (int) power;
		}
	    }
	}

	// Next, sort starting from lowest place value.
        @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] digits = new MyLinkedListImproved[10];

	for (int place = 1; place <= magnitude; place++) {
	}
    }

}
