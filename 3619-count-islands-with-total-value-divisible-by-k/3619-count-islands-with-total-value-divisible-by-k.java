class Solution {
    public int countIslands(int[][] grid, int k) {
        int ans = 0;
        int n = grid.length, m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 0) {
                    long[] sum = {0};
                    f(i, j, n, m, sum, grid);
                    if (sum[0] % k == 0) ans++;
                }
            }
        }
        return ans;
    }

    void f(int i, int j, int n, int m, long[] sum, int[][] grid) {
        sum[0] += grid[i][j];
        grid[i][j] = 0;

        if (i > 0 && grid[i - 1][j] != 0)
            f(i - 1, j, n, m, sum, grid);

        if (j > 0 && grid[i][j - 1] != 0)
            f(i, j - 1, n, m, sum, grid);

        if (i + 1 < n && grid[i + 1][j] != 0)
            f(i + 1, j, n, m, sum, grid);

        if (j + 1 < m && grid[i][j + 1] != 0)
            f(i, j + 1, n, m, sum, grid);
    }
}