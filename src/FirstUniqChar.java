import java.util.HashMap;
import java.util.Map;

/**
 * @description: 第一个只出现一次的字符
 * 思路： hash表统计
 * @create: 2022-06-05 23:47
 **/
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        if(s == null|| s.length() == 0)return ' ';
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++){
            char temp = s.charAt(i);
            if(map.containsKey(temp)){
                map.put(temp, map.get(temp)+1);
            }else {
                map.put(temp,1);
            }
        }

        for(int i = 0 ; i < s.length(); i++) {
            char temp = s.charAt(i);
            if(map.get(temp) == 1){
                return temp;
            }
        }
        return ' ';
    }
}
