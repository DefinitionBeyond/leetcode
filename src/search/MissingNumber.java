package search;

/**
 * @description: 查找有序递增数组
 * @create: 2022-06-04 01:27
 **/
public class MissingNumber {

    public int missingNumber(int[] nums) {
        if(nums.length < 1)return -1;
        if(nums.length == 1)return nums[0] == 0 ? 1 : 0;
        int r = nums.length - 1, l = 0;

        while (l < r) {
            int mid = (r + l + 1) >> 1;
            if (nums[mid] == mid) {
                r = mid + 1;
            } else {
                l = mid -1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1};
        System.out.println(new MissingNumber().missingNumber(nums));
    }

}
