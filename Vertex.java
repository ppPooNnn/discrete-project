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

    public String getName()
    {
        return this.name;
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

    @Override
    public String toString() {
        return "Vertex [name=" + name + ", edges=" + edges.toString() + ", connctsvt=" + this.getconnctVt() + "]";
    }

    public ArrayList<String>getconnctVt()
    {
        ArrayList<String>conVt = new ArrayList<>();
        for(Vertex vt:connctsvt)
        {
            String Vtname = vt.getName();
            conVt.add(Vtname);
        }
        return conVt;
    }
}
