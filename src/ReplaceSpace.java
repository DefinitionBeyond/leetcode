/**
 * @description:
 * @create: 2022-06-03 00:19
 **/
public class ReplaceSpace {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ;i++){
            char curChar = s.charAt(i);
            if(curChar == ' '){
                sb.append("%20");
            }else {
                sb.append(curChar);
            }

        }
        return sb.toString();
    }
}
