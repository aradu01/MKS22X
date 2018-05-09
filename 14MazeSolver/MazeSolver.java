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
	}
	    
	else if (mode == 1) {
	    frontier = new FrontierStack();
	}

	else {
	    throw new IllegalArgumentException("Your mode should be either a 0 or a 1.");
	}
	    
	Location place = maze.getStart();
	Location[] neighbors =  maze.getNeighbors(place);
	    
	for (Location place: neighbors) {
	    frontier.add(place);
	}
	    
	while (frontier.hasNext()) {
	    if (maze[place.xcor()][place.ycor()] == 'E') {
		return true;
	    }
	
	    else if (maze[place.xcor()][place.ycor()] == ' ') {
		maze[place.xcor()][place.ycor()] = '.';
	    }
		
	    place = frontier.next();
	    neighbors = maze.getNeighbors(place);
		
	    for (Location surroundings: neighbors) {
		frontier.add(surroundings);
	    }
	}
	    
	return false;
    }

    public String toString() {
	return maze.toString();
    }

}
