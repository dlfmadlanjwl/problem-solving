import java.util.*;

class Solution {
    public int solution(String name) {
        int n = name.length();
        
        int LRMove = name.length() - 1;
        int TDMove = 0;
        
        for(int x=0;x<n;x++){
            TDMove += Math.min(name.charAt(x) - 'A', 'Z'-name.charAt(x)+1);
            
            int y = x+1;
            while(y < n && name.charAt(y) == 'A'){
                y++;
            }
            
            LRMove = Math.min(LRMove, Math.min(x*2+(n-y), (n-y)*2+x));
        }
        
       return LRMove + TDMove;
    }
}