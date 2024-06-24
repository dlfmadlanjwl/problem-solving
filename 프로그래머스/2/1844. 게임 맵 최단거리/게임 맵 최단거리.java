import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return dfs(0, 0, maps);
    }
    
    private int dfs(int y, int x, int[][] maps){
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x, 1));
        visited[y][x] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if(newY >= 0 && newY < maps.length &&
                   newX >= 0 && newX < maps[0].length){
                    if(!visited[newY][newX] && maps[newY][newX] == 1){
                        if(newY == maps.length-1 && newX == maps[0].length-1){
                            return now.depth + 1;
                        }
                        q.add(new Node(newY, newX, now.depth+1));
                        visited[newY][newX] = true;
                    }
                }
            }
        }
        return -1;
    }
    
    private static class Node{
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