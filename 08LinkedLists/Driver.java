public class Driver {

    public static void main(String[] args) {
        System.out.println();
        System.out.println("--- Get ---");
        MyLinkedList a = new MyLinkedList();
        
        for (int x = 0; x < 10; x++) {
            a.add(new Integer((int) (Math.random() * 100)));
        }
        
        System.out.println(a);
        
        for (int y = 0; y < 10; y++) {
            System.out.println(y + ": " + a.get(y));
        }
        
        System.out.println();
        System.out.println("--- Set ---");
        System.out.println(a);
        
        int former;
        int replace;
        
        for (int q = 0; q < 10; q++) {
            replace = 10 - q;
            former = a.set(q, replace);
            System.out.println("Change " + former + " to " + replace);
        }
        
        System.out.println(a);
        
        System.out.println();
        System.out.println("--- Index Of ---");
        System.out.println(a);
        
        for (int z = 0; z < 12; z++) {
            System.out.println(z + ": " + a.indexOf(new Integer(z)));
        }
        
        System.out.println();
        System.out.println("--- Add At End ---");
        MyLinkedList b = new MyLinkedList();
        System.out.println(b);

        for (int i = 0; i < 10; i++) {
            b.add(new Integer((int) (Math.random() * 100)));
        }

        System.out.println(b);
        System.out.println("Size: " + b.size());
        
        System.out.println();
        System.out.println("--- Add At Index ---");
        System.out.println(b);
        
        for (int s = 0; s < 13; s += 6) {
            b.add(s, new Integer(-99));
            System.out.println("Index " + s + ": " + b);
        }
        
        System.out.println();
        System.out.println("--- Remove Value ---");
        MyLinkedList j = new MyLinkedList();
        
        for (int u = 1; u < 6; u++) {
            j.add(new Integer(u));
        }
        
        System.out.println(j);
        
        for (int k = 1; k < 6; k += 2) {
            System.out.println("Removing " + k);
            j.remove(new Integer(k));
            System.out.println(j);
        }
        
        System.out.println();
        System.out.println("--- Remove at Index ---");
        MyLinkedList c = new MyLinkedList();
        
        for (int f = 0; f < 10; f++) {
            c.add(new Integer((int) (Math.random() * 100)));
        }
        
        System.out.println(c);
        System.out.println("Size: " + c.size());
        
        System.out.println("Removed " + c.get(0) + " at index 0");
        c.remove(0);
        
        System.out.println("Removed " + c.get(4) + " at index 4");
        c.remove(4);
        
        System.out.println("Removed " + c.get(7) + " at index 7");
        c.remove(7);
        
        System.out.println(c);
    }

}
