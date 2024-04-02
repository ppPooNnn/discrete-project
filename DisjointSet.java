import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    private Map<String, String> parent;

    public DisjointSet() {
        parent = new HashMap<>();
    }

    public void makeSet(String v) {
        parent.put(v, v);
    }

    public String find(String v) {
        if (!parent.get(v).equals(v)) {
            parent.put(v, find(parent.get(v)));
        }
        return parent.get(v);
    }

    public void union(String a, String b) {
        String rootA = find(a);
        String rootB = find(b);
        if (!rootA.equals(rootB)) {
            parent.put(rootA, rootB);
        }
    }
}