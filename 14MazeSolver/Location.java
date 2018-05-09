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
    
    public Location[] neighbors() {
	Location[] result = new Location[4];
	
	result[0] = new Location(x - 1, y, this);
	result[1] = new Location(x, y + 1, this);
	result[2] = new Location(x + 1, y, this);
	result[3] = new Location(x, y - 1, this);
	
	return result;
    }
	
}
