package array;

/**
 * @description:
 * @create: 2022-09-07 19:36
 **/
public class WiggleMaxLength {

    public int wiggleMaxLength(int[] nums) {
        if(nums == null )return 0;
        int n = nums.length;
        if(nums.length == 2)return nums[1] - nums[0] == 0 ? 1 : 2;
        if(n<=2)return n;
        int[] temp = new int[n-1];
        for(int i = 1; i<n; i++){
            temp[i-1] = nums[i] - nums[i-1];
        }
        int prevIndex = 0;
        int curLen = 1;
        boolean flag = true;
        for(int i = 1; i< n-1; i++){
            if(flag && (temp[i] < 0 && temp[i-1]>0) || (temp[i] > 0 && temp[i-1]<0)){
                curLen++;
            }else if (!flag && (temp[i] < 0 && temp[prevIndex]>0) || (temp[i] > 0 && temp[prevIndex]<0)){
                curLen++;
                prevIndex = i-1;
                flag = !flag;
            }else{
                prevIndex = i-1;
                continue;
            }
        }
        return curLen+1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
            0,0,0
        };
        new WiggleMaxLength().wiggleMaxLength(nums);
    }

}
