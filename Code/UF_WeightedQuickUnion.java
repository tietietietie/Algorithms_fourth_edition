/* goal:avoid tall tree */

public class UF_WeightedQuickUnion
{
    private int[] id;
    private int[] sz;  //store the size of tree

    private int root(int i)
    {
        while(id[i] != i){
            id[i] = id[id[i]]; //path compression
            i = id[i];
        }
        return i;
    }

    public boolean connected(int p,int q)
    {
        return root(p) == root(q);
    }

    public void union(int p, int q)
    {
        int i = root[p];
        int j = root[q];
        if(i == j) return;
        if(sz[i] > sz[j]){ id[j] = i; sz[i] += sz[j]; }
        else             { id[i] = j; sz[j] += sz[i]; }
    }
}