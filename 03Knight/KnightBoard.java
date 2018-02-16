public class KnightBoard {

    private int[][] board;
    private int[][] coordinates;

    public KnightBoard(int startingRows, int startingCols) {
    board = new int[startingRows][startingCols];
    coordinates = new int[][] { {1,2}, {1,-2}, 
                                {2,1}, {2,-1},
                                {-1,2}, {-1,-2},
                                {-2,1}, {-2,-1} };

    /*  Optimization Attempt.
    for (int row = 0; row < board.length; row++) {
        for (int col = 0; col < board.length[row]; col++) {
            if (row = 0 && col = 0 ||
                row = 0 && col = board[row].length - 1 ||
                row = board.length - 1 && col = 0 ||
                row = board.length - 1 && col = board[row].length - 1) {
                board[row][col] = 2;
            }

        else if (
    */        
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
        
        return grid;
    }

    public boolean solve(int startingRow, int startingCol) {
        for (int[] row: board) {
            for (int cell: row) {
                if (cell != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        
        return helpSolve(startingRow, startingCol, 1, 0, 0);
    }

    private boolean helpSolve(int row, int col, int counter, int xdirection, int ydirection) {
        if (counter == board.length * board[0].length) {
            board[row][col] = counter;
            return true;
        }
        
        board[row][col] = counter;
        System.out.println(this);

        for (int[] move: coordinates) {
            if (row + move[0] >= 0 && row + move[0] < board.length &&
                col + move[1] >= 0 && col + move[1] < board[0].length) {
                if ((xdirection != -move[0] || ydirection != -move[1]) && board[row + move[0]][col + move[1]] == 0) {
                    if (helpSolve(row + move[0], col + move[1], counter + 1, move[0], move[1])) {
                        return true;
                    }
                }
            }
        }
        
        board[row][col] = 0;
        return false;
    }
   /* 
    public int countSolutions(int startingRow, int startingCol) {
        for (int[] row: board) {
            for (int cell: row) {
                if (cell != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        
        helpCount(starting);
        return solutionsCounter;
    }
    
    private boolean helpCount(int row, int col, int counter, int xdirection, int ydirection) {
        if (counter == 0) {
            return true;
        }

        for (int[] move: coordinates) {
            if (row + move[0] >= 0 && row + move[0] < board.length &&
                col + move[1] >= 0 && col + move[1] < board[0].length) {
                if ((xdirection != -move[0] || ydirection != -move[1]) && board[row + move[0]][col + move[1]] == 0) {
                    if (helpSolve(row + move[0], col + move[1], counter - 1, move[0], move[1])) {
                        board[row][col] = counter;
                        System.out.println(this);
                        return true;
                    }
                }
            }
        }

        return false;
    }
*/
    public static void main(String[] args) {
        KnightBoard a = new KnightBoard(5, 5);
        System.out.println(a);

        a.solve(1, 1);
        System.out.println(a);
    }

}