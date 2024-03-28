import java.util.ArrayList;

public class Vertex {
    private String name;
    private ArrayList<Edge> edges;
    private ArrayList<Vertex>connctsvt;

    public Vertex(String input)
    {
        this.name = input;
        this.edges = new ArrayList<Edge>();
        this.connctsvt = new ArrayList<Vertex>();
    }

    // public void addEdge(Vertex conctVertex, Integer weight)
    // {
    //     this.edges.add(new Edge(this, conctVertex, weight));
    // }

    public void addEdge(Vertex conctVertex, Integer weight,Edge e)
    {
        this.edges.add(e);
        this.connctsvt.add(conctVertex);
    }

    public ArrayList<Edge> getEdges()
    {
        return this.edges;
    }
}
