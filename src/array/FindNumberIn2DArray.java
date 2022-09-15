package array;

/**
 * @description: 二维数组找目标值
 * @create: 2022-06-05 23:11
 **/
public class FindNumberIn2DArray {


    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int cols = matrix[0].length;
        int rows = matrix.length;
        int row = 0,col = cols-1;
        while ( row < rows && col >= 0){
            int temp = matrix[row][col];
            if(temp == target){
                return true;
            } else if (temp > target) {
                col--;
            }else {
                row++;
            }
        }

        return false;
    }
}
