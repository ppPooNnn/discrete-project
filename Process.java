public class Process {
    public void run()
    {
        CreateGraph cg = new CreateGraph();
        cg.creation();
        Spanning spGraph = new Spanning(cg.getGraph());
        System.out.println(spGraph.isConnected());
        if(spGraph.isConnected())
        {
            // ShortestPath SP = new ShortestPath(cg.getGraph());
            // SP.run();
            // Prim p = new Prim(cg.getGraph());
            // p.run();
            // Kruskarl k = new Kruskarl(cg.getGraph());
            // k.run();
            Kruskal k = new Kruskal();
            System.out.println(k.kruskalMST(cg.getGraph()));
        }
        else
            System.out.println("Graph is not connect");
    }
}
