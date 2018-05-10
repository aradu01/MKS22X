import java.util.LinkedList;

public class FrontierStack implements Frontier {

    private LinkedList<Location> frontier;
    private int size;

    public FrontierStack() {
	frontier = new LinkedList<Location>();
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
