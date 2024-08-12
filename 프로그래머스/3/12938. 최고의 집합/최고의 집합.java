import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            answer[i] = s/n;
        }
        for(int i=0;i<s%n;i++){
            answer[i]++;
        }
        for(int i=0;i<n;i++){
            if(answer[i] <= 0) return new int[]{-1};
        }
        
        Arrays.sort(answer);
        return answer;
    }
}