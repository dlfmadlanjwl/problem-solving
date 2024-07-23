import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int union = 0;
        for(int i=0;i<str1.length()-1;i++){
            String s = str1.substring(i, i+2);
            if(s.charAt(0) < 'a' || s.charAt(0) > 'z' || s.charAt(1) < 'a' || s.charAt(1) > 'z') continue;
            map1.put(s, map1.getOrDefault(s, 0)+1);
        }
        for(int i=0;i<str2.length()-1;i++){
            String s = str2.substring(i, i+2);
            if(s.charAt(0) < 'a' || s.charAt(0) > 'z' || s.charAt(1) < 'a' || s.charAt(1) > 'z') continue;
            map2.put(s, map2.getOrDefault(s, 0)+1);
        }
        
        int common = 0;
        for(String key : map1.keySet()){
            if(map2.keySet().contains(key)){
                common += Math.min(map1.get(key), map2.get(key));
                union += Math.max(map1.get(key), map2.get(key));
            }else
                union += map1.get(key);
        }
        for(String key : map2.keySet()){
            if(!map1.keySet().contains(key)){
                union += map2.get(key);
            }
        }
        
        if(union == 0){
            union = 1;
            common = 1;
        }
        
        return (int)Math.floor((double)common / union * 65536);
    }
}