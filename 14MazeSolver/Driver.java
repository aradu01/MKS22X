public class Driver {

    public static void main(String[] args) {
        MazeSolver a = new MazeSolver("data1.dat");
        a.movie(100);
        a.setAStar(true);
        System.out.println(a.aStarStatus());
        System.out.println(a.aStarStatus());
        System.out.println(a.aStarStatus());
        System.out.println(a.aStarStatus());
        System.out.println(a.aStarStatus());
        System.out.println(a.solve(0));
        
        MazeSolver b = new MazeSolver("data2.dat");
        b.movie(100);
        b.setAStar(true);
        System.out.println(b.aStarStatus());
        System.out.println(b.aStarStatus());
        System.out.println(b.aStarStatus());
        System.out.println(b.aStarStatus());
        System.out.println(b.aStarStatus());
        System.out.println(b.solve(1));
        
        MazeSolver c = new MazeSolver("data3.dat");
        c.movie(100);
        c.setAStar(true);
        System.out.println(c.aStarStatus());
        System.out.println(c.aStarStatus());
        System.out.println(c.aStarStatus());
        System.out.println(c.aStarStatus());
        System.out.println(c.aStarStatus());
        System.out.println(c.solve(2));
        
        MazeSolver d = new MazeSolver("data4.dat");
        d.movie(100);
        d.setAStar(true);
        System.out.println(d.aStarStatus());
        System.out.println(d.aStarStatus());
        System.out.println(d.aStarStatus());
        System.out.println(d.aStarStatus());
        System.out.println(d.aStarStatus());
        System.out.println(d.solve(3));
    }
    
}