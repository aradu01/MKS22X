import java.util.ArrayList;

public class Calculator {

    public static double eval(String expression) {
	ArrayList<String> items = new ArrayList<>();
	String number = "";
	int place = 0;

	for (int index = 0; index < expression.length(); index++) {
	    if (expression.charAt(index) == ' ') {
		items.add(number);
		number = " ";
	    }

	    else {		    
		number += expression.charAt(index);

		if (index == expression.length() - 1) {
		    items.add(number);
		}
	    }
	}

	for (int index = 0; index < items.size(); index++) {
	    if (items.get(index).equals("+") ||
		items.get(index).equals("-") ||
		items.get(index).equals("*") ||
		items.get(index).equals("/") ||
		items.get(index).equals("%")) {
		items.set(index - 1,
			  
	System.out.println(items);
	return 0.0;
    }

    private static double operator(String first, String operator, String second) {

    public static void main(String[] args) {
	String sentence = "8 2 + 99 9 - * 2 + 9 -";
	eval(sentence);
    }

}
