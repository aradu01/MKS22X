public class MazeSolver {

    private Maze maze;
    private Frontier frontier;
    
    private boolean animations;
    private static int WAIT_TIME;

    public MazeSolver(String mazeText) {
	   maze = new Maze(mazeText);
    }
    
    public void movie(int time) {
        WAIT_TIME = time;
        animations = true;
    }

    private static void print(Object[] data) {
        String result = "";
        
        for (Object element: data) {
            result += element + " ";
        }
        
        System.out.println(result);
    }

    // Breath First Search Default.
    public boolean solve() {
	   return solve(0);
    }

    // 0: Breath First Search.
    // 1: Depth First Search.
    public boolean solve(int mode) {
        if (mode == 0) {
            frontier = new FrontierQueue();
            System.out.println(frontier);
        }

        else if (mode == 1) {
            frontier = new FrontierStack();
        }
        
        else if (mode == 2) {
            frontier = new FrontierPriorityQueue();
        }

        else {
            throw new IllegalArgumentException("Your mode should be either a 0 or a 1.");
        }

        Location place;
        Location[] neighbors;

        frontier.add(maze.getStart());
        // System.out.println(frontier);

        while (frontier.hasNext()) {
            place = frontier.next();
            neighbors = maze.getNeighbors(place);
            
            /* For Testing.
            System.out.println("Current:");
            System.out.println(place);
            System.out.println("Neighbors:");
            print(neighbors);
            System.out.println(frontier);
            */

            if (maze.get(place.xcor(), place.ycor()) == 'E') {
                /* For Testing.
                System.out.println(place.getLast());
                System.out.println(maze.get(place.getLast().xcor(), place.getLast().ycor()));
                */
                
                place = place.getLast();
                
                while (maze.get(place.xcor(), place.ycor()) != 'S') {
                    maze.set(place.xcor(), place.ycor(), '@');
                    place = place.getLast();
                }
                
                if (animations) {
                    System.out.println(maze.toString());
                }
                
                return true;
            }

            if (maze.get(place.xcor(), place.ycor()) == ' ') {
                maze.set(place.xcor(), place.ycor(), '.');
            }

            for (Location area: neighbors) {
                frontier.add(area);
            }
            
            if (animations) {
                System.out.println(maze.toString());
                
                try {
                    Thread.sleep(WAIT_TIME);
                }

                catch(InterruptedException e) {	}
            }
            
            // System.out.println(frontier);
        }

        return false;
    }

    public String toString() {
        return maze.toString();
    }

}