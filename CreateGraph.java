import java.util.Scanner;

public class CreateGraph {
    private int vertices;
    private int edges;
    private Graph graph;
    private Vertex startvt;
    private Vertex endvt;


    public void run()
    {
        System.out.println("Please enter number of vertices and edges");
        Scanner sc = new Scanner(System.in);
        System.out.printf("Vertex : ");
        this.vertices = sc.nextInt();
        System.out.printf("\nEdges : ");
        this.edges = sc.nextInt();
        create();
    }

    public void create()
    {
        for(int i = 0;i<edges;i++)
        {
            Scanner sc = new Scanner(System.in);
            System.out.printf("Edges"+i+" ");
            System.out.printf("from:");
            String startv = sc.nextLine();
            this.startvt = graph.addVertex(startv);
            System.out.printf(" , to:");
            String endv = sc.nextLine();
            this.endvt = graph.addVertex(endv);
            System.out.printf("| with weight:");
            int w = sc.nextInt();
            graph.addEdge(startvt, endvt, w);
        }
    }
}
