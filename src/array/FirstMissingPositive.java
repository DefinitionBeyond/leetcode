package array;

/**
 * @description:
 * @create: 2022-07-28 11:24
 **/
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int[] temp = new int[nums.length+1];

        for(int i = 0; i< nums.length + 1; i++){
            temp[i] = 0;
        }

        for(int i = 0; i< nums.length ; i++){
            if(nums[i]> temp.length || nums[i]<= 0)continue;
            else temp[nums[i]] = nums[i];
        }

        for(int i = 1; i< temp.length; i++){
            if(temp[i] == 0)return i;
        }
        return temp.length;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,0};

        System.out.println(new FirstMissingPositive().firstMissingPositive(nums));

    }
}
