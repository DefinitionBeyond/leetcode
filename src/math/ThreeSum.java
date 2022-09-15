package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @create: 2022-07-04 09:50
 **/
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3)return new ArrayList<>();

        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList<>();
        for(int f = 0 ; f < nums.length -2; f++){

            if (f > 0 && nums[f] == nums[f - 1]) {
                continue;
            }
            int three = nums.length -1 ;
            int target = -nums[f];
            // 枚举 b
            for (int second = f + 1; second < nums.length; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > f + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < three && nums[second] + nums[three] > target) {
                    --three;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == three) {
                    break;
                }
                if (nums[second] + nums[three] == target) {
                    ans.add(Arrays.asList(nums[f], nums[second],nums[three]));
                }
            }

        }
        return ans;
    }
}
