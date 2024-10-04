class Solution {
    public int solution(int[][] points, int[][] routes) {
        int m = routes[0].length;
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        for(int[] point : points){
            maxY = Math.max(maxY, point[0]);
            maxX = Math.max(maxX, point[1]);
            minY = Math.min(minY, point[0]);
            minX = Math.min(minX, point[1]);
        }
        int answer = 0;
        
        int[][] position = new int[routes.length][2];
        for(int i=0;i<routes.length;i++){
            position[i] = new int[]{points[routes[i][0]-1][0], points[routes[i][0]-1][1]};
        }
        for(int i=minY;i<=maxY;i++){
            for(int j=minX;j<=maxX;j++){
                int robot = 0;
                for(int k=0;k<position.length;k++){
                    if(i == position[k][0] && j == position[k][1]) robot++;
                    if(robot > 1){
                        answer++;
                        break;
                    }
                }
            }
        }
        
        int[] arrived = new int[routes.length];
        int count = 0;
        while(true){
            for(int i=0;i<routes.length;i++){
                if(arrived[i] == m-1) continue;
                int endY = points[routes[i][arrived[i]+1]-1][0];
                int endX = points[routes[i][arrived[i]+1]-1][1];
                
                if(position[i][0] != endY){
                    if(position[i][0] > endY) position[i][0]--;
                    else position[i][0]++;
                } else if(position[i][1] != endX){
                    if(position[i][1] > endX) position[i][1]--;
                    else position[i][1]++;
                } 
                if(position[i][0] == endY && position[i][1] == endX){
                    arrived[i]++;
                    if(arrived[i] == m-1){
                        count++;
                    }
                }
            }
            for(int i=minY;i<=maxY;i++){
                for(int j=minX;j<=maxX;j++){
                    int robot = 0;
                    for(int k=0;k<position.length;k++){
                        if(i == position[k][0] && j == position[k][1]) robot++;
                        if(robot > 1){
                            answer++;
                            break;
                        }
                    }
                }
            }
            for(int i=0;i<routes.length;i++){
                if(arrived[i] == m-1) position[i] = new int[]{0,0};
            }
            if(count == routes.length) break;
        }
        return answer;
    }
}