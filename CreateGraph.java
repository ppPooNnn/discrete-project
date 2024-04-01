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
        System.out.println("Please enter the amount of vertices and edges");
        System.out.printf("Vertex : ");
        this.vertices = sc.nextInt();
        System.out.printf("Edge : ");
        this.edges = sc.nextInt();
        sc.nextLine();
        createVertex();
        connectEdge();
    }

    public void createVertex()
    {
        System.out.println("Enter the vertices' name");
        int i = 0;
        while(i < vertices)
        {
            System.out.printf("No.%d : ", i + 1);
            String vertex = sc.nextLine();
            if(graph.getVertices().containsKey(vertex))
            {
                System.out.println("! This vertex already exists !");
                System.out.println("Please re-enter the data");
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
            System.out.printf("Edge "+ (i + 1) +" ");
            System.out.printf("from: ");
            String startv = sc.nextLine();
            while(graph.getVertexByName(startv) == null)
            {
                System.out.println("! This graph does not contain the specified vertex !");
                System.out.println("Please re-enter the data");
                System.out.printf("Edge "+ (i + 1) +" ");
                System.out.printf("from: ");
                startv = sc.nextLine();
            }
            this.startvt = graph.getVertexByName(startv);
            System.out.printf("to: ");
            String endv = sc.nextLine();
            while(graph.getVertexByName(endv) == null)
            {
                System.out.println("! This graph does not contain the specified vertex !");
                System.out.println("Please re-enter the data");
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