public class KeyIndexedCounting
{
    public KeyIndexedCounting(int[] a, int R)
    {
        sort(a,R);
    }

    private static void sort(int[] a, int R)
    {
        int N = a.length;
        int[] aux = new int[N];
        int[] count = new int[R+1];

        for(int i = 0; i < N; i++)
            count[a[i]+1]++;
        
        for (int r = 0; r < R; r++) //迭代了R次，对count[R]进行了操作
            count[r+1] += count[r];
        
        for(int i = 0; i < N; i++)
            aux[count[a[i]]++] = a[i];

        for(int i = 0; i < N; i++)
            a[i] = aux[i];
    }
}