import java.util.LinkedList;

public class FrontierQueue implements Frontier {

    private LinkedList<Location> frontier;
    private int size;

    public FrontierQueue() {
	frontier = new LinkedList<Location>();
    }

    public Location next() {
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
