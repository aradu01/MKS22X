public class MazeSolver {

    private Maze maze;
    private Frontier frontier;

    public MazeSolver(String mazeText) {
	maze = new Maze(mazeText);
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
	    
	Location place = maze.getStart();
	Location[] neighbors =  maze.getNeighbors(place);

	frontier.add(place);
	    
	while (frontier.hasNext()) {
	    for (Location area: neighbors) {
		frontier.add(area);
	    }
	    
	    if (maze.get(place.xcor(), place.ycor()) == 'E') {
		return true;
	    }
	
	    else if (maze.get(place.xcor(), place.ycor()) == ' ') {
		maze.set(place.xcor(), place.ycor(), '.');
	    }
		
	    place = frontier.next();
	    neighbors = maze.getNeighbors(place);
	}
	    
	return false;
    }

    public String toString() {
	return maze.toString();
    }

    public static void main(String[] args) {
	MazeSolver a = new MazeSolver("data1.dat");

	System.out.println(a.solve());
	System.out.println(a);
    }

}
