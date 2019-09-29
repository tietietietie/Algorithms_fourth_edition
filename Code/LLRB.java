public class LLRB<Key extends Comparable<Key>, Value>
{
    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = true;

    private class Node{
        Key key;
        Value val;
        Node left. right;
        boolean color;
        public Node(Key key, Value val, boolean color)
        {
            this.key = key;
            this.val = val;
            this.color = color;
        }
    }

    private boolean isRed(Node x)
    {
        if(x == null) return false;
        return x.color == RED;
    }

    private Node rotateLeft(Node h)
    {
        assert isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private Node rotateRight(Node h)
    {
        assert isRed(h.left);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColor(Node h)
    {
        assert !isRed(h);
        assert isRed(h.left);
        assert isRed(h.right);
        h.color = RED;
        h.right.color = BLACK;
        h.left.colot = BLACK;
    }

    public void put(Key key, Value val)
    {
        root = put(root, key, value);
    }

    private 
}