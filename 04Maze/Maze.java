import java.util.*;
import java.io.*;

public class Maze {

    private char[][] maze;
    private boolean animate;
    private int[][] coordinates;

    public Maze(String filename) throws FileNotFoundException {
	coordinates = new int[][] { {0,1}, {1,0}, {0,-1}, {-1,0} };
	
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
	
	/* For Testing.
	int length = 0;
        int width = 1;
        
        for (; length < filename.length() - 1; length++) {
            if (filename.substring(length, length + 2).equals("\n")) {
                break;
            }
        }
        
        for (int a = 0; a < filename.length() - 1; a++) {
            if (filename.substring(a, a + 2).equals("\n")) {
                width++;
            }
        }
	*/
    }
	
    public String toString() {
	String result = "";
	
	for (int row = 0; row < maze.length; row++) {
	    for (int col = 0; col < maze[row].length; col++) {
		result += maze[row][col];
	    }
	    result += '\n';
	}
	
	return result;
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
    
    private int solve(int row, int col, int steps) { //you can add more parameters since this is private
        if (animate) {
            clearTerminal();
            System.out.println(this);
            wait(20);
        }
        
        if (maze[row][col] == 'E') {
    	    return steps;
    	}
    	
    	if (maze[row][col] == '#' || maze[row][col] == '.' || maze[row][col] == '.') {
    	    return -1;
    	}
    	
    	maze[row][col] = '@';
    	
    	if (maze[row][col] == ' ') {
    	    for (int[] move: coordinates) {
    	        if (solve(row + move[0], col + move[1], steps + 1) > 0) {
    	            return solve(row + move[0], col + move[1], steps + 1);
    	        }
    	    }
    	}
        
        maze[row][col] = '.';
        return -1;
    }
    
    public static void main (String[] args) {
	try {
	    Maze a = new Maze("NONEXISTENTFILE.dat");
	}
	catch (FileNotFoundException e) {
	    System.out.println("Exception works!");
	    System.exit(1);
	}
	
	Maze b = new Maze("data1.dat");
	System.out.println(b);
	b.solve();
	System.out.println(b);
	
	Maze c = new Maze("data2.dat");
	System.out.println(c);
	c.solve();
	System.out.println(c);
	
	Maze d = new Maze("data3.dat");
	System.out.println(d);
	d.solve();
	System.out.println(d);
    }
    
}
