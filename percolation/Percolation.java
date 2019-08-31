/* *****************************************************************************
 *  Name:Iron zhang
 *  Date:2019.8.31
 *  Description:
 **************************************************************************** */

public class Percolation {
    private int[] site;
    private int n;

    public Percolation(int n) {
        if (n <= 0)
            throw new java.lang.IllegalArgumentException("n must be more than zero");
        site = new int[n * n + 2];
        site[0] = 1;
        site[n * n + 1] = n * n + 1;
        for (int i = 1; i < n + 1; i++) {
            site[i] = 0;
        }
        for (int i = (n - 2) * n + 1; i < (n - 1) * n + 1; i++) {
            site[i] = i;
        }
        for (int i = (n - 1); i < n * n + 1; i++) {
            site[i] = n * n + 1;
        }
    }

    public void open(int row, int col) {
        int pos = (row - 1) + 1;
        if (pos < n + 1) ;

    }

    public static void main(String[] args) {

    }
}
