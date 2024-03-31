import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;

public class Prim {
    private Vertex startVt;
    private Graph graph;
    private ArrayList<Edge>mst;
    private ArrayList<Vertex>alrdyexplo;
    private int totalVertices;
    private ArrayList<Edge>allconnctedge;
    public Prim(Graph g)
    {
        this.graph = g;
        this.startVt = graph.getStartVt();
        this.mst = new ArrayList<Edge>();
        this.alrdyexplo = new ArrayList<Vertex>();
        this.totalVertices = graph.gettotalVertices();
        this.allconnctedge = new ArrayList<Edge>();
    }
    
    public void run()
    {
        findmstpath();
        printmst();
    }

    public void findmstpath()
    {
        Vertex currVt = this.startVt;
        this.alrdyexplo.add(currVt);
        ArrayList<Edge>currconnctEdge;
        while (alrdyexplo.size()!=totalVertices) {
            Edge shrtEdge;
            Vertex dest;
            currconnctEdge = currVt.getEdges();
            currconnctEdge.forEach(m->this.allconnctedge.add(m));
            shrtEdge = allconnctedge.stream().filter(m->(((!alrdyexplo.contains(m.getEnd())))||(!alrdyexplo.contains(m.getStart())))
            &&!mst.contains(m)).min(Comparator.comparing(Edge::getWeight)).get();
            dest = shrtEdge.getEnd();
            alrdyexplo.add(dest);
            currVt = dest;
            this.mst.add(shrtEdge);
        }
    }
    public void printmst(){
        System.out.println("minimum spanning tree using prim's algorithm");
        this.mst.forEach(System.out::println);
    }

}