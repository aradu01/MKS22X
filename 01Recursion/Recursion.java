public class Recursion {
    
    public int fact(int n) {
        return helpFact(n, 1);
    }
    
    public int helpFact(int num, int product) {
        if (num == 0) {
            return product;
        }
        
        return helpFact(num - 1, product * num);
    }
    
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        
        if (n == 1) {
            return 1;
        }
        
        return helpFib(0, 1, n - 1);
    }
    
    public int helpFib(int a, int b, int counter) {
        if (counter == 0) {
            return b;
        }
        
        return helpFib(b, a + b, counter - 1);
    }
    
    public double sqrt(double n) {
        if (n == 0) {
            return 0;
        }
        
        return helpSqrt(n, n);
    }
    
    public double helpSqrt(double guess, double num) {
        if (Math.abs(guess * guess - num) / num < 1e-9) {
            return guess;
        }
        
        return helpSqrt((num / guess + guess) / 2, num);
    }
    
}
