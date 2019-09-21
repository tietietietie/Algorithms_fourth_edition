public class MergeBU
{
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int j) {
        assert isSorted(a,lo,mid);
        assert isSorted(a,mid+1,hi);

        for(int k = 0; k < a.length; k++)
            aux[k] = a[k];

        int i = lo, j = mid+1;
        for(int k = 0; k < a.length; k++)
        {
            if(i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(a[j],a[i])) a[k] = a[j++];
            else a[k] = aux[i++];
        }
    }

    public static void sort() {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for(int sz = 1; sz < N; sz += sz)
            for(int lo = 0; lo < N-sz; lo += sz+sz)
                merge(a,aux,lo+sz-1,Math.min(lo+sz+sz-1,N-1));
    }
}