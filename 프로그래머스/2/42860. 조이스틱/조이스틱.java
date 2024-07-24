import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        for(char c : name.toCharArray()){
            int move = Math.min(c - 'A', 'Z'-c+1);
            answer += move;
        }
        
        answer += bfs(name);
        
        return answer;
    }
    
    int bfs(String name){
        String str = "A".repeat(name.length());
        Queue<Cursur> q = new LinkedList<>();
        q.add(new Cursur(str,0, 0));
        while(!q.isEmpty()){
            Cursur now = q.poll();
            char[] chars = now.str.toCharArray();
            chars[now.index] = name.charAt(now.index);
            String newStr = new String(chars);
            if(newStr.equals(name)) return now.move;
            
            int[] dx = {-1, 1};
            for(int i=0;i<2;i++){
                int idx = now.index + dx[i];
                if(idx == -1) idx = name.length()-1;
                if(idx == name.length()) idx = 0;
                
                q.add(new Cursur(newStr, idx, now.move+1));
            }
        }
        return 0;
    }
    
    class Cursur{
        String str;
        int index;
        int move;
        
        Cursur(String str, int index, int move){
            this.str = str;
            this.index = index;
            this.move = move;
        }
    }
}