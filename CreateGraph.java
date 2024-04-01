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
        int i = 0;
        while(i < vertices)
        {
            System.out.printf("No.%d : ", i + 1);
            String vertex = sc.nextLine();
            if(graph.getVertices().containsKey(vertex))
            {
                System.out.println("This vertex is already add !!!");
                System.out.println("Please try agian");
                continue;
            }
            graph.addVertex(vertex);
            i++;
        }
    }

    public void connectEdge()
    {
        for(int i = 0;i<edges;i++)
        {
            System.out.printf("Edges "+ (i + 1) +" ");
            System.out.printf("from: ");
            String startv = sc.nextLine();
            while(graph.getVertexByName(startv) == null)
            {
                System.out.println("This graph is not contain this vertex!!!!");
                System.out.println("Please try again");
                System.out.printf("Edges "+ (i + 1) +" ");
                System.out.printf("from: ");
                startv = sc.nextLine();
            }
            this.startvt = graph.getVertexByName(startv);
            System.out.printf("to: ");
            String endv = sc.nextLine();
            while(graph.getVertexByName(endv) == null)
            {
                System.out.println("This graph is not contain this vertex!!!!");
                System.out.println("Please try again");
                System.out.printf("to: ");
                endv = sc.nextLine();
            }
            this.endvt = graph.getVertexByName(endv);
            System.out.printf("with weight: ");
            int w = sc.nextInt();
            sc.nextLine();
            graph.addEdge(startvt, endvt, w,"e" + (i + 1));
        }
    }

    public Graph getGraph()
    {
        return this.graph;
    }
}