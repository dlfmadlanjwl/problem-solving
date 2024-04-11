import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for(String c:completion){
            map.putIfAbsent(c, 0);
            map.replace(c, map.get(c)+1);
        }

        for(String p:participant){
            if(map.containsKey(p)){
                if(map.get(p)==0){
                    return p;
                }
                map.replace(p, map.get(p)-1);
            }else{
                return p;
            }
        }
        return null;
    }
}