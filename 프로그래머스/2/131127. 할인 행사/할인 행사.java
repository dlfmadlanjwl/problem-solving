import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        for(int i=0;i<=discount.length-10;i++){
            Map<String, Integer> map = new HashMap<>();
            for(int j=i;j<i+10;j++){
                map.put(discount[j], map.getOrDefault(discount[j], 0)+1);
            }
            boolean isValid = true;
            for(int j=0;j<want.length;j++){
                int dc = map.getOrDefault(want[j], 0);
                int wantCount = number[j];
                
                if(dc != wantCount) isValid = false;
            }
            if(isValid) answer++;
        }
        
        return answer;
    }
}