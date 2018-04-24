public class ExpressionTree{
  
    // Infix notation with parentheses.
    public String toString() {
	if (isValue()) {
	    return getValue() + "";
	}

	else {
	    String left = getLeft().toString();
	    String right = getRight().toString();

	    return "(" + left + " " + getOp() + " " + right + ")";
	}
    }
    
    // Postfix notation.
    public String toStringPostfix(){
	if (isValue()) {
	    return getValue() + "";
	}

	else {
	    String left = getLeft().toStringPostfix();
	    String right = getRight().toStringPostfix();

	    return left + " " + right + " " + getOp();
	}
    }
  
    // Prefix notation.
    public String toStringPrefix(){
	if (isValue()) {
	    return getValue() + "";
	}

	else {
	    String left = getLeft().toStringPrefix();
	    String right = getRight().toStringPrefix();

	    return getOp() + " " + left + " " + right;
	}
    }

    // Solves an expression tree.
    public double evaluate(){
	if (isValue()) {
	    return getValue();
	}

	else {
	    double left = getLeft().evaluate();
	    double right = getRight().evaluate();

	    return apply(getOp(), left, right);
	}
    }

    // Deciphers the operator.
    private double apply(char operator, double first, double second){
	double result;
        
        // System.out.println(first + " " + operator + " " + second);
        
        if (operator == '+') {
            result = first + second;
        }

        else if (operator == '-') {
            result = first - second;
        }

        else if (operator == '*') {
            result = first * second;
        }

        else if (operator == '/') {
            result = first / second;
        }

        else {
            result = first % second;
        }

        return result; 
    }
  
    private char op;
    private double value;
    private ExpressionTree left,right;
  
    /*TreeNodes are immutable, so no issues with linking them across multiple
     *  expressions. The can be constructed with a value, or operator and 2
     * sub-ExpressionTrees*/
    public ExpressionTree(double value){
	this.value = value;
	op = '~';
    }
    public ExpressionTree(char op,ExpressionTree l, ExpressionTree r){
	this.op = op;
	left = l;
	right = r;
    }
  
    public char getOp(){
	return op;
    }
  
    /* accessor method for Value, precondition is that isValue() is true.*/
    private double getValue(){
	return value;
    }
    /* accessor method for left, precondition is that isOp() is true.*/
    private ExpressionTree getLeft(){
	return left;
    }
    /* accessor method for right, precondition is that isOp() is true.*/
    private ExpressionTree getRight(){
	return right;
    }
  
    private boolean isOp(){
	return hasChildren();
    }
    private boolean isValue(){
	return !hasChildren();
    }
  
    private boolean hasChildren(){
	return left != null && right != null;
    }
  
    public static void main(String[] args){
	ExpressionTree a = new ExpressionTree(4.0);
	ExpressionTree b = new ExpressionTree(2.0);

	ExpressionTree c = new ExpressionTree('+', a, b);
	System.out.println(c);
	System.out.println(c.toStringPostfix());
	System.out.println(c.toStringPrefix());
	System.out.println(c.evaluate()); // 6.0


	ExpressionTree d = new ExpressionTree('*', c, new ExpressionTree(3.5));
	System.out.println(d);
	System.out.println(d.toStringPostfix());
	System.out.println(d.toStringPrefix());
	System.out.println(d.evaluate()); // 21.0

	ExpressionTree ex = new ExpressionTree('-', d, new ExpressionTree(1.0));
	System.out.println(ex);
	System.out.println(ex.toStringPostfix());
	System.out.println(ex.toStringPrefix());
	System.out.println(ex.evaluate()); // 20.0

	ex = new ExpressionTree('+', new ExpressionTree(1.0), ex);
	System.out.println(ex);
	System.out.println(ex.toStringPostfix());
	System.out.println(ex.toStringPrefix());
	System.out.println(ex.evaluate()); // 21.0

	ex = new ExpressionTree('/', ex, new ExpressionTree(2.0));
	System.out.println(ex);
	System.out.println(ex.toStringPostfix());
	System.out.println(ex.toStringPrefix());
	System.out.println(ex.evaluate()); // 10.5   
    }
    
}
