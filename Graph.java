import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Graph {
    // private ArrayList<Vertex> vertices;
    private Map<String,Vertex> vertices;
    private ArrayList<Edge> edgeList;
    private Vertex stratVt;
    public Graph()
    {
        // this.vertices = new ArrayList<Vertex>();
        this.vertices = new HashMap<String,Vertex>();
        this.edgeList = new ArrayList<>();
    }

    public void addVertex(String name)
    {
            Vertex currVertex;
        if (this.stratVt!=null) 
        {
            if (!vertices.containsKey(name)) {
                currVertex = new Vertex(name);
                this.vertices.put(name, currVertex);
                // return currVertex;
            }
            else{
                currVertex = vertices.get(name);
                // return currVertex;
            }
        }
        else{
            currVertex = new Vertex(name);
            this.stratVt = currVertex;
            this.vertices.put(name, currVertex);
        }
    }

    public Vertex getVertexByName(String name)
    {
        return vertices.get(name);
    }

    public void addEdge(Vertex v1, Vertex v2, int weight,String en)
    {
        Edge currEdge = new Edge(v1, v2, weight,en);
        v1.addEdge(v2, weight,currEdge);
        v2.addEdge(v1, weight,currEdge);
        edgeList.add(currEdge);
    }

    public Map<String,Vertex> getVertices()
    {
        return this.vertices;
    }

    public Vertex getStartVt()
    {
        return this.stratVt;
    }

    public ArrayList<Edge> getEdgesList()
    {
        return this.edgeList;
    }
    // public ArrayList<Vertex> getVertices()
    // {
    //     return this.vertices;
    // }
}
