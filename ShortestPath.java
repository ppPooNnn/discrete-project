import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ShortestPath
{
    private Graph graph;
    private Vertex start;
    private Vertex end;
    private Scanner sc = new Scanner(System.in);

    public ShortestPath(Graph g)
    {
        this.graph = g;
    }

    public void run()
    {
        Display();
        Dijkstra();
    }

    public void Display()
    {
        System.out.print("Please enter the start vertex : ");
        String strStart = sc.nextLine();
        this.start = graph.getVertexByName(strStart);
        System.out.print("Please enter the destination vertex : ");
        String strEnd = sc.nextLine();
        this.end = graph.getVertexByName(strEnd);
    }

    private class QueueObject implements Comparable<QueueObject>
    {
        Vertex v;
        int w;

        public QueueObject(Vertex v, Integer w)
        {
            this.v = v;
            this.w = w;
        }

        public int compareTo(QueueObject other)
        {
            return Integer.compare(this.w, other.w);
        }
    }

    public void Dijkstra()
    {

        Dictionary<String, Integer> distances = new Hashtable<>();
        Dictionary<String, Vertex> previous = new Hashtable<>();
        PriorityQueue<QueueObject> queue = new PriorityQueue<QueueObject>();

        distances.put(start.getName(), 0);
        queue.add(new QueueObject(start, 0));

        for (Vertex v : graph.getVertices().values())
        {
            if(v != start)
                distances.put(v.getName(), Integer.MAX_VALUE);
            previous.put(v.getName(), new Vertex("null"));
        }
        while (!queue.isEmpty())
        {
            Vertex current = queue.poll().v;
            if(current == end)
                break;
            for(Edge e : current.getEdges())
            {
                Integer alternate = distances.get(current.getName()) + e.getWeight();
                String neighbor = e.getEnd().getName();
                if(alternate < distances.get(neighbor))
                {
                    distances.put(neighbor, alternate);
                    previous.put(neighbor, current);
                    queue.add(new QueueObject(e.getEnd(), distances.get(neighbor)));
                }
            }
        }
        output(previous);
    }

    public void output(Dictionary<String, Vertex> previous)
    {
        ArrayList<Edge> shortestPathEdges = new ArrayList<>();
        final Vertex[] currentVertex = new Vertex[1];

        currentVertex[0] = end;

        while (previous.get(currentVertex[0].getName()) != null) {
            Vertex previousVertex = previous.get(currentVertex[0].getName());
            Edge edge = previousVertex.getEdges().stream()
                                            .filter(e -> e.getEnd() == currentVertex[0])
                                            .findFirst().orElse(null);
            if (edge != null) {
                shortestPathEdges.add(edge);
                currentVertex[0] = previousVertex;
            }
            else
                break;
        }

        System.out.println("Shortest Path Graph:");
        for (int i = shortestPathEdges.size() - 1; i >= 0; i--) {
            Edge edge = shortestPathEdges.get(i);
            System.out.println(edge);
        }
    }
}
