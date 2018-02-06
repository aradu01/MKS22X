public class Recursion {
    
    public int fact(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        return helpFact(n, 1);
    }
    
    public int helpFact(int num, int product) {
        if (num == 0) {
            return product;
        }
        
        return helpFact(num - 1, product * num);
    }
    
    public int fib(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
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
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        
        if (n == 0) {
            return 0;
        }
        
        return helpSqrt(n, n);
    }
    
    public double helpSqrt(double guess, double num) {
        if (Math.abs(guess * guess - num) / num < 1e-6) {
            return guess;
        }
        
        return helpSqrt((num / guess + guess) / 2, num);
    }
    
    public static void main(String[] args) {
        Recursion a = new Recursion();
        
        System.out.println("Factorial Tests:");
        System.out.println(a.fact(0));
        System.out.println(a.fact(1));
        System.out.println(a.fact(2));
        System.out.println(a.fact(3));
        System.out.println(a.fact(10));
        
        System.out.println("Fibonacci Tests:");
        System.out.println(a.fib(0));
        System.out.println(a.fib(1));
        System.out.println(a.fib(2));
        System.out.println(a.fib(3));
        System.out.println(a.fib(10));
        
        System.out.println("Square Root Tests:");
        System.out.println(a.sqrt(0));
        System.out.println(a.sqrt(1));
        System.out.println(a.sqrt(2.5));
        System.out.println(a.sqrt(5e-12));
        System.out.println(a.sqrt(10));
    }
    
}
