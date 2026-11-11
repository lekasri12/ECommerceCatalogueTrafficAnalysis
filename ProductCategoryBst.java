
public class ProductCategoryBst {

    // Create a node
    class Node {
        String data;
        Node left, right;

        Node(String data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    // Insert a category
    Node insert(Node root, String data) {

        if (root == null) {
            return new Node(data);
        }

        if (data.compareTo(root.data) < 0) {
            root.left = insert(root.left, data);
        } 
        else if (data.compareTo(root.data) > 0) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    // Search a category
    boolean search(Node root, String key) {

        if (root == null) {
            return false;
        }

        if (root.data.equals(key)) {
            return true;
        }

        if (key.compareTo(root.data) < 0) {
            return search(root.left, key);
        }

        return search(root.right, key);
    }

    // Inorder: Left, Root, Right
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    // Preorder: Root, Left, Right
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    // Postorder: Left, Right, Root
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}
