import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        char[][] chess = new char[n][m];

        for(int i=0;i<n;i++){
            String input = br.readLine();
            for(int j=0;j<m;j++){
                chess[i][j] = input.charAt(j);
            }
        }

        char[][] originChess1 = new char[n][m];
        char[][] originChess2 = new char[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i+j) % 2 == 0) {
                    originChess1[i][j] = 'W';
                    originChess2[i][j] = 'B';
                } else {
                    originChess1[i][j] = 'B';
                    originChess2[i][j] = 'W';
                }
            }
        }

        int[][] diff1 = new int[n+1][m+1];
        int[][] diff2 = new int[n+1][m+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(originChess1[i][j] != chess[i][j]) {
                    diff1[i+1][j+1] = 1;
                }
                if(originChess2[i][j] != chess[i][j]) {
                    diff2[i+1][j+1] = 1;
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                diff1[i][j] = diff1[i-1][j] + diff1[i][j-1] + diff1[i][j] - diff1[i-1][j-1];
                diff2[i][j] = diff2[i-1][j] + diff2[i][j-1] + diff2[i][j] - diff2[i-1][j-1];
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=k;i<=n;i++){
            for(int j=k;j<=m;j++){
                int x1 = diff1[i][j] - diff1[i-k][j] - diff1[i][j-k] + diff1[i-k][j-k];
                int x2 = diff2[i][j] - diff2[i-k][j] - diff2[i][j-k] + diff2[i-k][j-k];
                min = Math.min(min, Math.min(x1, x2));
            }
        }
        System.out.println(min);
    }
}