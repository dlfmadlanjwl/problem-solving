import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i-1] != arr[i]) list.add(arr[i]);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}