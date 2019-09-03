/* *****************************************************************************
 *  Name:Iron zhang
 *  Date:2019.8.31
 *  Description:
 **************************************************************************** */

public class Percolation {
    private int[] site;
    private int[] sz; //store the size at the root of one tree
    private int N;
    private int numberofopensites = 0;

    public Percolation(int n) {
        if (n <= 0)
            throw new java.lang.IllegalArgumentException("n must be more than zero");
        site = new int[n * n + 2];
        sz = new int[n * n + 2];
        sz[0] = N * N + 3;
        site[0] = 0;
        for (int i = 1; i < n * n + 1; i++) {
            site[i] = -1;
        }
        site[n * n + 1] = n * n + 1;
        N = n;
    }

    public int root(int pos) {
        while (site[pos] != pos) {
            site[pos] = site[site[pos]]; //path compression
            pos = site[pos];
        }
        return pos;
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] > sz[j]) {
            site[j] = i;
            sz[i] += sz[j];
        }
        else {
            site[i] = j;
            sz[j] += sz[i];
        }
    }

    public void open(int row, int col) {
        if (row < 1 || row > N || col < 1 || col > N)
            throw new java.lang.IllegalArgumentException(
                    "the values of row and col must between 1 and N");
        int pos = (row - 1) * N + col;
        numberofopensites += 1;
        sz[pos] = 1;
        if (pos < N + 1) union(pos, 0);
        else if (pos < (N - 1) * N + 1) site[pos] = pos;
        else union(pos, N * N + 1);
        int upper, down, left, right;
        if (row > 1 && isOpen(row - 1, col)) {
            upper = (row - 2) * N + col;
            union(pos, upper);
        }
        if (row < N && isOpen(row + 1, col)) {
            down = row * N + col;
            union(pos, down);
        }
        if (col > 1 && isOpen(row, col - 1)) {
            left = (row - 1) * N + col - 1;
            union(pos, left);
        }
        if (col < N && isOpen(row, col + 1)) {
            right = (row - 1) * N + col + 1;
            union(pos, right);
        }

    }

    public boolean isOpen(int row, int col) {
        int pos = (row - 1) * N + col;
        if (site[pos] != -1)
            return true;
        else
            return false;
    }

    public boolean isFull(int row, int col) {
        int pos = (row - 1) * N + col;
        if (!isOpen(row, col))
            return false;
        else if (root(pos) == root(0))
            return true;
        else
            return false;
    }

    public int numberOfOpenSites() {
        return numberofopensites;
    }

    public boolean percolates() {
        if (root(0) == root(N * N + 1))
            return true;
        else
            return false;
    }

    public static void main(String[] args) {

    }
}

//have some bugs: when the system is percolated, any opened site at the last row will be filled.
