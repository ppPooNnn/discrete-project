import java.util.Scanner;

public class Menu
{
    private Scanner sc = new Scanner(System.in);
    public void Display()
    {
        int type;
        System.out.println("----------------- Discrete Mathematics Project -----------------");
        System.out.println("------------------------- Select Type -------------------------");
        System.out.println("1. Create Graph");
        System.out.println("2. Finite State Automata (From Slide 19)");
        System.out.print("Your input : ");
        type = sc.nextInt();
        while(type>2 || type<1){
            System.out.println("Please input a number between 1 and 2");
            System.out.print("Your input : ");
            type = sc.nextInt();
        }

        if(type==1){
            CreateGraph cg;
            Spanning spGraph;
            do
            {
                System.out.println("------------------------ Creating Graph ------------------------");
                cg = new CreateGraph();
                cg.creation();
                spGraph = new Spanning(cg.getGraph());
                if(!spGraph.isConnected())
                {
                    System.out.println("\033[H\033[2J");
                    System.out.println("! This graph is not a connected graph !");
                    System.out.println("Please re-enter the graph's data");
                }
            }
            while(!spGraph.isConnected());
            System.out.println("This graph is a connected graph");
            Process m = new Process();
            m.run(cg);
        }
        else if(type==2){
            System.out.println("-------------------- Finite State Automata --------------------");
            CreateAutomaton ca =  new CreateAutomaton();
            ca.runSlide19();
        }
    }
}
