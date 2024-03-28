import java.util.ArrayList;

public class Vertex {
    private String name;
    private ArrayList<Edge> edges;

    public Vertex(String input)
    {
        this.name = input;
        this.edges = new ArrayList<Edge>();
    }

    public void addEdge(Vertex endVertex, Integer weight)
    {
        this.edges.add(new Edge(this, endVertex, weight));
    }

    public ArrayList<Edge> getEdges()
    {
        return this.edges;
    }
}
