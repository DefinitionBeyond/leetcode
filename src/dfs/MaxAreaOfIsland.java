package dfs;

/**
 * @description:
 * @create: 2022-07-20 11:05
 **/
public class MaxAreaOfIsland {

    int n,m;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        n = grid.length;
        m = grid[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    int cur = dfs(grid, i, j);
                    maxArea = Math.max(cur, maxArea);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int x, int y){
        if(x < 0 || y < 0 || x >= n || y>= m || grid[x][y] != 1){
            return 0;
        }

        //已经遍历过的，标记已经遍历
        grid[x][y] = 0;
        return 1 + dfs(grid, x-1, y)
            + dfs(grid, x+1, y)
            + dfs(grid, x, y-1)
            + dfs(grid, x, y+1);
    }
}
