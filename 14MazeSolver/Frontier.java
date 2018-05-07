public interface Frontier {

    public Location next();
    
    public void add(Location addition);
    
    public boolean hasNext();

}
