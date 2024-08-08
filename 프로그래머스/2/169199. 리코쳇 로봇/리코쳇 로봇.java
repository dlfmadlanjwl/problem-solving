import java.util.*;

class Solution {
    public int solution(String[] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length();j++){
                if(board[i].charAt(j) == 'R'){
                    return bfs(board, i, j);
                }
            }
        }
        int answer = 0;
        return answer;
    }
    
    int bfs(String[] board, int y, int x){
        boolean[][] isVisited = new boolean[board.length][board[0].length()];
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y, x, 0));
        isVisited[y][x] = true;
        
        while(!q.isEmpty()){
            Node now = q.poll();
            if(board[now.y].charAt(now.x) == 'G'){
                return now.depth;
            }
            int newY = now.y;
            int newX = now.x;
            
            for(int i=newY;i<board.length;i++){
                if(board[i].charAt(newX)=='D') break;
                else newY = i;
            }
            if(!isVisited[newY][newX]){
                q.add(new Node(newY, newX, now.depth+1));
                isVisited[newY][newX] = true;
            }
            newY = now.y;
            
            for(int i=newY;i>=0;i--){
                if(board[i].charAt(newX)=='D') break;
                else newY = i;
            }
            if(!isVisited[newY][newX]){
                q.add(new Node(newY, newX, now.depth+1));
                isVisited[newY][newX] = true;
            }
            newY = now.y;
            
            for(int i=newX;i<board[0].length();i++){
                if(board[newY].charAt(i)=='D') break;
                else newX = i;
            }
            if(!isVisited[newY][newX]){
                q.add(new Node(newY, newX, now.depth+1));
                isVisited[newY][newX] = true;
            }
            newX = now.x;
            
            for(int i=newX;i>=0;i--){
                if(board[newY].charAt(i)=='D') break;
                else newX = i;
            }
            if(!isVisited[newY][newX]){
                q.add(new Node(newY, newX, now.depth+1));
                isVisited[newY][newX] = true;
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