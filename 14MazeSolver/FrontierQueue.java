import java.util.LinkedList;

public class FrontierQueue implements Frontier {

    private LinkedList<Location> frontier;
    private int size;

    public FrontierQueue() {
	frontier = new LinkedList<Location>();
    }

    public String toString() {
	Object[] array = frontier.toArray();
	
	String result = "";

        for (Object place: array) {
	    result += place + "; ";
	}

	return result;
    }

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
