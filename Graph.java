import java.util.ArrayList;

public class Graph {
    private ArrayList<Vertex> vertices;
    
    public Graph()
    {
        this.vertices = new ArrayList<Vertex>();
    }

    public Vertex addVertex(String name)
    {
        Vertex newVertex = new Vertex(name);
        this.vertices.add(newVertex);
        return newVertex;
    }

    public void addEdge(Vertex v1, Vertex v2, int weight)
    {
        v1.addEdge(v2, weight);
        v2.addEdge(v1, weight);
    }

    public ArrayList<Vertex> getVertices()
    {
        return this.vertices;
    }
}
