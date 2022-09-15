package bit;

/**
 * @description:
 * 给你一个整数数组 nums ，
 * 除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
 * 请你找出并返回那个只出现了一次的元素。
 *
 * 思路：取余，统计二进制每一位1的个数，对3取余，剩下的数字对应目标数字的二进制
 *
 * @create: 2022-06-01 15:21
 **/
public class SingleNumber {

    public int singleNumber(int[] nums) {
        if(nums.length<1)return -1;
        int res = 0;
        for (int i = 0; i < 32; i++) {
            //统计每一位1的和
            int t = 0;
            for (int n : nums) {
                t += (n>>i) & 1;
            }
            //然后对每一位取余
            res |= (t%3) << i;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,3,3};
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber(nums));

    }

}
