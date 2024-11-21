import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=1;t<=T;t++) {
            int n = Integer.parseInt(br.readLine());
            char[][] board = new char[n][n];
            for(int i=0;i<n;i++){
                String input = br.readLine();
                for(int j=0;j<n;j++) {
                    board[i][j] = input.charAt(j);
                }
            }

            int maxY = 0, minY = 20, maxX = 0, minX = 20;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(board[i][j] == '#'){
                        maxY = Math.max(maxY, i);
                        minY = Math.min(minY, i);
                        maxX = Math.max(maxX, j);
                        minX = Math.min(minX, j);
                    }
                }
            }

            boolean check = true;
            for(int i=minY;i<=maxY;i++){
                for(int j=minX;j<=maxX;j++){
                    if(board[i][j] != '#'){
                        check = false;
                    }
                }
            }
            if(Math.abs(maxY - minY) != Math.abs(maxX - minX)) check = false;
            System.out.print("#"+t+" ");
            if(check){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}