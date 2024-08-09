import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        List[] list = new List[(int)Math.ceil((double)minerals.length/5)];

        for(int i=0;i<minerals.length;i+=5){
            list[i/5] = new ArrayList<String>();
            for(int j=i;j<i+5;j++){
                if(j >= minerals.length) break;
                list[i/5].add(minerals[j]);
            }
        }
        
        return dfs(list, 0, picks, 0);
    }
    
    
    int dfs(List[] list, int index, int[] picks, int fatigue){
        int[][] fatigues = {{1,1,1},{5,1,1},{25,5,1}};
        if(list.length == index){
            return fatigue;
        }
        boolean allUsed = true;
        for(int i=0;i<picks.length;i++){
            if(picks[i] != 0) allUsed = false;
        }
        if(allUsed) return fatigue;
        
        int min = Integer.MAX_VALUE;
        for(int i=0;i<picks.length;i++){
            if(picks[i] == 0) continue;
            
            List<String> minerals = list[index];
            int sum = 0;
            for(int j=0;j<minerals.size();j++){
                if(minerals.get(j).equals("diamond")){
                    sum += fatigues[i][0];
                }else if(minerals.get(j).equals("iron")){
                    sum += fatigues[i][1];
                } else {
                    sum += fatigues[i][2];
                }
            }
            picks[i]--;
            int result = dfs(list, index+1, picks, fatigue+sum);
            if(result < min) min = result;
            picks[i]++;
        }
        return min;
    }
}