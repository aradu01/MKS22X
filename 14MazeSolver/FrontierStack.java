import java.util.ArrayList;

public class FrontierStack implements Frontier {

    private ArrayList<Location> frontier;

    public FrontierStack() {
    	frontier = new ArrayList<Location>();
    }

    public String toString() {
    	String result = "";
    
        for (Location place: frontier) {
    	    result += place + "; ";
    	}
    
    	return result;
    }

    public Location next() {
    	return frontier.remove();
    }

    public void add(Location addition) {
    	frontier.add(addition);
    }

    public boolean hasNext() {
    	return frontier.size() > 0;
    }
    
}

/* Previous Version.
import java.util.LinkedList;

public class FrontierStack implements Frontier {

    private LinkedList<Location> frontier;
    private int size;

    public FrontierStack() {
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
	return frontier.remove();
    }

    public void add(Location addition) {
	frontier.add(addition);
	size++;
    }

    public boolean hasNext() {
	return size > 0;
    }
    
}
*/
