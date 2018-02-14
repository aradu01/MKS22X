public class KnightBoard {

    private int[][] board;
    private int[][] coordinates;

    public KnightBoard(int startingRows, int startingCols) {
	board = new int[startingRows][startingCols];
	coordinates = { {1,2}, {1,-2}, 
			{2,1}, {2,-1},
			{-1,2}, {-1,-2},
			{-2,1}, {-2,-1} };

	for (int row = 0; row < board.length; row++) {
	    for (int col = 0; col < board.length[row]; col++) {
		if (row = 0 && col = 0 ||
		    row = 0 && col = board[row].length - 1 ||
		    row = board.length - 1 && col = 0 ||
		    row = board.length - 1 && col = board[row].length - 1) {
		}//////////
		    
		    
    }

    public String toString() {
	String grid = "";
	for (int[] row: board) {
	    for (int cell: row) {
		if (cell < 10) {
		    grid += "  " + cell;
		}
		else {
		    grid += " " + cell;
		}
	    }
	    grid += "\n";
	}
	return grid;
    }

    public boolean solve(int startingRow, int startingCol) {
	
