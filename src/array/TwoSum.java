package array;

/**
 * @description:
 * @create: 2022-06-13 11:30
 **/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (nums[high] > target){
            high--;
        }

        while (low < high){
            if(nums[low] + nums[high]== target){
                return new int[]{nums[low], nums[high]};
            }
            if(nums[low] + nums[high] > target){
                high--;
            }
            if(nums[low] + nums[high] < target){
                low ++;
            }

        }
        return new int[]{};
    }

}
