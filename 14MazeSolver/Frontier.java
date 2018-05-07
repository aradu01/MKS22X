public interface Frontier {

    public Location next();
    
    public void add(Location n);
    
    public boolean hasNext();

}
