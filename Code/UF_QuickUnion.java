public class UF_QuickUnion
{
    private int[] id; //declararion

    public UF_QuickUnion(int n)
    {
        id = new int[n];
        for(int i = 0; i < n; i++)
        {
            id[i] = i;
        }
    }

    private int root(int i)
    {
        while(id[i] != i) i = id[i];
        return i;
    }

    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }

    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        id[i] = j; //let the root of p pointing root of q
    }
}

