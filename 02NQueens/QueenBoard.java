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
    	int row = r;
    	int column = c;
    	
    	while (row < board.length - 1) {
    	    row++;
    	    board[row][c]++;
    	    if (column < board.length - 1) {
    	        column++;
    	        board[row][column]++;
    	    }
    	}
    	
        return true;
    }

    private boolean removeQueen(int r, int c) {
    	board[r][c] = -1;
    	int row = r;
    	int column = c;
    	
    	while (row < board.length - 1) {
    	    row++;
    	    board[row][c]--;
    	    if (column < board.length - 1) {
    	        column++;
    	        board[row][column]--;
    	    }
    	}
    	
        return true;
    }
    
    private int findQueen(int r) {
        for (int position = 0; position < board[r].length; position++) {
            if (board[r][position] == -1) {
                return position;
            }
        }
        return -999;
    }
    
    public boolean solve() {
        return help(board.length, 0, 0);
    }
    
    private boolean help(int counter, int row, int col) {
        if (counter == 0) {
            return true;
        }
        else if (col == board[0].length) {
            int temp = this.findQueen(row);
            this.removeQueen(row - 1, temp);
            return help(counter + 1, row - 1, temp + 1);
        }
        else {
            if (board[row][col] == 0) {
                this.addQueen(row, col);
                return help(counter - 1, row + 1, 0);
            }
            else {
                return help(counter, row, col + 1);
            }
        }
    }

}