package math;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @create: 2022-07-04 09:32
 **/
public class MinimumAbsDifference {

    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        int minAbs = Integer.MAX_VALUE;

        Map<Integer, List<List<Integer>>> ans = new HashMap<>();

        for(int i = 1 ; i < arr.length ; i++){
            int cur = arr[i] - arr[i-1];
            minAbs = Math.min(minAbs, cur);
            List<List<Integer>> orDefault = ans.getOrDefault(cur, new LinkedList<>());
            orDefault.add(Arrays.asList(arr[i-1], arr[i]));
            ans.put(cur,orDefault);
        }
        return ans.get(minAbs);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3,8,-10,23,19,-4,-14,27};
        List<List<Integer>> lists = new MinimumAbsDifference().minimumAbsDifference(arr);
        System.out.println("OK");

    }
}
