package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 找到所有的农场组
 * @create: 2022-09-06 16:06
 **/
public class FindFarmland {
    List<int[]> ans = new ArrayList();
    int m, n;
    int iMin,jMin,iMax,jMax;

    public int[][] findFarmland(int[][] land) {
        m = land.length;
        n = land[0].length;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n ; j++){
                if(land[i][j] == 1){
                    iMin=Integer.MAX_VALUE;
                    jMin=Integer.MAX_VALUE;
                    iMax=Integer.MIN_VALUE;
                    jMax=Integer.MIN_VALUE;
                    dfs(land,i,j);
                    ans.add(new int[]{iMin,jMin,iMax,jMax});
                }
            }
        }
        int[][] res = new int[ans.size()][4];
        for(int i = 0; i< ans.size(); i++){
            res[i][0] = ans.get(i)[0];
            res[i][1] = ans.get(i)[1];
            res[i][2] = ans.get(i)[2];
            res[i][3] = ans.get(i)[3];
        }
        return res;
    }

    private void dfs(int[][] land, int i, int j){
        if(i >= m || j >= n || land[i][j] != 1)return;
        land[i][j] = 2;
        if(i<=iMin && j<=jMin){
            iMin=i;
            jMin=j;
        }
        if(i>=iMax && j>=jMax){
            iMax=i;
            jMax=j;
        }

        dfs(land, i+1, j);
        dfs(land, i, j+1);
    }

    public static void main(String[] args) {
        int[][] land = new int[][]{
            {1,0,0},{0,1,1},{0,1,1}
        };

        new FindFarmland().findFarmland(land);
    }
}
