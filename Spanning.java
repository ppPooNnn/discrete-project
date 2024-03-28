import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Spanning
{
    private Graph graph;

    public Spanning(Graph g)
    {
        this.graph = g;
    }

    public void isConnected()
    {
        Map<String,Vertex>vtwithValue = graph.getVertices();
        Map<String,Integer> checkMap = new HashMap<>();
        for(Map.Entry<String, Vertex> entry : vtwithValue.entrySet())
        {
            checkMap.put(entry.getKey(), 0);
        }

        System.out.println(vtwithValue);
        System.out.println("-----------check map--------------------");
        System.out.println(checkMap);

        Vertex currVertex = vtwithValue.entrySet().iterator().next().getValue();
        ArrayList<Vertex> nextVertex = currVertex.getListConnectVt();

        while(nextVertex.size() != 0)
        {
            if(checkMap.get(currVertex.getName()) == 1)
            {
                currVertex = nextVertex.get(0);
                nextVertex = currVertex.getListConnectVt();
                // System.out.println("check if");
                continue;
            }
                
            // Vertex currVertex = vtwithValue.get(entry.getKey());
            ArrayList<Edge> eList = currVertex.getEdges();
            for(Edge e : eList)
            {
                if(checkMap.containsKey(e.getEnd().getName()) && checkMap.containsKey(e.getStart().getName()))
                    checkMap.put(e.getStart().getName(), 1); checkMap.put(e.getEnd().getName(), 1);
            }
            currVertex = nextVertex.get(0);
            nextVertex = currVertex.getListConnectVt();
        }
        System.out.println("-----------check map--------------------");
        System.out.println(checkMap);
    }
}
