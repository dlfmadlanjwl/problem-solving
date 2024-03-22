import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] check = new boolean[100][100];

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for(int j=a;j<a+10;j++){
                for(int k=99-b;k>89-b;k--){
                    check[j][k] = true;
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<100;i++){
            for(int j=0;j<100;j++){
                if(check[i][j]){
                    cnt++;
                }
            }
        }

        System.out.print(cnt);
    }
}