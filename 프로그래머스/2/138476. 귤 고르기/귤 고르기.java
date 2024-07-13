import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int size : tangerine){
            map.put(size, map.getOrDefault(size, 0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int answer = 0;
        for(Integer size : list){
            k -= size;
            answer++;
            if(k < 1){
                return answer;
            }
        }
        
        return answer;
    }
}