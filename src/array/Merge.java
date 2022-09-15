package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @description: 合并区间
 * 思路： 首先区间排序，然后一步步合并
 * @create: 2022-06-13 23:30
 **/
public class Merge {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> ans = new ArrayList<>();
        for(int i = 0 ; i < intervals.length ; i++){
            int l = intervals[i][0], r = intervals[i][1];
            if(ans.isEmpty() || ans.get(ans.size() - 1)[1] < l){
                ans.add(new int[]{l,r});
            }else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1],r);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
