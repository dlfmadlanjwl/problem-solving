import java.util.*;

class Solution {
    int max = Integer.MIN_VALUE;
    int[] answer;
    public int[] solution(int n, int[] aScores) {
        answer = new int[11];
        int[] bScores = new int[11];
        dfs(n, 0, aScores, bScores);

        for(int i=0;i<11;i++){
            if(answer[i] != 0) return answer;
        }
        answer = new int[]{-1};
        return answer;
    }
    
    void dfs(int leftArrows, int index, int[] aScores, int[] bScores){
        if(index == 10){
            bScores[index] = leftArrows;
            int aSum = 0, bSum = 0;
            for(int i=0;i<aScores.length;i++){
                if(aScores[i] == 0 && bScores[i] == 0) continue;
                if(aScores[i] >= bScores[i]) aSum += 10 - i;
                else bSum += 10 - i;
            }
            
            if(bSum - aSum > max) {
                max = bSum - aSum; 
                if(max < 1){
                    answer = new int[11];
                } else answer = Arrays.copyOf(bScores, bScores.length);
            } else if(bSum - aSum == max){
                for(int i=10;i>=0;i--){
                    if(answer[i] == bScores[i]) continue;
                    if(answer[i] < bScores[i]) {
                        answer = Arrays.copyOf(bScores, bScores.length); 
                        return;
                    }
                    else return;
                }
            }
            
            return;
        }
        if(leftArrows < 0 || index == 11) return;
        
        if(leftArrows >= aScores[index]+1){
            bScores[index] = aScores[index] + 1;
            dfs(leftArrows-(aScores[index]+1), index+1, aScores, bScores);
            bScores[index] = 0;
        }
        
        dfs(leftArrows, index+1, aScores, bScores);
        
    }
}