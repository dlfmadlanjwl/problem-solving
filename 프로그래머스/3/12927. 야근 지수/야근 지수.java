import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i:works) pq.add(i);

        for(int i=0;i<n;i++){
            if(pq.isEmpty()) break;
            int x = pq.poll();
            if(x != 0) pq.add(x-1);
        }
        
        long answer = 0;
        for(int i:pq){
            answer += (long)i*i;
        }
        
        return answer;
    }
}