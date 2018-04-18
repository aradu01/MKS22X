import java.util.ArrayList;

public class Calculator {

    public static double eval(String expression) {
	ArrayList<String> items = new ArrayList<>();
	String number = "";
	int place = 0;

	for (int index = 0; index < expression.length(); index++) {
	    if (expression.charAt(index) == ' ') {
		items.add(number);
		number = "";
	    }

	    else {		    
		number += expression.charAt(index);

		if (index == expression.length() - 1) {
		    items.add(number);
		}
	    }
	}

	// System.out.println(items);

	for (int index = 0; index < items.size(); index++) {
	    // System.out.println("HERE");
	    
	    if (items.get(index).equals("+") ||
		items.get(index).equals("-") ||
		items.get(index).equals("*") ||
		items.get(index).equals("/") ||
		items.get(index).equals("%")) {

		// System.out.println("THERE");
		
		items.set(index, calculate(items.get(index - 2), items.get(index).charAt(0), items.get(index - 1)));
		items.remove(index - 1);
		items.remove(index - 2);

		index -= 2;
	    }
	}
	
	// System.out.println(items);
	return Double.parseDouble(items.get(0));
    }

    private static String calculate(String first, char operator, String second) {
	double result;
	
	// System.out.println(first + " " + operator + " " + second);
	
	if (operator == '+') {
	    result = Double.parseDouble(first) + Double.parseDouble(second);
	}

	else if (operator == '-') {
	    result = Double.parseDouble(first) - Double.parseDouble(second);
	}

	else if (operator == '*') {
	    result = Double.parseDouble(first) * Double.parseDouble(second);
	}

	else if (operator == '/') {
	    result = Double.parseDouble(first) / Double.parseDouble(second);
	}

	else {
	    result = Double.parseDouble(first) % Double.parseDouble(second);
	}

	return String.valueOf(result); 
    }
	
    public static void main(String[] args) {
	System.out.println(eval("10 2.0 +")); // Is 12.0
	System.out.println(eval("11 3 - 4 + 2.5 *")); // Is 30.0
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -")); // Is 893.0
    }

}
