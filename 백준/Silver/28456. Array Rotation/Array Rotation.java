import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        StringTokenizer st;
        for(int i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int Q = Integer.parseInt(br.readLine());
        for(int q=0;q<Q;q++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = 0;
            if(st.hasMoreTokens()){
                b = Integer.parseInt(st.nextToken());
            }
            if(a==1){
                func1(b);
            } else if (a==2) {
                func2();
            }
        }
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void func1(int b){
        int tmp = arr[b][N];
        for(int i=N;i>0;i--){
            arr[b][i] = arr[b][i-1];
        }
        arr[b][1] = tmp;
    }
    static void func2(){
        int[][] tmpArr = new int[N+1][N+1];
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                tmpArr[j][N-i+1] = arr[i][j];
            }
        }
        arr = tmpArr;
    }
}