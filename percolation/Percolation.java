/* *****************************************************************************
 *  Name:zhangtie
 *  Date:2019.8.30
 *  Description:Finish the class <Percolation>
 **************************************************************************** */

public class Percolation {
    public Percolation(int n) {
        if (n <= 0) throw new java.lang.IllegalArgumentException("n must be more than zero");
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            row[i] = i + 1;
            col[i] = i + 1;
        }
    }

    public static void main(String[] args) {

    }
}
