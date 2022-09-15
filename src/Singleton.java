/**
 * @description:
 * @create: 2022-07-08 14:12
 **/
public class Singleton {

    /**
     *  arr : 4 1 5s 3 9e
     *   1 5 4
     *   3 9 6
     *   10
     */

    public int maxProduct(int[] nums){

        if(nums.length < 2) return 0;

        int maxPrise = 0;

        int start = 0;
        int end = 0;
        for(int i = 1 ; i < nums.length ; i ++){
            end = i;
            if(end > start && nums[end] - nums[start] > 0){
                maxPrise += getScopeMax(nums,start,end);
                start = end;
            }

        }
        return maxPrise;
    }

    private  int getScopeMax(int[] nums, int start, int end){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = start; i <= end ; i ++){
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        return max - min;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,1,5,3,9};
        System.out.println(new Singleton().maxProduct(arr));
    }




}
