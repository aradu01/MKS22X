public class Driver {

    public static void main(String[] args) {
        MazeSolver a = new MazeSolver("data1.dat");
        a.movie(100);
        System.out.println(a.solve(2));
        
        MazeSolver b = new MazeSolver("data2.dat");
        b.movie(100);
        System.out.println(b.solve(2));
        
        MazeSolver c = new MazeSolver("data3.dat");
        c.movie(100);
        System.out.println(c.solve(2));
    }
    
}