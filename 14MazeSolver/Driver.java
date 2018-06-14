public class Driver {
    
    private static final int TIME = 10;

    public static void main(String[] args) {
        MazeSolver a = new MazeSolver("data1.dat");
        a.movie(TIME);
        a.setAStar(true);
        System.out.println(a.aStarStatus());
        System.out.println(a.solve(0));
        
        MazeSolver b = new MazeSolver("data2.dat");
        b.movie(TIME);
        b.setAStar(true);
        System.out.println(b.aStarStatus());
        System.out.println(b.solve(1));
        
        MazeSolver c = new MazeSolver("data3.dat");
        c.movie(TIME);
        c.setAStar(true);
        System.out.println(c.aStarStatus());
        System.out.println(c.solve(2));
        
        MazeSolver d = new MazeSolver("data4.dat");
        d.movie(TIME);
        d.setAStar(true);
        System.out.println(d.aStarStatus());
        System.out.println(d.solve(3));
        
        MazeSolver e = new MazeSolver("data5.dat");
        e.movie(1);
        e.setAStar(true);
        System.out.println(e.aStarStatus());
        System.out.println(e.solve(0));
        
        MazeSolver f = new MazeSolver("data6.dat");
        f.movie(50);
        f.setAStar(true);
        System.out.println(f.aStarStatus());
        System.out.println(f.solve(1));
    }
    
}