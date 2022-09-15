import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @create: 2022-06-04 01:10
 **/
public class FindRepeatNumber {

    private Set<Integer> record = new HashSet<>();
    public int findRepeatNumber(int[] nums) {
        for (int num : nums) {
            if(record.contains(num)){
                return num;
            }
            record.add(num);
        }
        return -1;
    }
}
