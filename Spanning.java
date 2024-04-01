import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Spanning
{
    private Graph graph;

    public Spanning(Graph g)
    {
        this.graph = g;
    }

    public boolean isConnected()
    {
        Set<Vertex> visited = new HashSet<>();
        visited.add(graph.getStartVt());
        DFS(graph.getStartVt(), visited);
        Map<String, Vertex> vertices = new HashMap<>();
        for(Map.Entry<String, Vertex> entry : graph.getVertices().entrySet())
            vertices.put(entry.getKey(), entry.getValue());
        // graph.getVertices();
        vertices.values().removeAll(visited);
        if(vertices.size() == 0)
            return true;
        return false;
    }
    

    public void DFS(Vertex start, Set<Vertex> visitedVertices)
    {
        for(Edge e: start.getEdges())
        {
            Vertex neighbor;
            if(e.getEnd().equals(start))
                neighbor = e.getStart();
            else
                neighbor = e.getEnd();

            if(!visitedVertices.contains(neighbor))
            {
                visitedVertices.add(neighbor);
                DFS(neighbor, visitedVertices);
            }
        }
    }

}