class Solution {
    public int solution(String dirs) {
        boolean[][][] isVisited = new boolean[11][11][2];
        
        int y = 5, x = 5;
        for(char op : dirs.toCharArray()){
            if(op == 'U'){
                if(y == 0) continue;
                y--;
                isVisited[y][x][0] = true;
            }else if(op == 'D'){
                if(y == 10) continue;
                isVisited[y][x][0] = true;
                y++;
            }else if(op == 'L'){
                if(x == 0) continue;
                x--;
                isVisited[y][x][1] = true;
            }else if(op == 'R'){
                if(x == 10) continue;
                isVisited[y][x][1] = true;
                x++;
            }
        }
        
        int answer = 0;
        for(int i=0;i<11;i++){
            for(int j=0;j<11;j++){
                if(isVisited[i][j][0]) answer++;
                if(isVisited[i][j][1]) answer++;
            }
        }
        
        return answer;
    }
}