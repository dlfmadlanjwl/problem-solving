import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        int index = 0;
        for(int i=1;i<words.length;i++){
            String word = words[i];
            if(set.contains(word)){
                index = i;
                break;
            }
            if(words[i-1].charAt(words[i-1].length()-1) != word.charAt(0) ){
                index = i;
                break;
            }
        }
        
        int[] answer = new int[2];
        if(index != 0){
            answer[0] = index % n + 1;
            answer[1] = (int)Math.ceil((double)(index+1) / n);
        }

        return answer;
    }
}