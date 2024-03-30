import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
        Map<String, Vertex> vertices = graph.getVertices();
        vertices.values().removeAll(visited);
        if(vertices.size() == 0)
            return true;
        return false;
    }
    

    public void DFS(Vertex start, Set<Vertex> visitedVertices)
    {
        for(Edge e: start.getEdges())
        {
            Vertex neighbor = e.getEnd();
            if(!visitedVertices.contains(neighbor))
            {
                visitedVertices.add(neighbor);
                DFS(neighbor, visitedVertices);
            }
        }
    }

}