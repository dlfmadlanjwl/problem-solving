import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = 
            new PriorityQueue<>();
        
        for(int i:scoville) heap.add(i);
                
        int count = 0;
        while(heap.peek() < K && heap.size() >= 2){
            int a = heap.poll();
            int b = heap.poll();
            heap.add(a + b * 2);
            count++;
        }
        
        if(heap.peek() < K) return -1;
        return count;
    }
}