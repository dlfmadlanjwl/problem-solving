import java.io.*;
import java.util.*;


public class Main {
    static Long[][] list;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new Long[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                list[i][j] = sum(i,j)%1000000007;
            }
        }
        System.out.print(list[n][m]);
    }
    static Long sum(int i, int j){
        if(i==0||j==0)return 0L;
        if(i==1&&j==1)return 1L;

        return list[i - 1][j] + list[i][j - 1] + list[i - 1][j - 1];
    }
}