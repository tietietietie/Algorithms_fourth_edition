public class ResizingArrayQueueOfStrings
{
    private int head, tail;
    private String[] a;

    public ResizingArrayQueueOfStrings()
    {
        a = new String[1];
        head =0;
        tail = 0;
    }

    private void resize(int i)
    {
        String[] copy = new String[i];
        int length = head - tail +1;
        int start = i - (head + tail) / 2;
        for (int j = head; j < tail; j++)
            copy[start++] = a[j];
        a = copy;
    }

    public void enqueue(String item)
    {
        if(tail == a.length) resize(2*a.length);
        a[tail++] = item;
    }

    public String dequeue()
    {
        if(tail - head + 1 < a.length/4) resize(a.length/2);
        String item = a[head++];
        a[head-1] = null;
        return item;
    }
}