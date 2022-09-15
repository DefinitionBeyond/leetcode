package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 插入区间
 * @create: 2022-06-13 23:49
 **/
public class Insert {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        for(int i = 0 ; i < intervals.length ; i ++){
            int l = intervals[i][0], r = intervals[i][1];
            if(newInterval[0] <= l && l<= newInterval[1]){
                while (newInterval[1] > intervals[i][0]){
                    i++;
                }
                r = Math.max(newInterval[1], intervals[i-1][1]);
                i--;
            }
            ans.add(new int[]{l,r});
        }
        return ans.toArray(new int[ans.size()][]);
    }


    public static void main(String[] args) {
        int[][] nums = new int[][]{
            {1,2},{3,5},{6,7},{8,10},{12,16}
        };

        int[] insert = new int[]{4,8};

        new Insert().insert(nums,insert);


    }
}
