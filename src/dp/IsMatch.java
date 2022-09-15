package dp;

/**
 * @description: 自己实现正则表达式
 * @create: 2022-06-06 19:27
 **/
public class IsMatch {


    public boolean isMatch(String s, String p) {
        int sLen = s.length() + 1;
        int pLen = p.length() + 1;
        boolean[][] dp = new boolean[sLen][pLen];

        dp[0][0] = true;

        for (int i = 0; i < sLen; i++) {
            for (int j = 1; j < pLen; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (match(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    if (match(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[sLen - 1][pLen - 1];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }

    public static void main(String[] args) {

        String s = "aa";
        String p = "a*";

        System.out.println(new IsMatch().isMatch(s, p));

    }


}
