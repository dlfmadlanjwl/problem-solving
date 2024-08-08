import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int max = 0;
        boolean[] isVisitedA = new boolean[cards.length];
        for(int i=0;i<cards.length;i++){
            if(isVisitedA[i]) continue;
            boolean[] isVisitedB = new boolean[cards.length];
            isVisitedB[i] = true;
            int boxNum = i;
            int count = 1;
            while(true){
                boxNum = cards[boxNum]-1;
                if(isVisitedB[boxNum]) break;
                
                isVisitedA[boxNum] = true;
                isVisitedB[boxNum] = true;
                count++;
            }
            if(count == cards.length) continue;
            
            for(int j=0;j<cards.length;j++){
                boolean[] isVisitedC = new boolean[cards.length];
                if(isVisitedB[j]) continue;
                int boxNum2 = j;
                int count2 = 1;
                isVisitedC[j] = true;
                while(true){
                    boxNum2 = cards[boxNum2]-1;
                    if(isVisitedB[boxNum2] || isVisitedC[boxNum2]) break;
                
                    isVisitedB[boxNum2] = true;
                    isVisitedC[boxNum2] = true;
                    count2++;
                }

                max = Math.max(max, count * count2);
            }
        }
        
        return max;
    }
}