import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int[] solution(long n) {
        List<Integer> list = new ArrayList<>();
        while(true){
            if(n<10) {
                list.add((int)n);
                break;
            }
            list.add((int)(n%10));
            n/=10;
        }
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
