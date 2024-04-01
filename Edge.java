public class Edge {
    private Vertex start;
    private Vertex end;
    private int weight;
    private String name;

    public Edge(Vertex start, Vertex end, int weight,String n)
    {
        this.start = start;
        this.end = end;
        this.weight = weight;
        this.name = n;
    }

    public Vertex getStart()
    {
        return this.start;
    }

    public Vertex getEnd()
    {
        return this.end;
    }
    
    public int getWeight()
    {
        return this.weight;
    }
    // @Override
    // public String toString()
    // {
    //     return "Connected from :"+this.start.getName()+" to:"+this.end.getName();
    // }

    @Override
    public String toString()
    {
        return this.name + " " + this.start.getName() + "," + this.end.getName() + " weight : " + this.weight;
    }
}
