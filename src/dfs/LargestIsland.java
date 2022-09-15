package dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description:
 * @create: 2022-07-20 00:47
 **/
public class LargestIsland {

    public int largestIsland(int[][] grid) {

        Map<Integer, Integer> map = new HashMap<>();
        int index = 2;

        int maxArea =0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){

                if(grid[i][j] == 1){
                    int i1 = areaDfs(grid, i, j, index);
                    maxArea = Math.max(i1, maxArea);
                    map.put(index, i1);
                    index++;
                }
            }
        }

        int plusRes = 0;
        for (int x = 0; x< grid.length; x++){
            for (int y=0; y<grid[0].length; y++){
                //如果是0（海洋）
                if( grid[x][y] == 0 ){
                    int plusArea = plusArea(grid, x, y, map);
                    plusRes = Math.max(plusArea, plusRes);
                }
            }
        }
        //可能都没有海洋，全是陆地，则再次判断，直接返回陆地最大值
        plusRes = Math.max(maxArea, plusRes);
        return plusRes;

    }

    private int plusArea(int[][] grid, int x, int y, Map<Integer, Integer> map) {
        if(!isArea(grid, x, y) || grid[x][y] != 0){
            return 0;
        }

        Set<Integer> set = new HashSet<Integer>();
        if( isArea(grid, x-1, y) && grid[x-1][y] >= 2 ){
            set.add(grid[x-1][y]);
        }
        if( isArea(grid, x+1, y) && grid[x+1][y] >=2 ){
            set.add(grid[x+1][y]);
        }
        if( isArea(grid, x, y-1) && grid[x][y-1] >=2 ){
            set.add(grid[x][y-1]);
        }
        if( isArea(grid, x, y+1) && grid[x][y+1] >=2 ){
            set.add(grid[x][y+1]);
        }
        Integer size = 0;
        for (Integer num : set){
            size += map.get(num);
        }
        //海洋变土地，+1
        ++size;
        return size;

    }

    private int areaDfs(int[][] grid, int x, int y, int index){
        if(!isArea(grid, x, y) || grid[x][y] != 1){
            return 0;
        }

        grid[x][y] = index;
        return 1 + areaDfs(grid, x - 1, y, index)
            +areaDfs(grid, x + 1, y, index)
            +areaDfs(grid, x, y - 1, index)
            +areaDfs(grid, x, y + 1, index);
    }

    private boolean isArea(int[][] grid, int x, int y) {
        return 0<=x && x<grid.length && 0<=y && y < grid[0].length;
    }


}
