public class LinkedStackOfStrings
{
    private Node first = null;

    private class Node
    {
        String item;
        Node next;  //pointing the next Node
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public void push(string item)
    {
        Node oldfirst = first;
        first = new Node();  //改变first所指向的Node
        first.item = item;
        first.next = oldfirst;
    }

    public String pop()
    {
        String item = first.item;
        first = first.next;
        return first;
    }
}