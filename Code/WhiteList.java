import java.util.Set;

public class WhiteList
{
    public static void main(String[] args)
    {
        Set<String> set = new SET<String>();

        In in = new In(args[0]);
        while(!in.isEmpty())
            set.add(in.readString());

        while(!StdIn.isEmpty())
        {
            String word = StdIn.readString();
            if(set.contains(word))
                StdOut.println(word);x
        }
    }    