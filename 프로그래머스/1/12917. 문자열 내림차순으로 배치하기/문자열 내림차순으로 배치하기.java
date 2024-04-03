import java.util.Arrays;
import java.util.Collections;

class Solution {
    public String solution(String s) {
        String[] list = s.split("");
        Arrays.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.length;i++){
            sb.append(list[i]);
        }
        return sb.toString();
    }
}