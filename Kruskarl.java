import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Kruskarl {
    private Graph graph;
    private List<Edge>mst;
    private ArrayList<Edge>sortedEdge;
    private ArrayList<Edge> spanningList = new ArrayList<>();
    ArrayList<Vertex>alrdyexplo;
    public Kruskarl(Graph g)
    {
        this.graph = g;
        this.mst = new ArrayList<Edge>();
        alrdyexplo = new ArrayList<Vertex>();
        this.sortedEdge = g.getEdgesList();
    }
    public void run()
    {
        findmst();
        printmst();
    }
    public void findmst()
    {
        sortedEdge.stream().sorted(Comparator.comparing(Edge::getWeight)).collect(Collectors.toList());
        Set<Vertex> visited = new HashSet<>();
        visited.add(sortedEdge.get(0).getStart());
        System.out.println("this is sorted edge " + sortedEdge);
        Vertex start = sortedEdge.get(0).getStart();
        DFS(start, visited);
    }
    // public boolean iscycle(Edge e)
    // {   
    //     Vertex start = e.getStart();
    //     Vertex end = e.getEnd();
    //     for(Edge tv:mst)
    //     {
    //         Vertex currst = tv.getStart();
    //         Vertex currend = tv.getEnd();
    //         if (start.equals(currst)&&end.equals(currend)) {
    //             return true;
    //         }
    //         else if (end.equals(currst)&&start.equals(currend)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }
    public void printmst()
    {
        System.out.println("minimum spanning tree using Kruskarl's algorithm");
        spanningList.forEach(System.out::println);
    }

    public void DFS(Vertex start, Set<Vertex> visitedVertices)
    {
        for(Edge e: sortedEdge)
        {
            Vertex neighbor;
            if(e.getEnd().equals(start))
                neighbor = e.getStart();
            else
                neighbor = e.getEnd();

            if(!visitedVertices.contains(neighbor))
            {
                visitedVertices.add(neighbor);
                spanningList.add(e);
                // DFS(neighbor, visitedVertices);
            }
        }
    }
}
