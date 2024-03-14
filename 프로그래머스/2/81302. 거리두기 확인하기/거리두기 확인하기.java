class Solution {
    private final static int[] dx = {0, 1, -1, 0};
    private final static int[] dy = {-1, 0, 0, 1};

    private static boolean isNextToVolunteer(char[][] room, int x, int y, int exclude){
        for(int i=0;i<4;i++){
            if(i==exclude)continue;

            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>4||ny>4||nx<0||ny<0) continue;
            if(room[ny][nx] == 'P') return true;
        }
        return false;
    }

    private static boolean isDistanced(char[][] room){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(room[i][j]!='P')continue;
                if(!isDistanced(room, j, i))return false;
            }
        }
        return true;
    }

    private static boolean isDistanced(char[][] room, int x, int y){
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>4||ny>4||nx<0||ny<0) continue;
            switch (room[ny][nx]){
                case 'P': return false;
                case 'O':
                    if(isNextToVolunteer(room,nx,ny,3-i)) return false;
                    break;
            }
        }
        return true;
    }

    public static int[] solution(String[][] places) {
        char[][] point = new char[5][5];

        int[] answer = new int[5];
        for(int t=0;t<5;t++){
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
                    point[i][j] = places[t][i].charAt(j);
                }
            }

            if(isDistanced(point)){
                answer[t] = 1;
            }else{
                answer[t] = 0;
            }
        }

        return answer;
    }
}