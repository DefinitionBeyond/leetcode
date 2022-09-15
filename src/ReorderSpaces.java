import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @create: 2022-09-07 14:26
 **/
public class ReorderSpaces {


    public String reorderSpaces(String text) {
        List<String> words = new ArrayList();
        int spaceNum = 0;
        String curWord = "";
        for(int i = 0 ; i < text.length(); i++){
            char temp = text.charAt(i);
            if(temp == ' '){
                spaceNum++;
            }
            if(temp != ' '){
                curWord += temp;
            }else if(!curWord.equals("")){
                words.add(curWord);
                curWord = "";
            }
        }
        if(!curWord.equals("")){
            words.add(curWord);
        }

        if(words.size() == 0 || spaceNum == 0)return text;


        int spaceLen =words.size() > 1?  spaceNum/(words.size()-1) : 0;
        int last = words.size() > 1?spaceNum%(words.size()-1): spaceNum;

        String split = "";
        for(int i = 0; i< spaceLen; i++){
            split += " ";
        }



        StringBuilder ans = new StringBuilder();
        for(int i = 0; i< words.size(); i++){
            if(i < words.size() -1 ){
                ans.append(words.get(i));
                ans.append(split);
            }else{
                ans.append(words.get(i));
            }
        }

        if(last > 0){
            for(int i = 0; i< last; i++){
                ans.append(" ");
            }
        }
        return ans.toString();
    }


    int m,n ;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        int[][] copy = board;

        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                int num = getLive(copy, i, j);
                if(num < 2) board[i][j] = 0;
                if(num == 2 || num == 3) board[i][j] = 1;
                if(num >3) board[i][j] = 0;
            }
        }
    }

    private int getLive(int[][] board, int i, int j){

        int a = (i-1 >=0 && board[i-1][j] == 1) ? 1 : 0;
        int b = (i-1 >=0 && j-1 >=0 && board[i-1][j-1] == 1) ? 1 : 0;
        int c = (i-1 >=0 && j+1 < n && board[i-1][j+1] == 1) ? 1 : 0;
        int d = (j-1 >=0 && board[i][j-1] == 1) ? 1 : 0;
        int e = (j+1 < n && board[i][j+1] == 1) ? 1 : 0;
        int f = (i+1 < m && j-1 >=0 && board[i+1][j-1] == 1) ? 1 : 0;
        int g =(i+1 < m && board[i+1][j] == 1) ? 1 : 0;
        int h = (i+1 < m && j+1 < n && board[i+1][j+1] == 1) ? 1 : 0;
        return a + b + c + d + e + f + g + h;
    }

    public static void main(String[] args) {
        String s = "  this";
        new ReorderSpaces().reorderSpaces(s);
    }
}
