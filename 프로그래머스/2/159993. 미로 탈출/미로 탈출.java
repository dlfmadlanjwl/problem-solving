import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int a = bfs(maps, 'S', 'L');
        System.out.println();
        int b = bfs(maps, 'L', 'E');
        
        if(a == -1 || b == -1) return -1;
        return a + b;
    }
    
    int bfs(String[] maps, char start, char end){
        int y = 0, x = 0;
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(maps[i].charAt(j) == start) {
                    y = i; x = j;
                }
            }
        }
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        boolean[][] isVisited = new boolean[maps.length][maps[0].length()];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x,0));
        isVisited[y][x] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(maps[now.y].charAt(now.x) == end) return now.depth;
            for(int i=0;i<4;i++){
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if(newY >= maps.length || newY < 0) continue;
                if(newX >= maps[0].length() || newX < 0) continue;
                
                if(!isVisited[newY][newX] && maps[newY].charAt(newX) != 'X'){
                    q.add(new Node(newY, newX, now.depth+1));
                    isVisited[newY][newX] = true;
                }
            }
        }
        
        return -1;
    }
    
    class Node{
        int y;
        int x;
        int depth;
        
        Node(int y, int x, int depth){
            this.y = y;
            this.x = x;
            this.depth = depth;
        }
    }
}