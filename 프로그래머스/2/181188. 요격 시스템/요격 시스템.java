import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, new Comparator<>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        int answer = 0;
        int[] range = new int[2];
        for(int[] target : targets){
            if(target[0] < range[1]){
                range[0] = target[0];
                range[1] = Math.min(range[1], target[1]);
            }else{
                answer++;
                range = target;
            }
        }

        return answer;
    }
}