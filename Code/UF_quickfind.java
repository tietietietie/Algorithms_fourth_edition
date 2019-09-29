/*********************************************
* Compilation: javac UF_quickfind.java
* Execution:   java UF_quickfind < input.txt
* Dependencies:StdIn.java StdOut.java
* Datafiles:   None
* 
 */

public class UF_quickfind
{
    private int[] id;

    public UF_quickfind(int n)
    {
        id = new int[n];
        for(int i = 0; i < n; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q)
    {   return id[p] == id[q];  }

    public void uinon(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];
        for(int i = 0; i < id.length; i++)
            if(id[i] == pid) id[i] = qid;
    }
    public static void main(String[] args)
    {
    int N = StdIn.readInt();
    UF_quickfind uf = new UF_quickfind(N);
    while(!Std.isEmpty())
    {
        int p = StdIn.readInt();
        int q = StdIn.readInt();
        if(!uf.connected(p,q))
        {
            uf.uinon(p,q);
            StdOut.println(p + " " + q);
        }
    }
    }
}

