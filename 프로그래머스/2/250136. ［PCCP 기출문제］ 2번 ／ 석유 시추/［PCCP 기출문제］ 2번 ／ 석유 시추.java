import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int[][] oilNumbers = new int[land.length][land[0].length];
        List<Integer> oil = new ArrayList<>();
        int seq = 1;
        for(int i=0;i<land.length;i++){
            for(int j=0;j<land[0].length;j++){
                if(oilNumbers[i][j] == 0 && land[i][j] == 1){
                    oil.add(dfs(land, i, j, seq, oilNumbers));
                    seq++;
                }
            }
        }
                
        int max = Integer.MIN_VALUE;
        for(int i=0;i<land[0].length;i++){
            Set<Integer> set = new HashSet<>();
            for(int j=0;j<land.length;j++){
                if(oilNumbers[j][i] > 0) set.add(oilNumbers[j][i]);
            }
            int sum = 0;
            for(int j:set){
                sum += oil.get(j-1);
            }
            max = Math.max(sum, max);
        }
        
        return max;
    }
    
    int dfs(int[][] land, int y, int x, int seq, int[][] oilNumbers){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x));
        oilNumbers[y][x] = seq;
        int sum = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            sum++;
            for(int i=0;i<4;i++){
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if(newY >= land.length || newY < 0) continue;
                if(newX >= land[0].length || newX < 0) continue;

                if(oilNumbers[newY][newX] == 0 && land[newY][newX] == 1){
                    q.add(new Node(newY, newX));
                    oilNumbers[newY][newX] = seq;
                }
            }   
        }
        return sum;
    }
    
    class Node{
        int y;
        int x;
        Node(int y, int x){
            this.y = y;
            this.x = x;
        }
    }
}