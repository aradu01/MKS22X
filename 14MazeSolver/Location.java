public class Location implements Comparable<Location> {
    
    private int x;
    private int y;
    private Location previous;
    private double distance;

    public Location(int _x, int _y, Location prev) {
        x = _x;
        y = _y;

        previous = prev;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
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
    
    public double getDist() {
        return distance;
    }
    
    public void setDist(double quantity) {
        distance = quantity;
    }
    
    public int compareTo(Location other) {
        if (this.distance < other.getDist()) {
            return -1;
        }
        
        else if (this.distance == other.getDist()) {
            return 0;
        }
        
        else {
            return 1;
        }
    }

    /* First Attempt.
    public Location[] neighbors() {
        Location[] result = new Location[4];

        result[0] = new Location(x - 1, y, this);
        result[1] = new Location(x, y + 1, this);
        result[2] = new Location(x + 1, y, this);
        result[3] = new Location(x, y - 1, this);

        return result;
    }
    */
	
}