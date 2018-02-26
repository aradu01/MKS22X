public class KnightBoard {

    private int[][] board;
    private int[][] optimize;
    private int[][] coordinates;
    private int solutionsCounter;

    public KnightBoard(int startingRows, int startingCols) {
        board = new int[startingRows][startingCols];
        optimize = new int[startingRows][startingCols];
        coordinates = new int[][] { {1,2}, {1,-2}, 
                                    {2,1}, {2,-1},
                                    {-1,2}, {-1,-2},
                                    {-2,1}, {-2,-1} };
    
        for (int row = 0; row < optimize.length; row++) {
            for (int col = 0; col < optimize[row].length; col++) {
                for (int[] move: coordinates) {
                    if (row + move[0] >= 0 && row + move[0] < optimize.length &&
                        col + move[1] >= 0 && col + move[1] < optimize[0].length) {
                        optimize[row][col]++;
                    }
                }
            }
        }
    }

    public String toString() {
        String grid = "";

        for (int[] row: board) {
            for (int cell: row) {
                if (cell == 0) {
                    grid += "  _";
                }
                else if (cell < 10) {
                    grid += "  " + cell;
                }
                else {
                    grid += " " + cell;
                }
            }
            grid += "\n";
        }
        
        /* For Testing.
        grid += "\n Optimization \n";
        
        for (int[] a: optimize) {
            for (int b: a) {
                grid += "  " + b;
            }
            grid += "\n";
        }
        */
        
        return grid;
    }

    public boolean solveFast() {
        for (int[] row: board) {
            for (int cell: row) {
                if (cell != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        
        return helpSolve(0, 0, 1);
    }

    private boolean helpSolve(int row, int col, int counter) {
	if (row >= 0 && row < board.length &&
	    col >= 0 && col < board[0].length) {
	    
	    if (board[row][col] == 0) {
	    
		if (counter == board.length * board[0].length) {
		    board[row][col] = counter;
		    return true;
		}
        
		board[row][col] = counter;
        
		int fastest = 0;

		for (int start = 0; start < coordinates.length; start++) {
		    fastest = 0;

		    while (! (row + coordinates[fastest][0] >= 0 && row + coordinates[fastest][0] < board.length &&
			      col + coordinates[fastest][1] >= 0 && col + coordinates[fastest][1] < board.length)) {
			fastest++;
		    }
	
		    for (int move = start; move < coordinates.length; move++) {
			if (row + coordinates[move][0] >= 0 && row + coordinates[move][0] < board.length &&
			    col + coordinates[move][1] >= 0 && col + coordinates[move][1] < board[0].length) {
			    if (optimize[row + coordinates[move][0]][col + coordinates[move][1]] <
				optimize[row + coordinates[fastest][0]][col + coordinates[fastest][1]]) {
				fastest = move;
			    }
			}
		    }

		    int[] temp = coordinates[0];
		    coordinates[0] = coordinates[fastest];
		    coordinates[fastest] = temp;
		}

		for (int[] move: coordinates) {
		    if (helpSolve(row + move[0], col + move[1], counter + 1)) {
			return true;
		    }
		}
        
		board[row][col] = 0;
	    }
	}
	
        return false;
    }


    public static void main(String[] args) {
        KnightBoard a = new KnightBoard(4,4);
        System.out.println(a);
        
        a.solveFast();
        System.out.println(a);
    }
 

}
