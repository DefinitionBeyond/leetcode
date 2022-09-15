package search;

/**
 * @description: 统计一个数字在排序数组中出现的次数
 *  先找到最右边的对应元素，然后往左统计
 * @create: 2022-06-04 01:18
 **/
public class Search {


    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        int ans = 0;
        while (r >= 0 && nums[r] == target && r-- >= 0) {
            ans++;
        }
        return ans;
    }
}
