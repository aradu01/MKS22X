public class QueenBoard {

    private int[][] board;
    private int solutionsCounter;

    public QueenBoard(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("The board size must be positive.");
        }
    
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

        /* Used for Testing.
        for (int[] row: board) {
            for (int col: row) {
            if (col == -1) {
                grid += "Q ";
            }
            else {
                grid += col + " ";
            }
            }
            grid += " \n";
        }
        return grid;
        */
    }
    
    private boolean addQueen(int r, int c) {
        if (r >= board.length || c >= board[0].length) {
            return false;
        }

        if (board[r][c] == 0) {
            board[r][c] = -1;
            int row = r;
            int deltaY = 0;

            while (row < board.length - 1) {
                row++;
                deltaY++;
                board[row][c]++;

                if (c + deltaY <= board.length - 1) {
                    board[row][c + deltaY]++;
                }

                if (c - deltaY >= 0) {
                    board[row][c - deltaY]++;
                }
            }

            return true;
        }

        return false;
    }

    private boolean removeQueen(int r, int c) {
        if (r >= board.length || c >= board[0].length) {
            return false;
        }

        if (board[r][c] == -1) {
            board[r][c] = 0;
            int row = r;
            int deltaY = 0;

            while (row < board.length - 1) {
                row++;
                deltaY++;
                board[row][c]--;

                if (c + deltaY <= board.length - 1) {
                    board[row][c + deltaY]--;
                }

                if (c - deltaY >= 0) {
                    board[row][c - deltaY]--;
                }
            }

            return true;
        }
        return false;
    }
    
    public boolean solve() {
        for (int[] row: board) {
            for (int cell: row) {
                if (cell != 0) {
                    throw new IllegalStateException();
                }
            }
        }
    
        return helpSolve(0);
    }
    
    public boolean helpSolve(int row) {
        if (row == board.length) {
            return true;
        }

        for (int col = 0; col < board[row].length; col++) {
            if (addQueen(row, col)) {
                if (helpSolve(row + 1)) {
                    return true;
                }
                else {
                    removeQueen(row, col);
                }
            }
        }
        
        return false;
    }

    /* My Initial Solution.
    private int findQueen(int r) {
        for (int position = 0; position < board[r].length; position++) {
            if (board[r][position] == -1) {
                return position;
            }
        }
        return -999;
    }
    */
    
    /* My Initial Solution.
    private boolean help(int counter, int row, int col) {
        if (counter == 0) {
            return true;
        }
        else if (col == board[0].length) {
            int temp = this.findQueen(row - 1);
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
    */

    public int countSolutions() {
        for (int[] row: board) {
            for (int cell: row) {
                if (cell != 0) {
                    throw new IllegalStateException();
                }
            }
        }
        
        helpCount(0);
        return solutionsCounter;
    }

    public boolean helpCount(int row) {
        if (row == board.length) {
            solutionsCounter++;
            return true;
        }

        for (int col = 0; col < board[row].length; col++) {
            if (addQueen(row, col)) {
                helpCount(row + 1);
                removeQueen(row, col);
            }
        }
        
        return false;
    }
    
    /* Used for Testing.
    public static void main(String[] args) {
        QueenBoard a = new QueenBoard(5);
        System.out.println(a);
        
        a.addQueen(0,0);
        System.out.println(a);
        
        a.addQueen(2, 3);
        System.out.println(a);
        
        a.removeQueen(0,0);
        System.out.println(a);
        
        QueenBoard b = new QueenBoard(8);
        b.solve();
        System.out.println(b);
        
        QueenBoard c = new QueenBoard(10);
        System.out.println(c.countSolutions());
        
        QueenBoard d = new QueenBoard(5);
        System.out.println(d.countSolutions());
    }
    */

}
