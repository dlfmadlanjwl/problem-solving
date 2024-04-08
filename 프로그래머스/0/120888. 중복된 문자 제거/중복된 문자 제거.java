import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(char c:my_string.toCharArray()){
            if(!set.contains(c)) sb.append(c);
            set.add(c);
        }
        
        return sb.toString();
    }
}