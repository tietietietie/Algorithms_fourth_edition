public class DepthFirstOrder
{
    private boolean[] marked;
    private Stack<Integer> reversePostorder;

    public DepthFirstOrder(Digraph G)
    {
        reversePostorder = new Stack<Integer>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G>V(); v++)
            if(!marked[v]) dfs(G,v);
    }

    private void dfs(Digraph G, int v)
    {
        marked[v] = true;
        for (int w : G.adj(v))
            if(!marked[w]) dfs(G,w);
        reversePostorder.push(v);
    }

    public Iterable<Integer> reversePostorder()
    { return reversePostorder; }
}

// private void dfs(Graph G, int v)
// {
//     marked[v] = true;
//     preorder.enqueue(v);
//     for (int w : G.adj(v))
//         if(!marked[w]) dfs(G,w);
//     preorder.enqueue(v);
//     reversePostorder.push(v);
// }