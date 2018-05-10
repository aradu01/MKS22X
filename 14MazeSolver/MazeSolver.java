public class MazeSolver {

    private Maze maze;
    private Frontier frontier;

    public MazeSolver(String mazeText) {
	maze = new Maze(mazeText);
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

	else {
	    throw new IllegalArgumentException("Your mode should be either a 0 or a 1.");
	}
	    
	Location place;
	Location[] neighbors;

	frontier.add(maze.getStart());
	System.out.println(frontier);
	    
	while (frontier.hasNext()) {
	    place = frontier.next();
	    neighbors = maze.getNeighbors(place);

	    System.out.println(place);
	    System.out.println("Neighbors:");
	    print(neighbors);
	    System.out.println(frontier);
	    
	    
	    if (maze.get(place.xcor(), place.ycor()) == 'E') {
		return true;
	    }
	
	    if (maze.get(place.xcor(), place.ycor()) == ' ') {
		maze.set(place.xcor(), place.ycor(), '.');
	    }

	    for (Location area: neighbors) {
		frontier.add(area);
	    }

	    System.out.println(maze.toStringColor(20));
	}
	    
	return false;
    }

    public String toString() {
	return maze.toString();
    }

    public static void main(String[] args) {
	MazeSolver a = new MazeSolver("data1.dat");
	System.out.println(a.solve(0));

	MazeSolver b = new MazeSolver("data2.dat");
	System.out.println(b.solve(0));
    }

}
