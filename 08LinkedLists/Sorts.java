public class Sorts {
    
    public static void radixsort(MyLinkedListImproved<Integer> data) {
        // First, find the largest magnitude.
        int magnitude = (int) Math.log10(data.get(data.max())) + 1;
        
        // System.out.println(data.get(data.max()));
        
        /*
        int magnitude = 0;

        for (Integer element: data) {
            if (element > 0) {
                double power = Math.log10(element) + 1;

                if (power > magnitude) {
                    magnitude = (int) power;
                }
            }
        }
        */
        
        // System.out.println(magnitude);

        // Next, set up the digits Linked List.
        @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] digits = new MyLinkedListImproved[10];
        
        for (int num = 0; num < 10; num++) {
            digits[num] = new MyLinkedListImproved<Integer>();
        }
        
        // Then, sort the data.        
        for (int place = 1; place <= magnitude; place++) {
            for (Integer element: data) {
                // System.out.println(element);
                
                // int value = (element / (int) Math.pow(10, place - 1)) % (int) Math.pow(10, place);
                int value = (element / (int) Math.pow(10, place - 1)) % 10;
                
                // System.out.println(value);
                
                /* For Testing.
                if (value > 9) {
                    System.out.println(place);
                    System.out.println(element);
                }
                */
                
                // System.out.println(digits[value]);
                digits[value].add(element);
            }
        
            data.clear();
            
            for (MyLinkedListImproved<Integer> number: digits) {
                data.extend(number);
            }
        }        
    }
    
    public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data) {
        // First, I split up the data.
        MyLinkedListImproved<Integer> positive = new MyLinkedListImproved<>();
        MyLinkedListImproved<Integer> negative = new MyLinkedListImproved<>();
        
        for (Integer element: data) {
            if (element < 0) {
                negative.add(element);
            }
            
            else {
                positive.add(element);
            }
        }
        
        // Next, I set up the Linked List of digits.
        @SuppressWarnings("unchecked") MyLinkedListImproved<Integer>[] digits = new MyLinkedListImproved[10];
        
        for (int num = 0; num < 10; num++) {
            digits[num] = new MyLinkedListImproved<Integer>();
        }
        
        // Then, I sort the positives.
        if (positive.size() > 0) {
            int magnitude = (int) Math.log10(data.get(data.max())) + 1;
            
            for (int place = 1; place <= magnitude; place++) {
                for (Integer element: positive) {
                    // System.out.println(element);

                    // int value = (element / (int) Math.pow(10, place - 1)) % (int) Math.pow(10, place);
                    int value = (element / (int) Math.pow(10, place - 1)) % 10;

                    // System.out.println(value);

                    /* For Testing.
                    if (value > 9) {
                        System.out.println(place);
                        System.out.println(element);
                    }
                    */

                    // System.out.println(digits[value]);
                    digits[value].add(element);
                }

                positive.clear();

                for (MyLinkedListImproved<Integer> number: digits) {
                    positive.extend(number);
                }
            }
        }
        
        // Finally, I sorted the negative numbers.
        if (negative.size() > 0) {
            int magnitude = (int) Math.log10(-1 * data.get(data.min())) + 1;
            
            for (int place = 1; place <= magnitude; place++) {
                for (Integer element: negative) {
                    // System.out.println(element);

                    // int value = (element / (int) Math.pow(10, place - 1)) % (int) Math.pow(10, place);
                    int value = (element / (int) Math.pow(10, place - 1)) % 10 * -1;

                    // System.out.println(value);

                    /* For Testing.
                    if (value > 9) {
                        System.out.println(place);
                        System.out.println(element);
                    }
                    */

                    // System.out.println(digits[value]);
                    digits[value].add(element);
                }

                negative.clear();

                for (int number = 9; number > -1; number--) {
                    negative.extend(digits[number]);
                }
            }
        }
        
        // Combine negative and positive into data.
        data.clear();
        data.extend(negative);
        data.extend(positive);
    }
        
    /* For Testing.
    public static void main(String[] args) {
        System.out.println("---------- Positives Only ----------");
        MyLinkedListImproved<Integer> a = new MyLinkedListImproved<>();
        
        for (int n = 0; n < 100; n++) {
            a.add(new Integer((int) (Math.random() * 1000)));
        }
        
        System.out.println(a);
        radixsort(a);
        System.out.println(a);
        
        System.out.println();
        System.out.println("---------- Positives and Negatives ----------");
        
        MyLinkedListImproved<Integer> b = new MyLinkedListImproved<>();
        
        for (int n = 0; n < 100; n++) {
            b.add(new Integer((int) (Math.random() * 1000) * (int) Math.pow(-1, (int) (Math.random() * 2) + 1)));
        }
        
        System.out.println(b);
        radixsortIncludingNegatives(b);
        System.out.println(b);
    }
    */

}