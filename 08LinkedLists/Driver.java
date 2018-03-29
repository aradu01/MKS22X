public class Driver {

    public static void main(String[] args) {
	System.out.println("--- Add At End ---");
	MyLinkedList b = new MyLinkedList();
	System.out.println(b);
	
	for (int i = 0; i < 10; i++) {
	    b.add(new Integer(i));
	}
	
	System.out.println(b);
	System.out.println("Size: " + b.size());
	
	System.out.println("--- Add At Index ---");

	
    }

}
