public class DirectedDFS
{
    private boolean[] marked;
    private int[] edgeTo;

    public DirectedDFS(Digraph G, int s)
    {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()]; //先声明，然后可在内部函数创建
        dfs(G,s);
    }

    private dfs(Graph G, int v)
    {
        marked[v] = true;
        for(int w = G.adg(v))
            if(!marked[w])
            {
                edgeTo[w] = v;
                dfs(G,w);
            }
    }

    public boolean visited(int v)
    {return marked[v]; }
}