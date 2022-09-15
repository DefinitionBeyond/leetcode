package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @description:
 * @create: 2022-07-28 11:16
 **/
public class ArrayRankTransform {

    public int[] arrayRankTransform(int[] arr) {

        List<Integer> keys = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.toList());;

        Collections.sort(keys);

        Map<Integer, Integer> sortMap = new HashMap<>();
        int index = 1;
        for(Integer key: keys ){
            if(!sortMap.containsKey(key))
            sortMap.put(key, index++);
        }

        for(int i = 0 ; i < arr.length; i++){
            int rank = sortMap.get(arr[i]);
            arr[i] = rank;
        }
        return arr;
    }


}
