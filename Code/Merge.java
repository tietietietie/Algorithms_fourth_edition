public class Merge
{
    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        for(int k = 0; k <= hi; k++)
            aux[k] = a[k];

        int i = lo, j = mid+1;
        for(int k = lo; k <= hi; k++)
        {
            if(i > mid) a[k] = aux[j++];
            else if(j > hi) a[k] = aux[i++];
            else if(less(a[j],a[i])) a[k] = a[j++];
            else a[k] = a[i++];
        }
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) //内部递归实现的merge sort，参数不友好
    {
        if(hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a,aux,lo,mid);
        sort(a,aux,mid+1,hi);
        merge(a,aux,lo,mid,hi);
    }

    public static void sort(Comparable[] a) //公共函数
    {
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0,a.length-1);
    }
}