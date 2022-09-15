/**
 * @description:
 * @create: 2022-06-03 00:22
 **/
public class ReverseLeftWords {

    public String reverseLeftWords(String s, int n) {
        if(n < 1){
            return s;
        }
        String post = s.substring(0,n);
        String prefix = s.substring(n, s.length());
        return prefix + post;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseLeftWords().reverseLeftWords("abcdefg", 2));
    }
}
