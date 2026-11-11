
public class Main {

    public static void main(String[] args) {

        // TASK 1: Binary Search Tree
        System.out.println("\n===== TASK 1: PRODUCT CATEGORY BST =====");

        ProductCategoryBst bst = new ProductCategoryBst();

        String[] categories = {
            "Electronics", "Clothing", "Books",
            "Furniture", "Sports"
        };

        for (String category : categories) {
            bst.root = bst.insert(bst.root, category);
        }

        System.out.print("Inorder: ");
        bst.inorder(bst.root);

        System.out.println("\nSearch Electronics: "
                + bst.search(bst.root, "Electronics"));


        // TASK 2: Custom Hash Table
        System.out.println("\n\n===== TASK 2: CUSTOM HASH TABLE =====");

        CustomHashTable table = new CustomHashTable(10);

        table.insert("SKU101", "Laptop");
        table.insert("SKU102", "Mobile");
        table.insert("SKU103", "Headphones");

        table.display();

        System.out.println("Search: " + table.search("SKU101"));


        // TASK 3: HashMap Benchmark
        System.out.println("\n===== TASK 3: HASHMAP BENCHMARK =====");
        HashMapBenchmark.main(new String[]{});


        // TASK 4: Microservice Graph
        System.out.println("\n===== TASK 4: MICROSERVICE GRAPH =====");
        MicroserviceGraph.main(new String[]{});


        // TASK 5: Traffic Analysis
        System.out.println("\n===== TASK 5: TRAFFIC ANALYSIS =====");
        TrafficAnalyzer.main(new String[]{});


        // TASK 6: Gift Card Pairs
        System.out.println("\n===== TASK 6: GIFT CARD PAIRS =====");
        GiftCardPairs.main(new String[]{});

    }
}
