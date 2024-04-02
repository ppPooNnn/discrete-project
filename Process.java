import java.util.Scanner;

public class Process
{
    private Scanner sc = new Scanner(System.in);
    public void run(CreateGraph g)
    {
        int process;
        do
        {
            System.out.println("----------------------- Select Algorithm -----------------------");
            System.out.println("1. Find minimum spanning tree using Prim's algorithm");
            System.out.println("2. Find minimum spanning tree using Kruskal's algorithm");
            System.out.println("3. Find shortest path from one vertex to another using Dijkstra's algorithm");
            System.out.println("4. Exit");
            System.out.printf("Your input : ");
            process = sc.nextInt();
            switch (process) 
            {
                case 1:
                    System.out.println("\n\n----------- Find minimum spanning tree using Prim's algorithm -----------");
                    Prim p = new Prim(g.getGraph());
                    p.run();
                    System.out.println("\n\n");
                    break;

                case 2:
                    System.out.println("\n\n----------- Find minimum spanning tree using Kruskal's algorithm -----------");
                    Kruskal k = new Kruskal();
                    k.kruskalMST(g.getGraph());
                    System.out.println("\n\n");
                    break;

                case 3:
                    System.out.println("\n\n----------- Find shortest path from one point to another point using Dijkstra's algorithm -----------");
                    ShortestPath SP = new ShortestPath(g.getGraph());
                    SP.run();
                    System.out.println("\n\n");
                    break;

                case 4:
                    break;

                default:
                    System.out.println("\n\nPlease input a number between 1 and 4");
                    System.out.println("\n\n");
                    break;
            }
        }
        while(process != 4);
        if(process == 4)
        {
            System.out.println("---------------------------- Exit ----------------------------");
            return;
        }
    }
}
