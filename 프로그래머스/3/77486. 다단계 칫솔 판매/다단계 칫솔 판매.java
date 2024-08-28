import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> graph = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        for(int i=0;i<enroll.length;i++){
            graph.put(enroll[i], referral[i]);
            result.put(enroll[i], 0);
        }
        
        for(int i=0;i<seller.length;i++){
            String child = seller[i];
            String parent = graph.get(child);
            int profit = amount[i] * 100;
            while(graph.containsKey(child)){
                int parentProfit = profit / 10;
                result.put(child, result.get(child)+profit-parentProfit);
                
                if(parentProfit == 0) break;
                
                profit = parentProfit;
                child = parent;
                parent = graph.get(child);
            }
        }
        
        int[] answer = new int[enroll.length];
        for(int i=0;i<enroll.length;i++){
            answer[i] = result.get(enroll[i]);
        }
        
        return answer;
    }
}