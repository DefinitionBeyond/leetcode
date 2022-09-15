/**
 * @description: 单词长度的最大乘积
 *
 * 不包含相同两个串的最大乘积
 * @create: 2022-06-01 15:36
 **/
public class MaxProduct {

    public int maxProduct(String[] words) {
        if (words.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < words.length - 1; i++) {
            int curLen = words[i].length();
            for (int j = i + 1; j < words.length; j++) {
                if (isContiansChar(words[i], words[j])) {
                    res = Math.max(curLen * words[j].length(), res);
                }
            }
        }
        return res;
    }

    private boolean isContiansChar(String a, String b) {
        return (getVal(a) & getVal(b)) == 0;
    }


    public int getVal(String str) {
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            ans |= 1 << (str.charAt(i) - 'a');
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "fxyz", "abcdef"};
        MaxProduct maxProduct = new MaxProduct();

        System.out.println(maxProduct.maxProduct(words));
    }
}
