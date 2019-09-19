public class FixedArrayStack<Item>
{
    private Item[] s;
    private int N = 0;

    public FixedArrayStack(int capacity)
    {
        s = (Item) new Object[capacity];  //不能new一个泛型数组
    }

    public boolean isEmpty()
    { return N == 0; }

    public void push(Item item)
    { s[N++] = item; }

    public Item pop()
    { return s[--N]; }
}

//在创建stack的时候规定stack数据类型