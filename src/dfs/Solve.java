package dfs;

/**
 * @description:
 * @create: 2022-07-20 01:21
 **/
public class Solve {

    int r,c;
    public void solve(char[][] board) {
        c = board.length;
        r = board[0].length;

        if(c == 0 || r == 0){
            return;
        }

        for(int i = 0 ; i < c ; i ++){
            bfs(board, i, 0);
            bfs(board, i, r - 1);
        }

        for(int i = 1 ; i < r - 1 ; i ++){
            bfs(board, 0, i);
            bfs(board, c - 1, i);
        }

        for(int i = 0 ; i < c ; i++){
            for(int j = 0 ; j < r; j++){
                if(board[i][j] == 'A'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }


    private void bfs(char[][] board, int x ,int y){
        if(x < 0 || y < 0 || x >= c || y >= r || board[x][y] != 'O'){
            return;
        }
        board[x][y] = 'A';
        bfs(board, x-1, y);
        bfs(board, x+1, y);
        bfs(board, x, y-1);
        bfs(board, x, y+1);
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'O','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        new Solve().solve(board);
    }

}
