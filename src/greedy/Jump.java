package greedy;

/**
 * @description: 跳跃游戏 II
 * 思路：
 *  贪心，每次都最大贪心的选择最大能跳跃的步数
 * @create: 2022-06-13 23:18
 **/
public class Jump {



    public int jump(int[] nums) {
        int end = 0;
        int maxPoint = 0;
        int step = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++){
            //已经记录的最大跳跃，和当前最大跳跃对比
            maxPoint = Math.max(maxPoint, i + nums[i]);
            if( i == end){
                //跳跃到最大选择上
                end = maxPoint;
                step ++;
            }
        }
        return step;
    }
}
