package search;

/**
 * @description: 有序数组旋转之后，找最小值
 * @create: 2022-06-05 23:30
 **/
public class MinArray {


    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length-1;
        int mid = 0;
        while(low<high){
            mid = (high + low +1) >> 1;
            if(numbers[mid] < numbers[high]){
                high = mid;
            } else if(numbers[mid] > numbers[high]){
                low = ++mid;
            }else {
                --high;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,4,5,1,2};
        System.out.println(new MinArray().minArray(nums));
    }
}
