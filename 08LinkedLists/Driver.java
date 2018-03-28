public class Driver {

    public static void main(String[] args) {
	System.out.println("----- Node.java -----");

	Node a = new Node(5);
	System.out.println(a);

	System.out.println("----- MyLinkedList.java -----");

	MyLinkedList b = new MyLinkedList();
	System.out.println(b);

	for (int i = 0; i < 10; i++) {
	    b.add(i);
	}

	System.out.println(b);
	System.out.println(b.size());
    }

}
