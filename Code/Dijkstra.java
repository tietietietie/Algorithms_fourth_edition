public class DijkstraSP
{
    private DirectedEdge[] edgeTo;
    private double[] distTo;
    private IndexMinPQ<Double> pq;

    public DijkstraSP(WeightedEdge G, int s)
    {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPQ<Double>(G.V());

        for(int v = 0; v < G.V(); v++)
            distTo[v] = Double.POSITIVE_INFINITY;
        distTo[s] = 0.0;

        pq.insert(s, 0.0);
        while(!pq.isEmpty())
        {
            int v = pq.delMin();
            for(DirectedEdge e : adj[v])
                relax(e);
        }
    }

    private void relax(Directed e)
    {
        int v = e.from(), w = e.to();
        if(distTo[w] > distTo[v] + e.weight())
        {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
            if(pq.contains(w)) pq.decrease(w, distTo[w]);
            else               pq.insert(w, distTo[w]);
        }
    }

    public double distTo(int v)
    {
        return distTo[v];
    }

    public Interable<DirectedEdge> pathTo(int v)
    {
        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for(DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);
        return path;
    }
}