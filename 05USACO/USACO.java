import java.util.*;
import java.io.*;

public class USACO {

    public static int bronze(String filename) {  // Needed to throw a FileNotFoundException when testing.
        // First, set up the local variables.
        
        File text = new File(filename);
        Scanner reader = new Scanner(text);
        
        int length = reader.nextInt();
        int width = reader.nextInt();
        int elevation = reader.nextInt();
        int numDirections = reader.nextInt();

        int[][] field = new int[length][width];

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                field[row][col] = reader.nextInt();
            }
        }
        
        int[][] instructions = new int[numDirections][3];
        
        for (int row = 0; row < instructions.length; row++) {
            for (int col = 0; col < instructions[row].length; col++) {
                instructions[row][col] = reader.nextInt();
            }
        }
        
        /* For Testing.
        String result = "";
        
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                result += field[row][col] + " ";
            }
            result += "\n";
        }
        
        System.out.println(result);
        result = "";
        
        for (int row = 0; row < instructions.length; row++) {
            for (int col = 0; col < instructions[row].length; col++) {
                result += instructions[row][col] + " ";
            }
            result += "\n";
        }
        
        System.out.println(result);
        */
        
        // Next, perform the instructions.
        
        int highest;
        
        for (int[] move: instructions) {
            highest = field[move[0]][move[1]];
            
            for (int row = move[0] - 1; row < move[0] + 2; row++) {
                for (int col = move[1] - 1; col < move[1] + 2; col++) {
                    if (field[row][col] > highest) {
                        highest = field[row][col];
                    }
                }
            }
            
            int newValue = highest - move[2];
            
            for (int row = move[0] - 1; row < move[0] + 2; row++) {
                for (int col = move[1] - 1; col < move[1] + 2; col++) {
                    if (field[row][col] > newValue) {
                        field[row][col] = newValue;
                    }
                }
            }
        }
        
        /* For Testing.
        String answer = "";
        
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                answer += field[row][col] + " ";
            }
            answer += "\n";
        }
        
        System.out.println(answer);
        */
        
        //Then, calculate the lake depths.
        
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if (elevation - field[row][col] > 0) {
                    field[row][col] = elevation - field[row][col];
                }
                else {
                    field[row][col] = 0;
                }
            }
        }
        
        /* For Testing.
        String outcome = "";
        
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                outcome += field[row][col] + " ";
            }
            outcome += "\n";
        }
        
        System.out.println(outcome);
        */
        
        // Finally, find the volume of the lake.
        
        int area = 0;
        
        for (int[] row: field) {
            for (int patch: row) {
                area += patch;
            }
        }
        
        return area * 72 * 72;
    }
    
    public static int silver(String filename) { // Needed to throw a FileNotFoundException when testing.
        //First, set up the local variables.
        
        File document = new File(filename);
        Scanner reciter = new Scanner(document);
        
        int length = reciter.nextInt();
        int width = reciter.nextInt();
        int time = reciter.nextInt();
        
        char[][] land = new char[length][width];
        String line = reciter.nextLine();
        
        for (int row = 0; row < land.length; row++) {
            line = reciter.nextLine();

            for (int col = 0; col < land[row].length; col++) {
                land[row][col] = line.charAt(col);
            }
        }
        
        int[] coordinates = new int[4];
        
        for (int cell = 0; cell < coordinates.length; cell++) {
            coordinates[cell] = reciter.nextInt();
        }
        
        /* For Testing.
        String result = "";
        
        for (int row = 0; row < land.length; row++) {
            for (int col = 0; col < land[row].length; col++) {
                result += land[row][col] + " ";
            }
            result += "\n";
        }
        
        System.out.println(result);
        result = "";
        
        for (int cell = 0; cell < coordinates.length; cell++) {
            result += coordinates[cell] + " ";
        }
        
        System.out.println(result);
        */
        
        // Next, perform the instructions.
        
        int ways = 0;
        int[][] moves = new int[][] { {1,0}, {0,1}, {-1,0}, {0,-1} };
        int xcor = coordinates[0];
        int ycor = coordinates[1];
        
        while (time > 0) {
            for (int[] step: moves) {
                
            }
            time--;
        }
        
        if (xcor == coordinates[2] && ycor == coordinates[3]) {
            ways++;
        }
        
        return ways;
    }
    
    /* For Testing.
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(USACO.bronze("Test1.txt"));
        System.out.println("Correct answer is 342144.\n");
        
        System.out.println(USACO.bronze("Test2.txt"));
        System.out.println("Correct answer is 102762432.\n");
        
        System.out.println(USACO.bronze("Test3.txt"));
        System.out.println("Correct answer is 1058992704.\n");
        
        System.out.println(USACO.bronze("Test4.txt"));
        System.out.println("Correct answer is 753121152.\n");
        
        System.out.println(USACO.bronze("Test5.txt"));
        System.out.println("Correct answer is 1028282688.\n");
        
        System.out.println(USACO.bronze("Test6.txt"));
        System.out.println("Correct answer is 72207936.\n");
        
        System.out.println(USACO.bronze("Test7.txt"));
        System.out.println("Correct answer is 265508928.\n");
        
        System.out.println(USACO.bronze("Test8.txt"));
        System.out.println("Correct answer is 776609856.\n");
        
        System.out.println(USACO.silver("TestA.txt"));
    }
    */

}