import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<26;i++){
            map.put((char)('A'+i)+"", i+1);
        }

        int maxValue = 27;
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        while(true){
            String key = "";
            String newKey = "";
            for(int len=1;len<=msg.length()-idx;len++){
                String s = msg.substring(idx, idx+len);
                if(map.containsKey(s)){
                    key = s;
                }else{
                    newKey = s;
                    break;
                }
            }
            list.add(map.get(key));
            map.put(newKey, maxValue);
            maxValue++;
            idx+=key.length();
           
            if(idx == msg.length()) break;
        }

        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}