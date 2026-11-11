
public class CustomHashTable {

    // Node for linked-list chaining
    class Node {
        String sku;
        String product;
        Node next;

        Node(String sku, String product) {
            this.sku = sku;
            this.product = product;
            this.next = null;
        }
    }

    Node[] table;
    int size;

    // Create hash table
    CustomHashTable(int size) {
        this.size = size;
        table = new Node[size];
    }

    // Hash function
    int hash(String sku) {
        return Math.floorMod(sku.hashCode(), size);
    }

    // Insert SKU and product
    void insert(String sku, String product) {

        int index = hash(sku);

        Node newNode = new Node(sku, product);

        if (table[index] == null) {
            table[index] = newNode;
        } else {
            Node temp = table[index];

            while (temp.next != null) {
                if (temp.sku.equals(sku)) {
                    temp.product = product;
                    return;
                }
                temp = temp.next;
            }

            if (temp.sku.equals(sku)) {
                temp.product = product;
            } else {
                temp.next = newNode;
            }
        }
    }

    // Search SKU
    String search(String sku) {

        int index = hash(sku);

        Node temp = table[index];

        while (temp != null) {
            if (temp.sku.equals(sku)) {
                return temp.product;
            }
            temp = temp.next;
        }

        return "Product not found";
    }

    // Display hash table
    void display() {

        for (int i = 0; i < size; i++) {

            System.out.print(i + " -> ");

            Node temp = table[i];

            while (temp != null) {
                System.out.print(temp.sku + " : " + temp.product + " -> ");
                temp = temp.next;
            }

            System.out.println("null");
        }
    }
}
