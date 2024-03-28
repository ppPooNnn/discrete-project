import java.util.ArrayList;
import java.util.Scanner;

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
            graph.addEdge(startvt, endvt, w);
        }
    }

    public void isConnected(Graph graph)
    {
        ArrayList<Vertex> CheckVertices = new ArrayList<>();
        System.out.println(graph.getVertices().values());
    }
}
