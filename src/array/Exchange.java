package array;

/**
 * @description:
 * @create: 2022-06-13 11:17
 **/
public class Exchange {

    public int[] exchange(int[] nums) {
        int high = nums.length - 1;
        int low = 0;

        while (low < high) {
            if (nums[high] % 2 == 0) {
                high--;
            } else {
                while (low < nums.length && nums[low] % 2 == 1) {
                    low++;
                }
                if (low < high) {
                    int temp = nums[high];
                    nums[high] = nums[low];
                    nums[low] = temp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5};
        new Exchange().exchange(nums);

    }

}
