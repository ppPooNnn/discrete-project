import java.util.Map;
import java.util.Set;

public class Spanning
{
    private Graph graph;

    public Spanning(Graph g)
    {
        this.graph = g;
    }

    public void isConnected()
    {
        Set<String>allvtname = graph.getVertices().keySet();
        Map<String,Vertex>vtwithValue = graph.getVertices();
        
    }
}
