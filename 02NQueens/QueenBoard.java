public class QueenBoard {

    private int[][] board;

    public QueenBoard(int size) {
	board = new int[size][size];
    }

    public String toString() {
	String grid = "";
	for (int row = 0; row < board.length; row++) {
	    String line = "";
	    for (int col = 0; col < board[row].length; col++) {
		if (board[row][col] < 0) {
		    line += "Q ";
		}
		else {
		    line += "_ ";
		}
	    }
	    grid += line + "\n";
	}
	return grid;
    }
    
    private boolean addQueen(int r, int c) {
	board[r][c] = -1;
	int counter = 0;
	
	while (r + 1 < board.length) {
	    r++;
	    board[r][c]++;
	    board[r][c + counter]++;
	    counter++;
	}
	
	return true;
    }

    private boolean removeQueen(int r, int c) {
	board[r][c] = 0;
	int counter = 0;
	
	while (r + 1 < board.length) {
	    r++;
	    board[r][c]--;
	    board[r][c + counter]--;
	    counter++;
	}
	
	return true;
    }

}
