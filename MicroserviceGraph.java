
import java.util.*;

public class MicroserviceGraph {

    ArrayList<ArrayList<Integer>> adj;
    String[] services;
    int vertices;

    MicroserviceGraph(String[] services) {

        this.services = services;
        vertices = services.length;

        adj = new ArrayList<>();

        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Add dependency: service u must run before service v
    void addDependency(int u, int v) {
        adj.get(u).add(v);
    }

    // BFS traversal
    void BFS(int start) {

        boolean[] visited = new boolean[vertices];
        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.add(start);

        System.out.print("BFS: ");

        while (!q.isEmpty()) {

            int node = q.poll();
            System.out.print(services[node] + " ");

            for (int neighbour : adj.get(node)) {

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }

        System.out.println();
    }

    // DFS traversal
    void DFS(int node, boolean[] visited) {

        visited[node] = true;
        System.out.print(services[node] + " ");

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {
                DFS(neighbour, visited);
            }
        }
    }

    void startDFS(int start) {

        boolean[] visited = new boolean[vertices];

        System.out.print("DFS: ");
        DFS(start, visited);
        System.out.println();
    }

    // Topological sorting using BFS (Kahn's Algorithm)
    void topologicalSortBFS() {

        int[] indegree = new int[vertices];

        for (int i = 0; i < vertices; i++) {
            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < vertices; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<String> order = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();
            order.add(services[node]);

            for (int neighbour : adj.get(node)) {

                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        if (order.size() == vertices) {
            System.out.println("Deployment Order (BFS): " + order);
        } else {
            System.out.println("Circular dependency detected!");
        }
    }

    // Topological sorting using DFS
    void topologicalSortDFS() {

        boolean[] visited = new boolean[vertices];
        boolean[] path = new boolean[vertices];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < vertices; i++) {

            if (!visited[i]) {

                if (!dfsSort(i, visited, path, stack)) {
                    System.out.println("Circular dependency detected!");
                    return;
                }
            }
        }

        System.out.print("Deployment Order (DFS): ");

        while (!stack.isEmpty()) {
            System.out.print(services[stack.pop()] + " ");
        }

        System.out.println();
    }

    boolean dfsSort(int node, boolean[] visited,
                    boolean[] path, Stack<Integer> stack) {

        visited[node] = true;
        path[node] = true;

        for (int neighbour : adj.get(node)) {

            if (!visited[neighbour]) {

                if (!dfsSort(neighbour, visited, path, stack)) {
                    return false;
                }

            } else if (path[neighbour]) {
                return false;
            }
        }

        path[node] = false;
        stack.push(node);

        return true;
    }

    public static void main(String[] args) {

        String[] services = {
            "Cart", "Pricing", "Inventory",
            "Shipping", "Payment"
        };

        MicroserviceGraph g = new MicroserviceGraph(services);

        g.addDependency(0, 1);
        g.addDependency(1, 2);
        g.addDependency(2, 3);
        g.addDependency(0, 4);

        g.BFS(0);
        g.startDFS(0);

        g.topologicalSortBFS();
        g.topologicalSortDFS();

        System.out.println("\nChecking circular dependency:");

        g.addDependency(3, 0);

        g.topologicalSortBFS();
    }
}
