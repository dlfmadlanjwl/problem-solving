import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] result = Arrays.stream(arr).filter(i->i%divisor == 0).toArray();
        if(result.length == 0) return new int[]{-1};
        Arrays.sort(result);
        return result;
    }
}