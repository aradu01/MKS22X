import java.util.LinkedList;

public class FrontierQueue implements Frontier {

    private LinkedList<Location> frontier;
    private int size;

    public FrontierQueue() {
	frontier = new LinkedList<Location>();
    }

    /* For Testing.
    public String toString() {
	Location current = frontier.getFirst();
	String result = "";

	while (current != null) {
	    result += current + ", ";
	    current = current.next();
	}

	return result;
    }
    */

    public Location next() {
	size--;
	return frontier.removeFirst();
    }

    public void add(Location addition) {
	frontier.add(addition);
	size++;
    }

    public boolean hasNext() {
	return size > 0;
    }
    
}
