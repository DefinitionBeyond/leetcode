import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @create: 2022-07-28 17:14
 **/
public class CheckPermutation {
    public boolean checkPermutation(String s1, String s2) {
        if(s1 == null || s2 == null || s1.length() != s2.length()){
            return false;
        }
        Map<Character, Integer> countMap = new HashMap();

        for(int i = 0; i< s1.length(); i++){
            countMap.put(s1.charAt(i), countMap.getOrDefault(s1.charAt(i), 0)+1);
        }

        for(int i = 0; i< s2.length(); i++){
            countMap.put(s2.charAt(i), countMap.getOrDefault(s2.charAt(i), 0)-1);
        }

        for(Character key: countMap.keySet()){
            if(countMap.get(key) != 0){
                return false;
            }
        }
        return true;
    }

    public boolean isFlipedString(String s1, String s2) {
        if(null == s1 || null == s2 || s1.length() != s2.length()){
            return false;
        }
        int len = s1.length();
        for(int i=0; i<len; i++){
            int j = 0;
            while(j<len && s2.charAt(j) == s1.charAt((i + j)%(len))){
                j++;
            }
            if(j == len){

                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String a = "waterbottle";
        String b = "erbottlewat";
        System.out.println(new CheckPermutation().isFlipedString(a,b));
    }


}
