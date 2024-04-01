public class Menu
{
    public void Display()
    {
        System.out.println("------------------------- This is discrete project -------------------------");
        CreateGraph cg;
        Spanning spGraph;
        do
        {
            System.out.println("------------------------- Creating Graph -------------------------");
            cg = new CreateGraph();
            cg.creation();
            spGraph = new Spanning(cg.getGraph());
            if(!spGraph.isConnected())
            {
                System.out.println("\033[H\033[2J");
                System.out.println("!!!!!!!! Your graph is not connected graph !!!!!!!!");
                System.out.println("Please enter graph again");
            }
        }
        while(!spGraph.isConnected());
        System.out.println("Your graph is connected graph");
        Process m = new Process();
        m.run(cg);
    }
}
