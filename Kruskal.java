import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal 
{
    public void kruskalMST(Graph graph) {
        ArrayList<Edge> result = new ArrayList<>();
        ArrayList<Edge> edges = graph.getEdgesList();
        
        // Sort edges by weight
        Collections.sort(edges, Comparator.comparingInt(Edge::getWeight));
        
        DisjointSet disjointSet = new DisjointSet();
        for (String vertexName : graph.getVertices().keySet()) {
            disjointSet.makeSet(vertexName);
        }
        
        for (Edge edge : edges) {
            String startName = edge.getStart().getName();
            String endName = edge.getEnd().getName();
            
            // Check if including this edge creates a cycle
            if (!disjointSet.find(startName).equals(disjointSet.find(endName))) {
                disjointSet.union(startName, endName);
                result.add(edge);
            }
        }

        System.out.println("minimum spanning tree using Kruskal's algorithm");
        for(Edge e: result){
            System.out.println(e);
        };
    }
}