import java.util.Map;
import java.util.Scanner;

public class CreateGraph {
    private int vertices;
    private int edges;
    private Graph graph;
    private Vertex startvt;
    private Vertex endvt;
    private Scanner sc = new Scanner(System.in);

    public void creation()
    {
        this.graph = new Graph();
        System.out.println("Please enter number of vertices and edges");
        System.out.printf("Vertex : ");
        this.vertices = sc.nextInt();
        System.out.printf("Edges : ");
        this.edges = sc.nextInt();
        sc.nextLine();
        createVertex();
        connectEdge();
    }

    public void createVertex()
    {
        System.out.println("Please enter vertices name");
        for(int i = 0; i < vertices; i++)
        {
            System.out.printf("No.%d : ", i + 1);
            graph.addVertex(sc.nextLine());
        }
    }

    public void connectEdge()
    {
        for(int i = 0;i<edges;i++)
        {
            System.out.printf("Edges "+ i +" ");
            System.out.printf("from: ");
            String startv = sc.nextLine();
            this.startvt = graph.getVertexByName(startv);
            System.out.printf("to: ");
            String endv = sc.nextLine();
            this.endvt = graph.getVertexByName(endv);
            System.out.printf("with weight: ");
            int w = sc.nextInt();
            sc.nextLine();
            graph.addEdge(startvt, endvt, w,"e"+i);
        }
    }

    public Graph getGraph()
    {
        return this.graph;
    }
}