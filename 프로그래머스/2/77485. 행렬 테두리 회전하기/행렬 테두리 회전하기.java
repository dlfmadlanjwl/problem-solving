class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] table = new int[rows][columns];
        int seq = 1;
        for(int i=0;i<table.length;i++){
            for(int j=0;j<table[0].length;j++){
                table[i][j] = seq++;
            }
        }
        
        int[] answer = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int[] query = queries[i];
            answer[i] = rotate(query[0]-1, query[1]-1, query[2]-1, query[3]-1, table);
        }
        
        return answer;
    }
    
    int rotate(int y1, int x1, int y2, int x2, int[][] table){
        int firstNum = table[y1][x1];
        int min = firstNum;
        
        for(int i=y1+1;i<=y2;i++){
            table[i-1][x1] = table[i][x1];
            min = Math.min(min, table[i][x1]);
        }
        for(int i=x1+1;i<=x2;i++){
            table[y2][i-1] = table[y2][i];
            min = Math.min(min, table[y2][i]);
        }
        for(int i=y2-1;i>=y1;i--){
            table[i+1][x2] = table[i][x2];
            min = Math.min(min, table[i][x2]);
        }
        for(int i=x2-1;i>x1;i--){
            table[y1][i+1] = table[y1][i];
            min = Math.min(min, table[y1][i]);
        }
        table[y1][x1+1] = firstNum;
        
        return min;
    }
}