import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String before, String after) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c:before.toCharArray()){
            map.putIfAbsent(c, 0);
            map.replace(c, map.get(c)+1);
        }

        Map<Character, Integer> map2 = new HashMap<>();
        for(char c:after.toCharArray()){
            map2.putIfAbsent(c, 0);
            map2.replace(c, map2.get(c)+1);
        }

        return map.equals(map2) ? 1 : 0;
    }
}