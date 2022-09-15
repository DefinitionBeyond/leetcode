package window;

/**
 * @description: 和大于等于 target 的最短子数组
 * @create: 2022-06-01 15:57
 **/
public class MinSubArrayLen {


    //暴力滑动窗口
    public int minSubArrayLen(int target, int[] nums) {
        int windowSize = 1;
        while (windowSize <= nums.length){
            int sum = 0;
            for(int i = 0; i <= nums.length - windowSize; i++){
                sum = nums[i];
                for(int j = i + 1; j< i+windowSize ; j++){
                    sum+=nums[j];
                }
                if(target<= sum){
                    return windowSize;
                }
            }
            windowSize++;
        }
        return 0;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            //一旦大于目标，start开始后移动
            while (sum >= target) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            //不然正常end后移
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,2,4,3};
        System.out.println(new MinSubArrayLen().minSubArrayLen(55, nums));
    }
}
