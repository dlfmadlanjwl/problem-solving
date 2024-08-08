import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        boolean[][] isVisited = new boolean[maps.length][maps[0].length()];
        List<Integer> answer = new ArrayList<>();
        for(int i=0;i<maps.length;i++){
            for(int j=0;j<maps[0].length();j++){
                if(!isVisited[i][j] && Character.isDigit(maps[i].charAt(j))) {
                    answer.add(bfs(maps, isVisited, i, j)); 
                }
            }
        }
        if(answer.size() == 0) return new int[]{-1};
        Collections.sort(answer);
        return answer.stream().mapToInt(x->x).toArray();
    }

    int bfs(String[] maps, boolean[][] isVisited, int y, int x){
        int[] dy = {0, 0, -1, 1};
        int[] dx = {1, -1, 0, 0};

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(y,x));
        isVisited[y][x] = true;
        int sum = 0;
        while(!q.isEmpty()){
            Node now = q.poll();
            sum += maps[now.y].charAt(now.x) - '0';
            for(int i=0;i<4;i++){
                int newY = now.y + dy[i];
                int newX = now.x + dx[i];
                if(newY < 0 || newY >= isVisited.length) continue;
                if(newX < 0 || newX >= isVisited[0].length) continue;

                if(!isVisited[newY][newX] && Character.isDigit(maps[newY].charAt(newX))) {
                    q.add(new Node(newY, newX));
                    isVisited[newY][newX] = true;
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