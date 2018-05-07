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

	    while (frontier.hasNext()) {
		
	}

	else if (mode == 1) {
	    frontier = new FrontierStack();
	}

	else {
	    throw new IllegalArgumentException("Your mode should be either a 0 or a 1.");
	}
	//initialize your frontier
	//while there is stuff in the frontier:
	//  get the next location
	//  process the location to find the locations (use the maze to do this)
	//  check if any locations are the end, if you found the end just return true!
	//  add all the locations to the frontier
	//when there are no more values in the frontier return false
	return false;
    }

    public String toString() {
	return maze.toString();
    }

}
