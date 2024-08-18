import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int n = new HashSet<>(List.of(gems)).size();

        Map<String,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int[] answer = {0,0};
        int left = 0, right = -1;
        while(right < gems.length){
            if(map.size() == n){
                if(right - left < min) {
                    min = right - left;
                    answer = new int[]{left+1, right+1};
                }
                String gem = gems[left];
                map.put(gem, map.get(gem)-1);
                if(map.get(gem) == 0) map.remove(gem);
                left++;
            }

            if(map.size() < n){
                right++;
                if(right >= gems.length) continue;
                String gem = gems[right];
                map.put(gem, map.getOrDefault(gem, 0)+1);
            }
        }

        return answer;
    }
}