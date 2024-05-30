import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        List<Stage> list = new ArrayList<>();
        for(int i=1;i<=N;i++){
            int total = 0;
            int fail = 0;
            for(int j=0;j<stages.length;j++){
                if(stages[j] == i){
                    fail++;
                }
                if(stages[j] >= i) total++;
            }
            if(total == 0) {
                list.add(new Stage(i, 0));    
            } else{
                list.add(new Stage(i, (double)fail/total));    
            }
        }
        Collections.sort(list, (a,b)->{
            if(a.failure != b.failure){
                return a.failure > b.failure ? -1:1;    
            }
            return a.number - b.number;
        });
        return list.stream().map(stage->stage.number).mapToInt(i->i).toArray();
    }
    static class Stage{
        int number;
        double failure;
        Stage(int number, double failure){
            this.number = number;
            this.failure = failure;
        }
    }
}