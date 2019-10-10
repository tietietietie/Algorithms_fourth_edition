public class CC
{
    private boolean[] marked;
    private int[] id;
    private int count;

    public CC(Graph G)
    {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for(int v = 0; v < G>V(); v++)
        {
            if(!marked[v])
            {
                dfs(G,v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int v)
    {
        marked[v] = true; //将与v相连的所有节点mark
        id[v] = count;  //将与V相连的所有节点设置为同一id
        for(int w : G.adj(v))
            if(!marked[w])
                dfs(G,w);
    }

    public int count()
    { return count; }

    public int id(int v)
    { return id[v]; }

    public boolean connected(int v, int w)
    { return id[v] == id[w]; }
}