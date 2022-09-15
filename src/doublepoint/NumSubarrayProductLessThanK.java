package doublepoint;

/**
 * @description:  乘积小于k的子数组
 * @create: 2022-06-01 16:23
 **/
public class NumSubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int len = nums.length;
        if(len == 0)return 0;

        int res = 0;
        int start = 0, end = 0;

        int sum = 1;
        while (end <= len){
            sum *= nums[end];
            while (sum >= k){
                sum/=nums[start];
                start++;
            }
            res++;
            end++;
        }
        return 0;
    }
}
