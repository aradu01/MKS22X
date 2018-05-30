public class Location implements Comparable<Location> {
    
    private int x;
    private int y;
    private Location previous;
    private double distance;
    private int traveled;

    public Location(int _x, int _y, Location prev) {
        x = _x;
        y = _y;

        previous = prev;
    }

    public Location(int xcor, int ycor, Location prev, int radius) {
	x = xcor;
        y = ycor;

        previous = prev;
	traveled = radius;
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
    
    public double getDistance() {
        return distance;
    }
    
    public void setDistance(double quantity) {
        distance = quantity;
    }
    
    public int getTraveled() {
        return traveled;
    }

    /*
    public void takeStep() {
        traveled++;
    }
    */
    
    public int compareTo(Location other) {
        if (MazeSolver.aStarStatus()) {
            if (this.distance + this.traveled < other.distance + other.traveled) {
                return -1;
            }

            else if (this.distance + this.traveled == other.distance + other.traveled) {
                return 0;
            }

            else {
                return 1;
            }
        }
        
        else {
            if (this.distance < other.distance) {
                return -1;
            }

            else if (this.distance == other.distance) {
                return 0;
            }

            else {
                return 1;
            }
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
