public class Location {
    
    private int x;
    private int y;
    private Location previous;

    public Location(int _x, int _y, Location prev) {
	x = _x;
	y = _y;

	previous = prev;
    }

    public int xcor() {
	return x;
    }

    public int ycor() {
	return y;
    }

    public Location getLast() {
	return previous;
    }
    
}
