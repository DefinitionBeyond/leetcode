package dp;

/**
 * @description:
 * @create: 2022-06-10 15:49
 **/
public class MaxValue {


    public int maxValue(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int[][] dp = new int[r][c];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < c; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
        }

        for (int j = 1; j < r; j++) {
            dp[j][0] = grid[j][0] + dp[j - 1][0];
        }

        for (int i = 1; i < r; i++) {
            for (int j = 1; j < c; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[r - 1][c - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {1, 2, 5},
            {3, 2, 1}
        };

        System.out.println(new MaxValue().maxValue(grid));
    }

}
