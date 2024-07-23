class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] blocks = new char[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                blocks[i][j] = board[i].charAt(j);
            }
        }
        int count = 0;
        while(true){
            boolean stop = true;
            boolean deleteBlocks[][] = new boolean[m][n];
            for(int i=0;i<m-1;i++){
                for(int j=0;j<n-1;j++){
                    if(blocks[i][j] != '-' &&
                            blocks[i][j] == blocks[i+1][j] &&
                            blocks[i][j] == blocks[i][j+1] &&
                            blocks[i][j] == blocks[i+1][j+1]){
                        deleteBlocks[i][j] = true;
                        deleteBlocks[i][j+1] = true;
                        deleteBlocks[i+1][j] = true;
                        deleteBlocks[i+1][j+1] = true;
                        stop = false;
                    }
                }
            }
            if(stop) break;

            for(int i=0;i<n;i++){
                int index = m-1;
                for(int j=m-1;j>=0;j--){
                    if(deleteBlocks[j][i]){
                        continue;
                    }
                    blocks[index][i] = blocks[j][i];
                    index--;
                }
                for(int j=index;j>=0;j--){
                    blocks[j][i] = '-';
                    count++;
                }
            }
        }

        return count;
    }
}