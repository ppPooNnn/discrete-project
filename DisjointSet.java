import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private Map<String, String> parent;

    public DisjointSet() {
        parent = new HashMap<>();
    }

    // Create a set with only one element
    public void makeSet(String v) {
        parent.put(v, v);
    }

    // Find the root of the set to which v belongs
    public String find(String v) {
        if (!parent.get(v).equals(v)) {
            // Recursively find the root and perform path compression
            parent.put(v, find(parent.get(v)));
        }
        return parent.get(v);
    }

    // Merge two sets into one
    public void union(String a, String b) {
        String rootA = find(a);
        String rootB = find(b);
        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
        }
    }
}