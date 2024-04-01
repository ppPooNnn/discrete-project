import java.util.Scanner;

public class Process
{
    private Scanner sc = new Scanner(System.in);
    public void run(CreateGraph g)
    {
        int process;
        do
        {
            System.out.println("------------------------- Please select what do you want to do -------------------------");
            System.out.println("1. Find minimum spanning tree using Prim's algorithm");
            System.out.println("2. Find minimum spanning tree using Kruskal's algorithm");
            System.out.println("3. Find shortest path from one point to another point using Dijkstra's algorithm");
            System.out.println("4. Find if you state is accept or reject");
            System.out.println("5. Exit");
            System.out.printf("Your input : ");
            process = sc.nextInt();
            switch (process) 
            {
                case 1:
                    System.out.println("\n\n-----------Find minimum spanning tree using Prim's algorithm-----------");
                    Prim p = new Prim(g.getGraph());
                    p.run();
                    System.out.println("\n\n");
                    break;

                case 2:
                    System.out.println("\n\n-----------Find minimum spanning tree using Kruskal's algorithm-----------");
                    Kruskal k = new Kruskal();
                    k.kruskalMST(g.getGraph());
                    System.out.println("\n\n");
                    break;

                case 3:
                    System.out.println("\n\n-----------Find shortest path from one point to another point using Dijkstra's algorithm-----------");
                    ShortestPath SP = new ShortestPath(g.getGraph());
                    SP.run();
                    System.out.println("\n\n");
                    break;

                case 4:
                    System.out.println("\n\n-----------Find if you state is accept or reject-----------");
                    CreateAutomaton ca = new CreateAutomaton();
                    ca.runSlide19();
                    System.out.println("\n\n");
                    break;
            
                default:
                    System.out.println("\n\nPlease enter number 1 - 5");
                    System.out.println("\n\n");
                    break;
            }
        }
        while(process != 5);
        if(process == 5)
        {
            System.out.println("------------------------- Exit -------------------------");
            return;
        }
    }
}
