import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Kruskarl {
    private Graph graph;
    private List<Edge>mst;
    private ArrayList<Edge>sortedEdge;
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
        for(Edge e:sortedEdge)
        {
            if (!iscycle(e)) {
                mst.add(e);
            }
        }
    }
    public boolean iscycle(Edge e)
    {   
        Vertex start = e.getStart();
        Vertex end = e.getEnd();
        for(Edge tv:mst)
        {
            Vertex currst = tv.getStart();
            Vertex currend = tv.getEnd();
            if (start.equals(currst)&&end.equals(currend)) {
                return true;
            }
            else if (end.equals(currst)&&start.equals(currend)) {
                return true;
            }
        }
        return false;
    }
    public void printmst()
    {
        System.out.println("minimum spanning tree using Kruskarl's algorithm");
        mst.forEach(System.out::println);
    }
}
