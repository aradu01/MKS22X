import java.util.*;
import java.io.*;

public class Maze {

    private char[][] maze;
    private boolean animate;

    public Maze(String filename) throws FileNotFoundException {
        File text = new File(filename);
        Scanner counter = new Scanner(text);
        Scanner reader = new Scanner(text);

        String line = counter.nextLine();
        int length = line.length();
        int width = 1;

        while (counter.hasNextLine()) {
            width++;
	    counter.nextLine();
        }
        
        char[][] maze = new char[length][width];
	
        while (reader.hasNextLine()) {
            for (int row = 0; row < maze.length; row++) {
                line = reader.nextLine();

                for (int col = 0; col < maze[row].length; col++) {
                    maze[row][col] = line.charAt(col);
                }
            }
        }
    }

    private void wait(int millis) {
         try {
             Thread.sleep(millis);
         }
	 
         catch (InterruptedException e) { }
     }

    public void setAnimate(boolean b) {
        animate = b;
    }

    public void clearTerminal() {
        System.out.println("\033[2J\033[1;1H");
    }

    public int solve(){

	int rowS = 0;
	int colS = 0;

	for (int row = 0; row < maze.length; row++) {
	    for (int col = 0; col < maze[row].length; col++) {
		if (maze[row][col] == 'S') {
		    rowS = row;
		    colS = col;
		}
	    }
	}

	maze[rowS][colS] = '@';

        return solve(rowS, colS, 0);
    }

    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns the number of @ symbols from S to E when the maze is solved,
      Returns -1 when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'

            Note: This is not required based on the algorithm, it is just nice visually to see.
        All visited spots that are part of the solution are changed to '@'
    
    private int solve(int row, int col, int steps) { //you can add more parameters since this is private

	int current = 0;

        //automatic animation! You are welcome.
        if(animate){

            clearTerminal();
            System.out.println(this);

            wait(20);
        }

        //COMPLETE SOLVE

	if (maze[row][col] == '#') {
	    return 0;
	}

	if (maze[row][col] == 'E') {
	    return steps;
	}

	if (maze[row][col] == ' ') {
	    current += 1;
	}

	solve(row + 1, col, steps + count);
	solve(row, col + 1, steps + count);

        return -1; //so it compiles
    }
    */
    
    public static void main (String[] args) {
	Maze a = null;

	try {
	    a = new Maze("data1.dat");
	}
	catch (FileNotFoundException e) {
	    System.out.println("Exception works!");
	    System.exit(1);
	}
    }
    
}
