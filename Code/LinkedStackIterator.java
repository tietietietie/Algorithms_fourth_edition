import java.util.Iterator;

public class Stack<Item> implements Iterable<Item>
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

    public Iterator<Item> iterator() { return new ListIterator(); }

    private class ListIterator implements Iterator<ListIterator>
    {
        private Node current = first;

        public boolean hasNext() { return current != null; }
        public void remove()     { /* not supported */ }
        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}