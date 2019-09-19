public class Stack<Item>
{
    private Node first = null;

    private class Node
    {
        Item item; //不需要private
        Node next;
    }

    public boolean isEmpty()
    { return first == null; }

    public void push(Item item)
    {
        Node oldfirst = first; //指向同一个对象？？
        first = new Node();
        oldfirst.next = first;
        first.item = item;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        first.next = null;
        return item;
    }
}