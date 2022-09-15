package dp;

import java.util.Stack;

/**
 * @description:
 * @create: 2022-06-10 14:09
 **/
public class TranslateNum {

    private Stack<Integer> stack = new Stack();

    public int translateNum(int num) {
        if(num<10){
            return 1;
        }
        int size = 0;
        //初始化栈
        while (num > 0) {
            int temp = num % 10;
            stack.push(temp);
            num /= 10;
            size++;
        }
        int[] dp = new int[size+1];
        dp[0] = 1;
        dp[1] = 1;
        int top = stack.pop();

        for (int i = 2; i < size+1; i++) {
            int cur = stack.pop();
            int temp = top * 10 + cur;
            if (top>0 && temp >= 0 && temp < 26) {
                dp[i] = dp[i - 1] + dp[i-2];
            } else {
                dp[i] = dp[i - 1];
            }
            top = cur;
        }
        return dp[size];
    }

    public static void main(String[] args) {
        System.out.println(new TranslateNum().translateNum(506));
    }
}
