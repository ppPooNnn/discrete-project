import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    // private ArrayList<Vertex> vertices;
    private Map<String,Vertex>vertices;
    private ArrayList<Edge> edgeList;

    public Graph()
    {
        // this.vertices = new ArrayList<Vertex>();
        this.vertices = new HashMap<String,Vertex>();
        this.edgeList = new ArrayList<>();
    }

    public Vertex addVertex(String name)
    {
        Vertex currVertex;
        if (!vertices.containsKey(name)) {
             currVertex = new Vertex(name);
            // this.vertices.add(newVertex);
            this.vertices.put(name, currVertex);
            return currVertex;
        }
        else{
            currVertex = vertices.get(name);
            return currVertex;
        }
    }

    public void addEdge(Vertex v1, Vertex v2, int weight)
    {
        Edge currEdge = new Edge(v1, v2, weight);
        v1.addEdge(v2, weight,currEdge);
        v2.addEdge(v1, weight,currEdge);
    }

    public Map<String,Vertex> getVertices()
    {
        return this.vertices;
    }

    // public ArrayList<Vertex> getVertices()
    // {
    //     return this.vertices;
    // }
}
