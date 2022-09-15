package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 字母异位词分组
 * @create: 2022-06-13 22:32
 **/
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(int i = 0; i< strs.length; i++){
            String key = getKey(strs[i]);
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(strs[i]);
            map.put(key,orDefault);
        }

        List<List<String>> res = new ArrayList<>();

        map.forEach((k,v)->{
            res.add(v);
        });
        return res;
    }

    public String getKey(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        return new String(chars);
    }

    public static void main(String[] args) {
        String[] str = new String[]{"ddddddddddg","dgggggggggg"};
        new GroupAnagrams().groupAnagrams(str);
    }

}
