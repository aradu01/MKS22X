public class FrontierPriorityQueue implements Frontier {
    
    private MyHeap<Location> frontier;
    
    public FrontierPriorityQueue() {
        frontier = new MyHeap<Location>(false);
    }
    
    public String toString() {
        return frontier.toString();
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
import java.util.PriorityQueue;

public class FrontierPriorityQueue implements Frontier {
    
    private PriorityQueue<Location> frontier;
    
    public FrontierPriorityQueue() {
        frontier = new PriorityQueue<Location>();
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
        return frontier.poll();
    }
    
    public void add(Location addition) {
        frontier.add(addition);
    }
    
    public boolean hasNext() {
        return frontier.size() > 0;
    }
    
}
*/