package dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @create: 2022-07-20 11:24
 **/
public class NumIslands {

    int n,m;
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;

        int index = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == (char) (49)) {
                    dfs(grid, i, j);
                    index++ ;
                }
            }
        }
        return  index;
    }

    private int dfs(char[][] grid, int i, int j) {
        if(i<0 || j<0 || i>= n || j>=m || grid[i][j] != (char)49){
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(grid, i - 1, j)
            + dfs(grid, i + 1, j)
            + dfs(grid, i, j - 1)
            + dfs(grid, i, j + 1)
            ;
    }


    public static void main(String[] args) {
        
        char[][] grid = new char[][]{
            {'1','1','1','1','0'},
        {'1','1','0','1','0'},
            {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        new NumIslands().numIslands(grid);
    }
}
