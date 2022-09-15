package dp;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * @description:
 * @create: 2022-06-10 16:09
 **/
public class LengthOfLongestSubstring {


    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len];
        dp[0] = 1;
        int maxLen = dp[0];

        for (int i = 1; i < len; i++) {
            int j = i - 1;
            // 向前遍历
            while(j >= 0 && s.charAt(i) != s.charAt(j)){
                j--;
            }
            // 判断第j个字符是否在dp[i-1]的区间之内
            dp[i] = dp[i - 1] < i - j ? dp[i - 1] + 1 : i - j;
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "dvdf";
        System.out.println(new LengthOfLongestSubstring().lengthOfLongestSubstring(s));
    }
}
