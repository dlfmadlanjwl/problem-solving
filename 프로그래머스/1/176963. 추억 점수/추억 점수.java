import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<name.length;i++){
            map.put(name[i], yearning[i]);
        }
        int[] answer = new int[photo.length];
        int i=0;
        for(String[] names : photo){
            for(String person : names){
                if(map.containsKey(person)) answer[i] += map.get(person);
            }
            i++;
        }

        return answer;
    }
}