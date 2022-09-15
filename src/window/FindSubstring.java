package window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description: 串联所有单词的子串
 * @create: 2022-06-07 10:21
 **/
public class FindSubstring {

    private Map<String, Integer> map = new HashMap<>();

    public List<Integer> findSubstring(String s, String[] words) {

        if (words == null || words.length < 0) {
            return new ArrayList<>();
        }

        //定义窗口
        int subLen = 0;
        //初始化窗口
        for (String word : words) {
            subLen += word.length();
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int wordLen = words[0].length();

        if (s.length() < subLen) {
            return new ArrayList<>();
        }

        int start = 0;

        List<Integer> res = new ArrayList<>();
        while (start <= s.length() - subLen) {
            String sub = s.substring(start, start + subLen);
            System.out.println(sub);
            if (isMatch(sub, wordLen)) {
                res.add(start);
            }
            start++;
        }

        return res;
    }

    private boolean isMatch(String s, int wordLen) {
        Map<String, Integer> tempMap = new HashMap(map);
        for (int i = 0; i < s.length(); i += wordLen) {
            String tmp = s.substring(i, i + wordLen);
            if (tempMap.containsKey(tmp) && tempMap.get(tmp) > 0) {
                tempMap.put(tmp, tempMap.get(tmp) - 1);
            } else {
                return false;
            }
        }
        return !(tempMap.values().stream().filter(it -> it != 0).collect(Collectors.toList()).size()
            > 0);
    }


    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[]{"word","good","best","good"};
        List<Integer> substring = new FindSubstring().findSubstring(s, words);
        System.out.println("OK");
    }

}
