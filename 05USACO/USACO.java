public class USACO {

    public static int bronze(String filename) {
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
    }

}
