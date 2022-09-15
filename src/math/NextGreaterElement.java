package math;

import java.util.Arrays;
import sort.QuickSort;

/**
 * @description:
 * @create: 2022-07-03 01:11
 **/
public class NextGreaterElement {

    public int nextGreaterElement(int tt) {
        if (tt < 10) return -1;
        int[] temp = new int[32];
        int i = 0;
        int zero = 0;
        int n = tt;
        while (n > 0){
            int cur = n % 10;
            n = n/10;
            temp[i] = cur;
            if(cur == 0)zero++;
            i++;
        }
        Arrays.sort(temp);

        int t = 0;
        for(int j = temp.length - 1 ; j > 0; j--){
            if(0 != temp[j]){
                t = t * 10 + temp[j];
            }else if(zero > 0){
                t = t * 10;
                zero--;
            }
        }
        return t != tt? t: -1;
    }

    public static void main(String[] args) {
        System.out.println(new NextGreaterElement().nextGreaterElement(21));
    }
}
