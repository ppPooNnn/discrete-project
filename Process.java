public class Process {
    public void run()
    {
        CreateGraph cg = new CreateGraph();
        cg.creation();
        Spanning spGraph = new Spanning(cg.getGraph());
        
    }
}
