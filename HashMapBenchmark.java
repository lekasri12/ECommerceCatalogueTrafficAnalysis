
import java.util.HashMap;

public class HashMapBenchmark {

    public static void main(String[] args) {

        // PART 1: Demonstrate collision
        System.out.println("----- COLLISION DEMONSTRATION -----");

        CustomHashTable smallTable = new CustomHashTable(10);

        smallTable.insert("A", "Laptop");
        smallTable.insert("K", "Mobile");

        System.out.println("Hash index of A: " + Math.floorMod("A".hashCode(), 10));
        System.out.println("Hash index of K: " + Math.floorMod("K".hashCode(), 10));

        System.out.println("Hash Table:");
        smallTable.display();

        // PART 2: Compare 100,000 SKU lookups
        System.out.println("\n----- HASH TABLE COMPARISON -----");

        int n = 100000;

        CustomHashTable customTable = new CustomHashTable(200003);
        HashMap<String, String> hashMap = new HashMap<>();

        // Insert 100,000 products
        for (int i = 0; i < n; i++) {

            String sku = "SKU" + i;
            String product = "Product" + i;

            customTable.insert(sku, product);
            hashMap.put(sku, product);
        }

        // Search in custom hash table
        long start1 = System.nanoTime();

        for (int i = 0; i < n; i++) {
            customTable.search("SKU" + i);
        }

        long end1 = System.nanoTime();

        // Search in built-in HashMap
        long start2 = System.nanoTime();

        for (int i = 0; i < n; i++) {
            hashMap.get("SKU" + i);
        }

        long end2 = System.nanoTime();

        System.out.println("Custom Hash Table Time: "
                + (end1 - start1) / 1_000_000.0 + " ms");

        System.out.println("Java HashMap Time: "
                + (end2 - start2) / 1_000_000.0 + " ms");
    }
}
