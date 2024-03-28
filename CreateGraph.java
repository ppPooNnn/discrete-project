import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class CreateGraph {
    private int vertices;
    private int edges;
    private Graph graph;
    private Vertex startvt;
    private Vertex endvt;
    private Scanner sc = new Scanner(System.in);

    public void run()
    {
        System.out.println("Please enter number of vertices and edges");
        System.out.printf("Vertex : ");
        this.vertices = sc.nextInt();
        System.out.printf("Edges : ");
        this.edges = sc.nextInt();
        create();
        isConnected(graph);
    }

    public void create()
    {
        this.graph = new Graph();
        for(int i = 0;i<edges;i++)
        {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Edges "+ i +" ");
            System.out.printf("from: ");
            String startv = sc.nextLine();
            this.startvt = graph.addVertex(startv);
            System.out.printf("to: ");
            String endv = sc.nextLine();
            this.endvt = graph.addVertex(endv);
            System.out.printf("with weight: ");
            int w = sc.nextInt();
            graph.addEdge(startvt, endvt, w,"e"+i);
        }
    }

    public void isConnected(Graph graph)
    {  
        Set<String>allvtname = graph.getVertices().keySet();
        Map<String,Vertex>vtwithValue = graph.getVertices();
        for(String vtname:allvtname)
        {
            Vertex currVt = vtwithValue.get(vtname);
            System.out.println(currVt);
        }
    }
}
