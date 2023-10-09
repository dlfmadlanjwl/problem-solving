import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] check;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int n = (N-1)*4+1;
        check = new int[n][n];
        recursive(0,n-1);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(check[i][j]==1)System.out.print("*");
                else System.out.print(" ");
            }
            System.out.println();
        }
    }
    static void recursive(int n, int m){
        if(m-n<0)return;
        for(int i=n;i<=m;i++){
            for(int j=n;j<=m;j++){
                if(i==n||j==n||i==m||j==m){
                    check[i][j] = 1;
                }
            }
        }
        recursive(n+2,m-2);
    }
}
