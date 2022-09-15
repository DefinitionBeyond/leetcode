package array;

/**
 * @description:
 * @create: 2022-09-07 19:19
 **/
public class GameOfLife {

    int m,n ;
    public void gameOfLife(int[][] board) {
        m = board.length;
        n = board[0].length;
        int[][] copy = new int[m][n];

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j<n; j++){
                int num = getLive(copy, i, j);
                if(num < 2 &&  board[i][j] == 1) board[i][j] = 0;
                if((num == 2 || num == 3 ) && board[i][j] == 1) board[i][j] = 1;
                if(num >3 && board[i][j] == 1) board[i][j] = 0;
                if(num == 3 && board[i][j] == 0) board[i][j] = 1;
            }
        }
        System.out.println("OK");
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
        int[][] board = new int[][]{
            {0,1,0},{0,0,1},{1,1,1},{0,0,0}
        };
        new GameOfLife().gameOfLife(board);
    }

}
