import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        int maxArea = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    count++;
                    int area = bfs(i,j,picture, visited);            
                    if(area > maxArea) maxArea = area;
                }
            }
        }
        int[] result = new int[2];
        result[0] = count;
        result[1] = maxArea;
        
        return result;
    }
    
    private static int bfs(int y, int x, int[][] picture, boolean[][] visited){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x));
        visited[y][x] = true;
        int[] dy = {1,-1,0,0};
        int[] dx = {0,0,-1,1};
        int area = 1;
        while(!q.isEmpty()){
            Node now = q.poll();
            for(int i=0;i<4;i++){
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if(newY >= 0 && newY < picture.length &&
                   newX >= 0 && newX < picture[0].length){
                    if(!visited[newY][newX] && picture[newY][newX] == picture[y][x]){
                        q.add(new Node(newY, newX));
                        visited[newY][newX] = true;  
                        area++;
                    }
                }
            }
        }
        return area;
    }
    
    static class Node{
        int y;
        int x;
        
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}